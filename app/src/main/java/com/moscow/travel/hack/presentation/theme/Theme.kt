package com.moscow.travel.hack.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/*
YellowPrimary
TFBackground
TFPlaceholder
TFPrimary
Background1
Background2
*/

private val DarkColorPalette = darkColors(
    primary = YellowPrimary,
    primaryVariant = YellowPrimaryVariant,
    secondary = Secondary,
    background = Dark.Background1,
    surface = Dark.TFBackground,
    onBackground = Dark.TFPrimary,
    onPrimary = Light.TFPrimary
)

private val LightColorPalette = lightColors(
    primary = YellowPrimary,
    primaryVariant = YellowPrimaryVariant,
    secondary = Secondary,
    background = Light.Background1,
    surface = Light.TFBackground,
    onBackground = Light.TFPrimary,
    onPrimary = Light.TFPrimary
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun MoscowTravelHackAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}