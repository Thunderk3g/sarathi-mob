package com.example.sarathi.ui.commonWidgets

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OSText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 15.sp,
    textAlign: TextAlign = TextAlign.Start,
    style: TextStyle
) {
    Text(
        text = text,
        fontSize = fontSize,
        textAlign = textAlign,
        style = style,
        modifier = modifier.padding(10.dp).wrapContentWidth()
    )
}