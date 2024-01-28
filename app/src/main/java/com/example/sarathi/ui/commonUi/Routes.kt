package com.example.sarathi.ui.commonUi

sealed class Routes(val route: String) {
    data object OnBoardingScreen : Routes("OnBoarding")
    data object OTPScreen : Routes("OTPScreen")
    data object Home : Routes("Home")
    data object Profile : Routes("Profile")
    data object PastRides : Routes("Past Rides")
    data object Addresses : Routes("Addresses")
    data object Settings : Routes("Settings")
}
