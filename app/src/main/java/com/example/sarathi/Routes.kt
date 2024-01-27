package com.example.sarathi

sealed class Routes(val route: String) {
    object OnBoardingScreen : Routes("OnBoarding")
    object OTPScreen : Routes("OTPScreen")
    object Home : Routes("Home")

}
