package com.example.sarathi.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
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
import com.example.sarathi.Routes
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
        Routes.Home,
        Routes.OrderHistory,
        Routes.Profile
    )

    Surface {
        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet(
                    drawerContainerColor = Color.White,
                    drawerContentColor = Color.Black
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
                        NavigationDrawerItem(
                            label = {
                                Text(
                                    text = drawerItem.route,
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedContainerColor = Baby_Yellow,
                                unselectedContainerColor = Color.White,
                                selectedTextColor = Color.Black,
                                unselectedTextColor = Color.Black,
                            ),
                            selected = index == selectedItemIndex,
                            onClick = {
                                selectedItemIndex = index
                                scope.launch {
                                    navigationState.close()
                                }
                            },
                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )

                    }
                }
            },
            drawerState = navigationState,
        ) {
            Scaffold(
                containerColor = Color.Black,
                topBar = {
                    TopAppBar(
                        colors = topAppBarColors(containerColor = Color.Black),
                        title = {
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
                                        fontWeight = FontWeight.Bold,
                                        fontStyle = FontStyle.Italic
                                    ),
                                    modifier = Modifier
                                        .padding(start = 20.dp)
                                        .wrapContentWidth()
                                )
                            }
                        },
                        navigationIcon = {
                            IconButton(
                                modifier = Modifier.padding(start = 25.dp, top = 5.dp),
                                onClick = {
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
