package com.example.myapplication2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ViewModelTest : ViewModel() {
    private val _uiState = MutableStateFlow(DataState())
    val uiState: StateFlow<DataState> = _uiState.asStateFlow()

    init {
        _uiState.value.current_steps = 0 // change 0 to # of steps from api call
    }
}