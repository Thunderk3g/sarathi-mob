package com.example.sarathi.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sarathi.Routes
import com.example.sarathi.ui.commonWidgets.SarathiButton
import com.example.sarathi.ui.commonWidgets.SarathiTextField
import com.example.sarathi.ui.theme.APP_NAME
import com.example.sarathi.ui.theme.DarkGrey
import com.example.sarathi.ui.theme.RoseRed
import com.example.sarathi.ui.theme.Sarathi_Yellow

@Composable
fun OnBoardingScreen(
    navController: NavHostController,
) {

    val showDialog = remember { mutableStateOf(false) }
    val alertMessage = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var contact by remember { mutableStateOf("") }

        Text(
            text = APP_NAME,
            style = TextStyle(
                fontSize = 40.sp,
                color = Sarathi_Yellow,
                fontWeight = FontWeight.Bold
            )
        )

        SarathiTextField(
            label = "Email / Mobile",
            value = contact,
            onValueChange = { contactText ->
                contact = contactText
            },
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Normal
            ),
            keyboardType = KeyboardType.Text
        )

        SarathiButton(
            onClick = {
                navController.navigate(Routes.OTPScreen.route) {
                    popUpTo(Routes.OnBoardingScreen.route) { inclusive = true }
                    launchSingleTop = true
                }
            },
            text = "GET OTP",
        )
    }

    @Composable
    fun SimpleAlertDialog(message: String) {
        AlertDialog(
            onDismissRequest = { },
            confirmButton = {
                TextButton(onClick = {
                    showDialog.value = false
                    alertMessage.value = ""
                }) {
                    Text(
                        text = "OK",
                        fontSize = 15.sp,
                        color = RoseRed,
                        style = TextStyle(fontWeight = FontWeight.Bold)
                    )
                }
            },
            title = {
                Text(
                    text = "Invalid Login Credentials",
                    fontSize = 20.sp,
                    color = RoseRed,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            },
            text = {
                Text(
                    text = message,
                    fontSize = 15.sp,
                    color = DarkGrey,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }
        )
    }

    if (showDialog.value) {
        SimpleAlertDialog(alertMessage.value)
    }
}