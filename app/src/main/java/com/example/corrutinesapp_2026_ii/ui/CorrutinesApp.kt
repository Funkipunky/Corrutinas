package com.example.corrutinesapp_2026_ii.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.corrutinesapp_2026_ii.R
import com.example.corrutinesapp_2026_ii.viewmodel.MainViewModel

@Composable
fun CorrutinesApp(mainVM: MainViewModel, modifier: Modifier = Modifier) {

    var changeColor by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { changeColor = !changeColor },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (changeColor) Color(0xFF42A5F5) else Color(0xFFEF5350)
            )
        ) {
            Text(text = stringResource(R.string.cambio_de_color))
        }
        
        Spacer(modifier = Modifier.height(30.dp))
        
        Text(
            text = "Contador 1: ${mainVM.countTime} [s]", 
            fontSize = 18.sp, 
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "Contador 2: ${mainVM.countTime2} [s]", 
            fontSize = 18.sp, 
            fontWeight = FontWeight.Medium
        )
        
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = mainVM.resultState, fontSize = 16.sp)
        
        Spacer(modifier = Modifier.height(30.dp))
        
        Button(
            onClick = { mainVM.fetchData() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF66BB6A))
        ) {
            Text(text = stringResource(R.string.realizar_consulta))
        }
        
        Spacer(modifier = Modifier.height(10.dp))
        
        Button(
            onClick = { mainVM.cancelJob() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF757575))
        ) {
            Text(text = "Cancelar Consulta")
        }
    }
}
