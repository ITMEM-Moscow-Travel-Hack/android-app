package com.moscow.travel.hack.presentation.ui.main.suggestions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moscow.travel.hack.presentation.view.SexyButton
import com.moscow.travel.hack.presentation.view.SexyTextField

@Composable
fun SuggestionsScreen(
    onBackPressed: () -> Unit,
    onStartClick: () -> Unit,
) {
    val modifier = Modifier
        .fillMaxWidth(0.8f)
        .height(52.dp)
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
//        SexyTextField(
//            "Укажите даты поездки",
//            icon = R.drawable.ic_launcher_foreground,
//            modifier = modifier
//        )
        SexyTextField(modifier, "Введите желаемый город")
        SexyButton(modifier, "Поехали!", onClick = onStartClick)
        //CitySuggestions()
    }
}
