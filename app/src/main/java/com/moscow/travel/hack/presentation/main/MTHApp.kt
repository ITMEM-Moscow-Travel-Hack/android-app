package com.moscow.travel.hack.presentation.main

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.moscow.travel.hack.presentation.theme.MoscowTravelHackAppTheme

@Composable
fun MTHApp(appState: AppState) {
    MoscowTravelHackAppTheme {
        Scaffold(
            scaffoldState = appState.scaffoldState,
        ) {
            MTHNavHost(
                navController = appState.navController,
                startDestination = appState.getStartDestination()
            )
        }
    }
}