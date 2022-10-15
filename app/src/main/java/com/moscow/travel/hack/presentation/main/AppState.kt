package com.moscow.travel.hack.presentation.main

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.moscow.travel.hack.R
import com.moscow.travel.hack.presentation.main.MainDestinations.GREETING

class AppState(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController
) {
    private fun getNoTopBarRoutes(): List<String> {
        val list = mutableListOf<String>()
        GreetingSections.values().forEach {
            list.add(it.route)
        }
        return list
    }

    @Composable
    fun getStartDestination(): String {
        return RecomendationsSections.START_SEARCH.route
    }

    private fun shouldHideTopBar(route: String?): Boolean {
        return false
    }

    val shouldShowTopBar: Boolean
        @Composable get() = !shouldHideTopBar(
            navController
                .currentBackStackEntryAsState().value?.destination?.route
        )
    val currentDestination: String
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination?.route ?: ""
    val currentRoute: String?
        get() = navController.currentDestination?.route

    fun upPress() {
        navController.navigateUp()
    }

    @Composable
    fun currentTopBarTitle(): Int {
        return when (currentDestination.substringBefore("/")) {
            GREETING -> {
                R.string.app_name
            }
            else -> R.string.app_name
        }
    }
}

@Composable
fun rememberAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController()
) =
    remember(scaffoldState, navController) {
        AppState(scaffoldState, navController)
    }