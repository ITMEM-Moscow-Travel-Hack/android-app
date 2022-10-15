package com.moscow.travel.hack.presentation.ui.main.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moscow.travel.hack.R
import com.moscow.travel.hack.presentation.theme.Background2
import com.moscow.travel.hack.presentation.theme.Shapes
import com.moscow.travel.hack.presentation.theme.TFBackground

data class MainScreenButton(
    val name: String,
    val img: Int = R.drawable.ic_launcher_background,
    val onClick: () -> Unit = {}
)

@Composable
fun MainScreen(onSuggestionsClick: () -> Unit) {
    val buttons = remember {
        listOf(
            MainScreenButton(
                name = "Собрать поездку",
                img = R.drawable.ic_launcher_foreground,
                onClick = onSuggestionsClick
            ),
            MainScreenButton("Отели"),
            MainScreenButton("Отели"),
            MainScreenButton("Отели"),
            MainScreenButton("Отели"),
            MainScreenButton("Отели"),
            MainScreenButton("Отели"),
        )
    }
    Box(Modifier.fillMaxSize().background(MaterialTheme.colors.background)) {
        LazyRow {
            items(buttons) {
                Column(Modifier.width(72.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        Modifier
                            .size(64.dp)
                            .clip(Shapes.medium)
                            .clickable { onSuggestionsClick() }
                            .background(MaterialTheme.colors.Background2)
                    ) {
                        Image(painter = painterResource(id = it.img), contentDescription = it.name)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(it.name, textAlign = TextAlign.Center)
                }
            }
        }
    }
}


@Preview
@Composable
fun MainScreenPreview() {
    MainScreen { }
}