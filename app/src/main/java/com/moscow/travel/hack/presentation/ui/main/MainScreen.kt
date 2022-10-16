package com.moscow.travel.hack.presentation.ui.main

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
import androidx.compose.foundation.shape.RoundedCornerShape
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
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.img_screenshot),
            contentDescription = ""
        )
        Column(
            Modifier
                .wrapContentWidth()
                .padding(start = 18.dp, top = 264.dp)
                .clip(Shapes.medium)
                .clickable { onSuggestionsClick() }
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xfff9edd5))
            ) {
                Image(
                    painter = painterResource(id = button.img),
                    modifier = Modifier
                        .size(49.dp)
                        .padding(8.dp),
                    contentDescription = button.name
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                button.name,
                textAlign = TextAlign.Center,
                color = Color(0xff8d8c87),
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(2.dp))
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