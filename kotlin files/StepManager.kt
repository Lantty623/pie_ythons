/*  ACKNOWLEDGEMENTS
    This was file was made with help from Android Developer Codelabs, in particular the one linked below:
    https://developer.android.com/codelabs/health-connect#0
    The structure of this file is based on the structure of HealthConnectManager.kt in the codelab above.
 */

package com.example.healthrecord

import android.content.Context
import android.os.Build
import androidx.activity.result.contract.ActivityResultContract
import androidx.health.connect.client.HealthConnectClient
import androidx.health.connect.client.PermissionController
import androidx.health.connect.client.permission.HealthPermission
import androidx.health.connect.client.request.AggregateRequest
import androidx.health.connect.client.time.TimeRangeFilter
import java.time.Instant
import androidx.compose.runtime.mutableStateOf
import androidx.health.connect.client.HealthConnectClient.Companion.sdkStatus
import androidx.health.connect.client.changes.Change
import androidx.health.connect.client.records.*
import androidx.health.connect.client.request.ChangesTokenRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

//Represents if HealthConnect APK is installed, is not installed but is supported,
//or if it is not supported at all
enum class HCAvailability {
    INSTALLED,
    NOT_INSTALLED,
    NOT_SUPPORTED
}

const val MIN_SUPPORTED_SDK = Build.VERSION_CODES.O_MR1

class StepManager(private val c : Context){

    //Instantiate a HealthConnectClient object, which will let us access step data
    private val hcc by lazy { HealthConnectClient.getOrCreate(c) }

    //Used to let us make determine if the HealthConnect APK is available
    var availability = mutableStateOf(HCAvailability.NOT_SUPPORTED)
        private set

    //Permissions required for getting steps from Health Connect
    val permissions = setOf(
        HealthPermission.getReadPermission(StepsRecord::class)
    )

    // Helper class that represents possible messages retrieved when getting changes from change tokens
    sealed class ChangesMessage {
        data class NoMoreChanges(val nextChangesToken: String) : ChangesMessage()
        data class ChangeList(val changes: List<Change>) : ChangesMessage()
    }

    //Upon initialization, see if Health Connect APK is available
    init {
        checkAvailability()
    }

    //Sees if Health Connect APK is at least supported on the current device version
    private fun isSupported() = Build.VERSION.SDK_INT >= MIN_SUPPORTED_SDK

    //Updates availability status of Health Connect APK
    private fun checkAvailability() {
        availability.value = when {
            sdkStatus(c) == HealthConnectClient.Companion.SDK_AVAILABLE -> HCAvailability.INSTALLED
            isSupported() -> HCAvailability.NOT_INSTALLED
            else -> HCAvailability.NOT_SUPPORTED
        }
    }

    //Checks if we have all the permissions we need to access Health Connect
    suspend fun hasPerms(): Boolean {
        return hcc.permissionController.getGrantedPermissions().containsAll(permissions)
    }

    //Opens a request for Health Connect permissions
    fun requestPerms(): ActivityResultContract<Set<String>, Set<String>> {
        return PermissionController.createRequestPermissionResultContract()
    }

    //Fetches the number of steps in the given time range
    private suspend fun retrieveSteps(start: Instant, end: Instant): Long? {
        val response =
            hcc.aggregate(
                AggregateRequest(
                    metrics = setOf(StepsRecord.COUNT_TOTAL),
                    timeRangeFilter = TimeRangeFilter.between(start, end)
                )
            )
        return response[StepsRecord.COUNT_TOTAL]
    }

    //Obtains a change token for steps
    suspend fun getChangesToken(): String {
        return hcc.getChangesToken(
            ChangesTokenRequest(
                setOf(
                    StepsRecord::class
                )
            )
        )
    }

    //Gets changes from the given token
    suspend fun getChangesFromToken(token: String): Flow<ChangesMessage> = flow {
        var nextChangesToken = token
        do {
            val response = hcc.getChanges(nextChangesToken)
            if (response.changesTokenExpired) {
                throw IOException("Changes token has expired")
            }
            emit(ChangesMessage.ChangeList(response.changes))
            nextChangesToken = response.nextChangesToken
        } while (response.hasMore)
        emit(ChangesMessage.NoMoreChanges(nextChangesToken))
    }
}