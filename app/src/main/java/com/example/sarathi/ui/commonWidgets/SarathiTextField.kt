package com.example.sarathi.ui.commonWidgets

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.sarathi.ui.theme.Sarathi_Yellow

@Composable
fun SarathiTextField(
    value: String,
    textStyle: TextStyle,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text,
    label: String = "",
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                maxLines = 1,
                textAlign = TextAlign.Center,
                color = Sarathi_Yellow
            )
        },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        modifier = modifier
            .padding(vertical = 10.dp, horizontal = 50.dp)
            .wrapContentHeight()
            .wrapContentWidth(),
        textStyle = textStyle,
        maxLines = 1,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Sarathi_Yellow,
            cursorColor = Sarathi_Yellow,
            focusedBorderColor = Sarathi_Yellow,
            unfocusedBorderColor = Sarathi_Yellow,
        )
    )
}