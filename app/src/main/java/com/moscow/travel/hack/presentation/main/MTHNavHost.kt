package com.moscow.travel.hack.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.moscow.travel.hack.presentation.ui.greeting.interests.InterestsScreen
import com.moscow.travel.hack.presentation.ui.greeting.onboarding.OnboardingScreen
import com.moscow.travel.hack.presentation.ui.greeting.recomendation.StartSearchScreen
import com.moscow.travel.hack.presentation.ui.greeting.recomendation.TinderScreen
import com.moscow.travel.hack.presentation.ui.greeting.welcome.WelcomeScreen

@Composable
fun MTHNavHost(
    navController: NavHostController, startDestination: String, modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController, startDestination = startDestination
    ) {
        // Greeting
        composable(GreetingSections.WELCOME.route) {
            WelcomeScreen(onContinueClick = { navController.navigate(GreetingSections.ONBOARDING.route) })
        }
        composable(GreetingSections.ONBOARDING.route) {
            OnboardingScreen(
                onSignUpClick = { navController.navigate(MapSections.MAIN.route) },
                onLoginClick = { navController.navigate(MapSections.MAIN.route) }
            )
        }
        composable(InterestsSections.MAIN.route) {
            InterestsScreen(onSaveClick = {  })
        }
        composable(RecomendationsSections.START_SEARCH.route) {
            StartSearchScreen()
        }
        composable(RecomendationsSections.TINDER.route) {
            TinderScreen()
        }
        // Map todo
    }
}