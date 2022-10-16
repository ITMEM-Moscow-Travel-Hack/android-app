package com.moscow.travel.hack.presentation.ui.greeting.interests

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.moscow.travel.hack.presentation.view.Chip
import com.moscow.travel.hack.presentation.view.InterestItem
import com.moscow.travel.hack.presentation.view.SexyButton

@Composable
fun InterestsScreen(
    onSaveClick: () -> Unit,
) {
    val interestsList = remember {
        mutableStateListOf(
            InterestItem("Спорт"),
            InterestItem("Наука"),
            InterestItem("Искусство"),
            InterestItem("Еда"),
            InterestItem("Кино"),
            InterestItem("Эротика")
        )
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            "Выберите интересные вам темы",
            modifier = Modifier.padding(8.dp),
            style = MaterialTheme.typography.subtitle2
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
        Column(modifier = Modifier.fillMaxWidth()) {
            SexyButton(
                onClick = onSaveClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp),
                name = "Пропустить"
            )
            SexyButton(
                onClick = onSaveClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp),
                name = "Сохранить и продолжить"
            )
        }
    }
}
