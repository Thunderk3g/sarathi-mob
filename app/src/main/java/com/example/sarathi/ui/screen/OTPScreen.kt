package com.example.sarathi.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sarathi.Routes
import com.example.sarathi.ui.commonWidgets.SarathiButton
import com.example.sarathi.ui.commonWidgets.SarathiTextField
import com.example.sarathi.ui.theme.Sarathi_Yellow

@Composable
fun OTPScreen(
    navController: NavHostController
) {
    var otp by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "OTP",
            style = TextStyle(
                fontSize = 40.sp,
                color = Sarathi_Yellow,
                fontWeight = FontWeight.Bold
            )
        )

        SarathiTextField(
            value = otp,
            onValueChange = { otpText ->
                if (otpText.length <= 6) {
                    otp = otpText
                }
            },
            label = "",
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Start,
                fontSize = 25.sp,
                letterSpacing = TextUnit(25f, TextUnitType.Sp),
                fontWeight = FontWeight.Bold
            ),
            keyboardType = KeyboardType.Number
        )

        SarathiButton(
            onClick = {
                navController.navigate(Routes.Home.route) {
                    popUpTo(Routes.OTPScreen.route) { inclusive = true }
                    launchSingleTop = true
                }
            },
            text = "VERIFY OTP"
        )
    }
}