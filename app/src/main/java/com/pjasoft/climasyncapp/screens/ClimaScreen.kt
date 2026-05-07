package com.pjasoft.climasyncapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pjasoft.climasyncapp.components.SensorTag
import com.pjasoft.climasyncapp.ui.theme.ClimaSyncAppTheme
import com.pjasoft.climasyncapp.ui.theme.SkyBlue

@Composable
fun ClimaScreen(
    innerPadding : PaddingValues,
    onSpinClick : (String) -> Unit = { },
    onDisconnect : () -> Unit = {  },
    onConnect: () -> Boolean = { false },
    temp: Double = 0.0,
    hum: Double = 0.0
) {
    val colors = MaterialTheme.colorScheme
    var isOn by remember {
        mutableStateOf(false)
    }
    var isConnected by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(colors.background),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(top = 30.dp),
            text = "ClimaSync",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = colors.primary
        )
        Text(
            text = "Monitor de clima",
            color = colors.onBackground.copy(alpha = 0.6f)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            SensorTag(
                modifier = Modifier.weight(1f),
                title = "Temperatura",
                value = temp,
                unit = "°C"
            )
            SensorTag(
                modifier = Modifier.weight(1f),
                title = "Humedad",
                value = hum,
                unit = "%"
            )
        }

        Column(
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .background(if(isOn) SkyBlue else Color.Gray)
                .clickable{
                    isOn = !isOn
                    if(isOn){
                        onSpinClick("1")
                    }
                    else{
                        onSpinClick("0")
                    }
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = if(isOn) "ON" else "OFF",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "Ventilador",
                fontSize = 14.sp,
                color = Color.White.copy(alpha = 0.8f)
            )
        }

        Text(
            text = if(isConnected) "Conectado" else "Desconectado"
        )

        Button(
            onClick = {
                if(isConnected){
                    onDisconnect()
                }
                else{
                    onConnect()
                }
                isConnected = !isConnected
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = if(!isConnected) colors.primary else Color.Red.copy(alpha = 0.6f)
            )
        ) {
            Text(
                text = if(isConnected) "Desconectarse" else "Conectarse"
            )
        }

    }
}
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ClimaScreenPreview(){
    ClimaSyncAppTheme {
        ClimaScreen(
            innerPadding = PaddingValues(0.0.dp)
        )
    }
}
