package com.example.corrutinesapp_2026_ii.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var resultState by mutableStateOf("")
        private set

    var countTime by mutableIntStateOf(0)
        private set

    var countTime2 by mutableIntStateOf(0)
        private set

    private var job: Job? = null

    fun fetchData() {
        job?.cancel()
        
        job = viewModelScope.launch {
            // Reset counters
            countTime = 0
            countTime2 = 0
            resultState = "Iniciando contadores..."

            Contador1()
            Contador2()
            
            resultState = "Respuesta obtenida de la Web"
        }
    }

    private suspend fun Contador1() {
        for (i in 1..10) {
            delay(1000)
            countTime = i
        }
    }

    private suspend fun Contador2() {
        for (i in 1..10) {
            delay(1000)
            countTime2 = i
        }
    }

    fun cancelJob() {
        job?.cancel()
        resultState = "Proceso cancelado"
    }
}
