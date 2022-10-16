package com.moscow.travel.hack.presentation.ui.greeting.interests

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import com.moscow.travel.hack.R
import com.moscow.travel.hack.presentation.view.Chip
import com.moscow.travel.hack.presentation.view.InterestItem
import com.moscow.travel.hack.presentation.view.SexyButton

@Composable
fun InterestsScreen(
    onSaveClick: () -> Unit,
) {
    val interestsList = remember {
        mutableStateListOf(
            InterestItem("Музей", R.drawable.ic_camera),
            InterestItem("Достопримечательность", R.drawable.ic_screenshot),
            InterestItem("Жанровая скульптура", R.drawable.ic_brush),
            InterestItem("Православный храм", R.drawable.ic_sun),
            InterestItem("Театр", R.drawable.ic_user),
            InterestItem("Парк культуры", R.drawable.ic_image),
            InterestItem("Астрономия", R.drawable.ic_astro),
            InterestItem("Шоппинг", R.drawable.ic_shop),
            InterestItem("Музыка", R.drawable.ic_music),
        )
    }
    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Text(
            "Выберите интересные вам темы",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.weight(1f))
        FlowRow {
            interestsList.mapIndexed { index, item ->
                Chip(item) {
                    interestsList[index] = item.copy(isSelected = !item.isSelected)
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            SexyButton(
                onClick = onSaveClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp),
                name = "Сохранить и продолжить"
            )
            TextButton(
                onClick = onSaveClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp),
            ) {
                Text("Пропустить")
            }
        }
    }
}
