package com.moscow.travel.hack.presentation.ui.main.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moscow.travel.hack.R
import com.moscow.travel.hack.presentation.theme.Background2
import com.moscow.travel.hack.presentation.theme.Shapes

data class MainScreenButton(
    val name: String,
    val img: Int = R.drawable.ic_placeholder,
    val onClick: () -> Unit = {}
)

@Composable
fun MainScreen(onSuggestionsClick: () -> Unit) {
    val buttons = remember {
        listOf(
            MainScreenButton(
                name = "Собрать поездку",
                img = R.drawable.ic_constructor,
                onClick = onSuggestionsClick
            ),
            MainScreenButton(
                "Отели",
                img = R.drawable.ic_bed,
            ),
            MainScreenButton(
                "Музеи",
                img = R.drawable.ic_ticket,
            ),
            MainScreenButton(
                "Экскурсии",
                img = R.drawable.ic_step,
            ),
            MainScreenButton(
                "Авиа билеты",
                img = R.drawable.ic_plane,
            ),
            MainScreenButton(
                "Ж/Д билеты",
                img = R.drawable.ic_train,
            ),
            MainScreenButton(
                "Направления",
                img = R.drawable.ic_mountain,
            ),
        )
    }
    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        LazyRow {
            items(buttons) {
                Column(
                    Modifier
                        .wrapContentWidth()
                        .padding(6.dp)
                        .clip(Shapes.medium)
                        .clickable { onSuggestionsClick() }
                        .padding(horizontal = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        Modifier
                            .background(MaterialTheme.colors.Background2)
                    ) {
                        Image(
                            painter = painterResource(id = it.img),
                            modifier = Modifier.size(60.dp),
                            contentDescription = it.name
                        )
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