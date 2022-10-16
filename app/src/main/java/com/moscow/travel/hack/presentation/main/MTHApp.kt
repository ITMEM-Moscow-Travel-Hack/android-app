package com.moscow.travel.hack.presentation.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moscow.travel.hack.presentation.theme.MoscowTravelHackAppTheme

@Composable
fun MTHApp(appState: AppState) {
    MoscowTravelHackAppTheme {
        Scaffold(
            scaffoldState = appState.scaffoldState,
        ) { innerPadding ->
            MTHNavHost(
                modifier = Modifier.padding(innerPadding),
                navController = appState.navController,
                startDestination = appState.getStartDestination()
            )
        }
    }
}