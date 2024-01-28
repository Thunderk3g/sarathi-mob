package com.example.sarathi.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sarathi.ui.theme.APP_NAME
import com.example.sarathi.ui.theme.Sarathi_Yellow
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController, navigationState: DrawerState) {
    val scope = rememberCoroutineScope()
    Scaffold(containerColor = Color.Black, topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black),
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
                            fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic
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
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Home",
                style = TextStyle(
                    fontSize = 40.sp,
                    color = Sarathi_Yellow,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}
