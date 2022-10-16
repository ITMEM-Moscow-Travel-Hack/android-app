package com.moscow.travel.hack.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.moscow.travel.hack.presentation.ui.interests.InterestsScreen
import com.moscow.travel.hack.presentation.ui.greeting.onboarding.OnboardingScreen
import com.moscow.travel.hack.presentation.ui.recommendation.MainRecommendationsScreen
import com.moscow.travel.hack.presentation.ui.greeting.welcome.WelcomeScreen
import com.moscow.travel.hack.presentation.ui.main.MainScreen
import com.moscow.travel.hack.presentation.ui.suggestions.SuggestionsScreen
import timber.log.Timber

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
                onSignUpClick = { navController.navigate(InterestsSections.MAIN.route) },
                onLoginClick = { navController.navigate(InterestsSections.MAIN.route) }
            )
        }
        composable(InterestsSections.MAIN.route) {
            InterestsScreen(onSaveClick = { navController.navigate(MainSections.MAIN.route) })
        }
        composable(MainSections.MAIN.route) {
            MainScreen(
                onSuggestionsClick = {
                    Timber.e("GOING SUGGESTIONS")
                    navController.navigate(MainSections.SUGGESTIONS.route)
                }
            )
        }
        composable(MainSections.SUGGESTIONS.route) {
            SuggestionsScreen(
                onBackPressed = { navController.navigateUp() },
                onStartClick = {
                    Timber.e("START SEARCH")
                    navController.navigate(RecommendationsSections.MAIN.route)
                }
            )
        }
        composable(RecommendationsSections.MAIN.route) {
            MainRecommendationsScreen(
                onBackPressed = { navController.navigateUp() }
            )
        }
    }
}