package com.example.animalstepper.navigation.screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.animalstepper.data.StepManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

class ViewModelTest(private val stepManager : StepManager) : ViewModel() {
    var footsteps : MutableState<Long?> = mutableStateOf(0)
        private set

    /*
    //NOTE: Look at codelab, implement this if we want to, requires a helper class

    var uiState: UiState by mutableStateOf(UiState.Uninitialized)
        private set
    */


    fun initialLoad(){
        viewModelScope.launch{
            getStepsLastDay()
        }
    }

    //Updates footsteps to the number of footsteps recorded in the last day
    private suspend fun getStepsLastDay(){
        val startOfDay = ZonedDateTime.now().minus(24, ChronoUnit.HOURS).toInstant()
        val now = Instant.now()
        footsteps.value = stepManager.retrieveSteps(startOfDay, now)
    }
}