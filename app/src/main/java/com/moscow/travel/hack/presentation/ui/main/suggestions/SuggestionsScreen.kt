package com.moscow.travel.hack.presentation.ui.main.suggestions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.moscow.travel.hack.presentation.theme.TFBackground
import com.moscow.travel.hack.presentation.theme.Shapes
import com.moscow.travel.hack.presentation.theme.YellowPrimary
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
        SexyButton(modifier, "Поехали!") {
            onStartClick()
        }
        //CitySuggestions()
    }
}
