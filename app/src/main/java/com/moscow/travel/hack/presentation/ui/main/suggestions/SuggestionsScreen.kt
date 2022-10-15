package com.moscow.travel.hack.presentation.ui.main.suggestions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

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
        SexyTextField("Введите желаемый город", modifier = modifier)
        SexyButton(modifier = modifier, "Поехали!") {
            onStartClick()
        }
        //CitySuggestions()
    }
}

@Composable
fun SexyTextField(
    placeholder: String = "",
    init: String = "",
    icon: Int? = null,
    onChange: (String) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    val value = remember {
        mutableStateOf(init)
    }
    TextField(
        value = value.value,
        onValueChange = {
            value.value = it
            onChange(it)
        },
        leadingIcon = {
            if (icon != null) Icon(
                painterResource(id = icon),
                "icon",
                modifier = Modifier.size(52.dp)
            )
        },
        placeholder = { Text(placeholder) },
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color.LightGray)
    )
}

@Composable
fun SexyButton(
    modifier: Modifier = Modifier,
    name: String = "",
    icon: Int? = null,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .clip(RoundedCornerShape(16.dp)),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
        //.background(Color.Yellow)
    ) {
        Row {
            if (icon != null) {
                Icon(
                    painterResource(id = icon),
                    "icon",
                    modifier = Modifier.size(56.dp)
                )
            }
            Text(name)
        }
    }
}