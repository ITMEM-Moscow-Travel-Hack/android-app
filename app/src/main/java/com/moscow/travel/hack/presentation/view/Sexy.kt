package com.moscow.travel.hack.presentation.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.moscow.travel.hack.presentation.theme.Background2
import com.moscow.travel.hack.presentation.theme.Shapes
import com.moscow.travel.hack.presentation.theme.TFBackground
import com.moscow.travel.hack.presentation.theme.YellowPrimary


@Composable
fun SexyTextField(
    modifier: Modifier = Modifier,
    placeholder: String = "",
    init: String = "",
    icon: ImageVector? = null,
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
        trailingIcon = {
            if (icon != null) Icon(
                icon,
                "icon",
                modifier = Modifier.size(48.dp)
            )
        },
        placeholder = { Text(placeholder) },
        shape = Shapes.large,
        modifier = modifier
            .clip(Shapes.large).border(2.5.dp, color = MaterialTheme.colors.Background2, MaterialTheme.shapes.large),
        colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.TFBackground)
    )
}

@Composable
fun SexyButton(
    modifier: Modifier = Modifier,
    name: String? = null,
    icon: ImageVector? = null,
    onClick: () -> Unit = {},
    content: @Composable (() -> Unit)? = null
) {
    Button(
        onClick = onClick,
        shape = Shapes.large,
        modifier = modifier
            .clip(Shapes.large)
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = YellowPrimary)
        //.background(Color.Yellow)
    ) {
        if (content != null) {
            content()
        } else {
            Row {
                if (icon != null) {
                    Icon(
                        icon,
                        "icon",
                        modifier = Modifier.size(56.dp)
                    )
                }
                if (name != null) {
                    Text(name, color = MaterialTheme.colors.onPrimary)
                }
            }
        }
    }
}
