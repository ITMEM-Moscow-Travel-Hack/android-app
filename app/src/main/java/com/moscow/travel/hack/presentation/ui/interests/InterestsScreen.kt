package com.moscow.travel.hack.presentation.ui.interests

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow
import com.moscow.travel.hack.presentation.view.Chip
import com.moscow.travel.hack.presentation.view.SexyButton

@Composable
fun InterestsScreen(
    onSaveClick: () -> Unit,
) {
    val viewModel = hiltViewModel<InterestsViewModel>()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            "Выберите интересные вам темы",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.weight(1f))
        FlowRow {
            viewModel.categories.mapIndexed { index, item ->
                Chip(item) {
                    viewModel.categories[index] = item.copy(isSelected = !item.isSelected)
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SexyButton(
                onClick = {
                    viewModel.sendCategories()
                    onSaveClick()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp),
                enabled = viewModel.isButtonEnabled,
                name = "Сохранить и продолжить",
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
