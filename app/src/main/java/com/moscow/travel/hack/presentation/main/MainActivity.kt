package com.moscow.travel.hack.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import com.onesignal.OneSignal
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var appState: AppState
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initOneSignalNotificationListener()
        setContent {
            appState = rememberAppState()
            navController = appState.navController
            MTHApp(appState)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navController.handleDeepLink(intent)
    }

    private fun initOneSignalNotificationListener() {
        OneSignal.setNotificationOpenedHandler {
            val data = it.notification.additionalData
        }
    }
}