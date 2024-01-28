package com.example.sarathi.ui.commonUi

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sarathi.ui.theme.Sarathi_Yellow

@Composable
fun SarathiButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    shape: RoundedCornerShape = RoundedCornerShape(50.dp)
    ){
    Button(
        modifier = modifier
            .padding(vertical = 10.dp, horizontal = 40.dp)
            .wrapContentWidth()
            .wrapContentHeight(),
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Sarathi_Yellow
        ),
        shape = shape,
        border = BorderStroke(3.dp, Sarathi_Yellow),
    ) {
        Text(
            text = text,
            style = TextStyle(fontSize = 20.sp,fontWeight = FontWeight.Bold)
        )
    }
}