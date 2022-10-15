package com.moscow.travel.hack.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.moscow.travel.hack.presentation.theme.Shapes
import com.moscow.travel.hack.presentation.theme.TFBackground
import com.moscow.travel.hack.presentation.theme.YellowPrimary


@Composable
fun SexyTextField(
    modifier: Modifier = Modifier,
    placeholder: String = "",
    init: String = "",
    icon: Int? = null,
    onChange: (String) -> Unit = {},
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
        shape = Shapes.large,
        modifier = modifier
            .clip(Shapes.large)
            .background(MaterialTheme.colors.TFBackground)
    )
}

@Composable
fun SexyButton(
    modifier: Modifier = Modifier,
    name: String = "",
    icon: Int? = null,
    onClick: () -> Unit = {},
    content: @Composable (() -> Unit)? = null
) {
    Button(
        onClick = onClick,
        shape = Shapes.large,
        modifier = modifier
            .clip(Shapes.large),
        colors = ButtonDefaults.buttonColors(backgroundColor = YellowPrimary)
        //.background(Color.Yellow)
    ) {
        if (content != null) {
            content()
        } else {
            Row {
                if (icon != null) {
                    Icon(
                        painterResource(id = icon),
                        "icon",
                        modifier = Modifier.size(56.dp)
                    )
                }
                Text(name, color = MaterialTheme.colors.onPrimary)
            }
        }
    }
}
