package com.example.corrutinesapp_2026_ii.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.corrutinesapp_2026_ii.R
import com.example.corrutinesapp_2026_ii.viewmodel.MainViewModel

@Composable
fun CorrutinesApp(mainVM: MainViewModel, modifier: Modifier = Modifier) {

    var changeColor by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                changeColor = !changeColor
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (changeColor) Color.Blue else Color.Red
            )
        ) {
            Text(text = stringResource(R.string.cambio_de_color))
        }
        
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Contador 1: ${mainVM.countTime} [s]")
        Text(text = "Contador 2: ${mainVM.countTime2} [s]")
        
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = mainVM.resultState)
        
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
            mainVM.fetchData()
        }) {
            Text(text = stringResource(R.string.realizar_consulta))
        }
        
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                mainVM.cancelJob()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
        ) {
            Text(text = "Cancelar Consulta")
        }
    }
}
