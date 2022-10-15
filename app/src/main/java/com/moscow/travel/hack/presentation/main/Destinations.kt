package com.moscow.travel.hack.presentation.main

import com.moscow.travel.hack.presentation.main.MainDestinations.GREETING
import com.moscow.travel.hack.presentation.main.MainDestinations.MAP

object MainDestinations {
    const val GREETING = "greeting"
    const val MAP = "map"
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