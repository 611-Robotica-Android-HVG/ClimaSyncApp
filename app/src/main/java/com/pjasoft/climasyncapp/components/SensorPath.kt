package com.pjasoft.climasyncapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SensorTag(
    modifier: Modifier,
    title : String,
    value : Double,
    unit : String

) { //pasar el modifier del otro archivo
    val colors = MaterialTheme.colorScheme
    Column(
        modifier = modifier
            .shadow(
                5.dp,
                shape = RoundedCornerShape(20.dp)
            )
            .clip(RoundedCornerShape(20.dp))
            .background(colors.surface)
            .padding(vertical = 20.dp, horizontal = 15.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            color = colors.onSurface.copy(alpha = 0.5f),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = value.toString(),
                color = colors.primary,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = unit,
                color = colors.secondary,
                modifier = Modifier.padding(start = 3.dp)
            )
        }
    }
}