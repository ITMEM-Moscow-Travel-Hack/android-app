package com.moscow.travel.hack.presentation.main

import com.moscow.travel.hack.presentation.main.MainDestinations.GREETING
import com.moscow.travel.hack.presentation.main.MainDestinations.INTEREST
import com.moscow.travel.hack.presentation.main.MainDestinations.MAP
import com.moscow.travel.hack.presentation.main.MainDestinations.RECOMENDATIONS

object MainDestinations {
    const val GREETING = "greeting"
    const val MAP = "map"
    const val INTEREST = "interest"
    const val RECOMENDATIONS = "recomendations"
    //TODO: Описать остальные экраны
}

enum class GreetingSections(
    val route: String
) {
    WELCOME("$GREETING/welcome"),
    ONBOARDING("$GREETING/onboarding"),
}

enum class MapSections(
    val route: String
) {
    MAIN("$MAP/main"),
}

enum class InterestsSections(
    val route: String
) {
    MAIN("$INTEREST/main"),
}

enum class RecomendationsSections(
    val route: String
) {
    START_SEARCH("$RECOMENDATIONS/start_search"),
    TINDER("$RECOMENDATIONS/main"),
}