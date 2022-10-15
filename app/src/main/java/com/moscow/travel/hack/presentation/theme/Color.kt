package com.moscow.travel.hack.presentation.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

val YellowPrimary = Color(0xffffc809)
val YellowPrimaryVariant = Color(0xfff2cc07)
val Secondary = Color(0xffffc809)

object Dark {
    val TFBackground = Color(0xFF444444)
    val TFPlaceholder = Color(0xFF979797)
    val TFPrimary = Color(0xFFf8f8f8)
    val Background1 = Color(0xFF191919)
    val Background2 = Color(0xFF2f2f2f)
}

object Light {
    val TFBackground = Color(0xFFFFFFFF)
    val TFPlaceholder = Color(0xFFb4b4b4)
    val TFPrimary = Color(0xFF171717)
    val Background1 = Color(0xFFfffbf2)
    val Background2 = Color(0xFFfaefdb)
}

val Colors.TFBackground: Color
    get() = if (isLight) Light.TFBackground else Dark.TFBackground

val Colors.Background2: Color
    get() = if (isLight) Light.Background2 else Dark.Background2
