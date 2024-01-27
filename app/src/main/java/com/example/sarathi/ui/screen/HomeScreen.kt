package com.example.sarathi.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sarathi.R
import androidx.navigation.NavHostController
import com.example.sarathi.Routes
import com.example.sarathi.ui.theme.Sarathi_Yellow

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Column {
        TopBar(navController)
    }
}

@Composable
fun TopBar(navController: NavHostController) {
    Row(
        Modifier.fillMaxWidth().padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "SARATHI",
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            color = Sarathi_Yellow,
            style = TextStyle(fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic),
            modifier = Modifier.padding(16.dp).wrapContentWidth()
        )
        Row {
            IconButton(
                onClick = {
                    navController.navigate(Routes.OnBoardingScreen.route) {
                        popUpTo(Routes.Home.route) { inclusive = true }
                        launchSingleTop = true
                    }
                },
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.logout),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(Sarathi_Yellow),
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    }
}
