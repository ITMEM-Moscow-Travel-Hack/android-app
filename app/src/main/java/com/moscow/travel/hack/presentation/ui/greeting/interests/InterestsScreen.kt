package com.moscow.travel.hack.presentation.ui.greeting.interests

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.moscow.travel.hack.R
import com.moscow.travel.hack.presentation.view.Chip
import com.moscow.travel.hack.presentation.view.InterestItem

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
        LazyRow(
            modifier = Modifier,
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            itemsIndexed(interestsList) { index, item ->
                Chip(item) {
                    interestsList[index] = item.copy(isSelected = !item.isSelected)
                }
            }
        }
        Button(
            onClick = { onSaveClick() },
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp),
        ) {
            Text(
                stringResource(R.string.save_and_continue),
                modifier = Modifier,
            )
        }
    }
}
