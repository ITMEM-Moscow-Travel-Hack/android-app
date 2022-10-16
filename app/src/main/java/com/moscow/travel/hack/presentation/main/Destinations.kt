package com.moscow.travel.hack.presentation.main

import com.moscow.travel.hack.presentation.main.MainDestinations.GREETING
import com.moscow.travel.hack.presentation.main.MainDestinations.INTEREST
import com.moscow.travel.hack.presentation.main.MainDestinations.RECOMENDATIONS

object MainDestinations {
    const val GREETING = "greeting"
    const val INTEREST = "interest"
    const val MAIN = "main"
    const val RECOMENDATIONS = "recomendations"
    //TODO: Описать остальные экраны
}

enum class GreetingSections(
    val route: String
) {
    WELCOME("$GREETING/welcome"),
    ONBOARDING("$GREETING/onboarding"),
}

enum class InterestsSections(
    val route: String
) {
    MAIN("$INTEREST/main"),
}

enum class RecommendationsSections(
    val route: String
) {
    MAIN("$RECOMENDATIONS/main"),
}

enum class MainSections(
    val route: String
) {
    MAIN("$MAIN/main"),
    SUGGESTIONS("$MAIN/suggestions")
}