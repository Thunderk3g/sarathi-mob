package com.example.sarathi.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sarathi.R
import androidx.navigation.NavHostController
import com.example.sarathi.ui.commonUi.DrawerItem
import com.example.sarathi.ui.commonUi.Routes
import com.example.sarathi.ui.theme.APP_NAME
import com.example.sarathi.ui.theme.Baby_Yellow
import com.example.sarathi.ui.theme.Sarathi_Yellow
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
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
            Scaffold(containerColor = Color.Black, topBar = {
                TopAppBar(colors = topAppBarColors(containerColor = Color.Black), title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = APP_NAME,
                            fontSize = 30.sp,
                            textAlign = TextAlign.Center,
                            color = Sarathi_Yellow,
                            style = TextStyle(
                                fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic
                            ),
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .wrapContentWidth()
                        )
                    }
                }, navigationIcon = {
                    IconButton(modifier = Modifier.padding(start = 25.dp, top = 5.dp), onClick = {
                        scope.launch {
                            navigationState.open()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu",
                            tint = Sarathi_Yellow
                        )
                    }
                })
            }) {
                Log.d("TAG", "HomeScreen: $it")
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
