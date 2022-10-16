package com.moscow.travel.hack.presentation.ui.main.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
//    val buttons = remember {
//        listOf(
//            MainScreenButton(
//                name = "Собрать поездку",
//                img = R.drawable.ic_constructor,
//                onClick = onSuggestionsClick
//            ),
//            MainScreenButton(
//                "Отели",
//                img = R.drawable.ic_bed,
//            ),
//            MainScreenButton(
//                "Музеи",
//                img = R.drawable.ic_ticket,
//            ),
//            MainScreenButton(
//                "Экскурсии",
//                img = R.drawable.ic_step,
//            ),
//            MainScreenButton(
//                "Авиа билеты",
//                img = R.drawable.ic_plane,
//            ),
//            MainScreenButton(
//                "Ж/Д билеты",
//                img = R.drawable.ic_train,
//            ),
//            MainScreenButton(
//                "Направления",
//                img = R.drawable.ic_mountain,
//            ),
//        )
//    }
    val button = MainScreenButton(
        name = "Конструктор",
        img = R.drawable.ic_constructor,
        onClick = onSuggestionsClick
    )
    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
//        LazyRow {
//            items(buttons) {
        Image(modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop, painter = painterResource(id = R.drawable.img_screenshot), contentDescription = "")
        Column(
            Modifier
                .wrapContentWidth()
                .padding(start = 14.dp, end = 8.dp, top = 312.dp)
                .clip(Shapes.medium)
                .clickable { onSuggestionsClick() },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                Modifier
                    .clip(MaterialTheme.shapes.large).background(MaterialTheme.colors.Background2)
            ) {
                Image(
                    painter = painterResource(id = button.img),
                    modifier = Modifier.size(64.dp).padding(8.dp),
                    contentDescription = button.name
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Text(button.name, textAlign = TextAlign.Center, color = Color(0xff8d8c87), fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
        }
//            }
//        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen { }
}