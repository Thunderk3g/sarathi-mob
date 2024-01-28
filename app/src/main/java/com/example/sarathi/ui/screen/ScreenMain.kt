package com.example.sarathi.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sarathi.R
import com.example.sarathi.ui.commonUi.DrawerItem
import com.example.sarathi.ui.commonUi.Routes
import com.example.sarathi.ui.theme.Baby_Yellow
import kotlinx.coroutines.launch

@SuppressLint("UnrememberedMutableState")
@Composable
fun ScreenMain() {
    val navController = rememberNavController()
    val navigationState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    val items = listOf(
        DrawerItem(
            title = Routes.Home.route,
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
        ),
        DrawerItem(
            title = Routes.Profile.route,
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
        ),
        DrawerItem(
            title = Routes.PastRides.route,
            selectedIcon = Icons.Filled.DateRange,
            unselectedIcon = Icons.Outlined.DateRange,
        ),
        DrawerItem(
            title = Routes.Addresses.route,
            selectedIcon = Icons.Filled.LocationOn,
            unselectedIcon = Icons.Outlined.LocationOn,
        ),
        DrawerItem(
            title = Routes.Settings.route,
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
        ),
    )

    Surface {
        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet(
                    drawerContainerColor = Color.White, drawerContentColor = Color.Black
                ) {
                    Spacer(modifier = Modifier.height(26.dp))
                    Image(
                        painter = painterResource(id = R.drawable.sarathi_logo),
                        contentDescription = "",
                        modifier = Modifier
                            .size(150.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(26.dp))
                    items.forEachIndexed { index, drawerItem ->
                        NavigationDrawerItem(label = {
                            Text(
                                text = drawerItem.title, fontWeight = FontWeight.Bold
                            )
                        }, colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = Baby_Yellow,
                            unselectedContainerColor = Color.White,
                            selectedTextColor = Color.Black,
                            unselectedTextColor = Color.Black,
                        ), selected = index == selectedItemIndex, onClick = {
                            selectedItemIndex = index
                            navController.navigate(drawerItem.title)
                            scope.launch {
                                navigationState.close()
                            }
                        }, icon = {
                            Icon(
                                imageVector = if (index == selectedItemIndex) {
                                    drawerItem.selectedIcon
                                } else drawerItem.unselectedIcon,
                                contentDescription = drawerItem.title,
                                tint = Color.Black
                            )
                        }, modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                    DrawerFooter()
                }
            },
            drawerState = navigationState,
        ) {
            NavHost(navController = navController, startDestination = Routes.Home.route) {

                composable(Routes.OnBoardingScreen.route) {
                    OnBoardingScreen(navController = navController)
                }

                composable(Routes.OTPScreen.route) {
                    OTPScreen(navController = navController)
                }

                composable(Routes.Home.route) {
                    HomeScreen(navController = navController)
                }

                composable(Routes.Profile.route) {
                    ProfileScreen(navController = navController)
                }

                composable(Routes.PastRides.route) {
                    PastRides(navController = navController)
                }

                composable(Routes.Addresses.route) {
                    AddressesScreen(navController = navController)
                }

                composable(Routes.Settings.route) {
                    SettingsScreen(navController = navController)
                }
            }
        }
    }
}

@Composable
fun DrawerFooter() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 10.dp)
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            text = "Contact Sarathi Team",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.SemiBold,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Call,
                    modifier = Modifier.size(18.dp),
                    contentDescription = "Call"
                )
            }
            Spacer(modifier = Modifier.size(12.dp))
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    modifier = Modifier.size(18.dp),
                    contentDescription = "Mail"
                )
            }
        }
    }
}