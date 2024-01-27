package com.example.sarathi.ui.screen

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sarathi.Routes

@SuppressLint("UnrememberedMutableState")
@Composable
fun ScreenMain() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.OnBoardingScreen.route) {

        composable(Routes.OnBoardingScreen.route) {
            OnBoardingScreen(navController = navController)
        }

        composable(Routes.OTPScreen.route) {
            OTPScreen(navController = navController)
        }

        composable(Routes.Home.route) {
            HomeScreen(navController = navController)
        }
    }
}