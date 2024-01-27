package com.example.sarathi

sealed class Routes(val route: String) {
    data object OnBoardingScreen : Routes("OnBoarding")
    data object OTPScreen : Routes("OTPScreen")
    data object Home : Routes("Home")
    data object Profile : Routes("Profile")
    data object OrderHistory : Routes("History")

}
