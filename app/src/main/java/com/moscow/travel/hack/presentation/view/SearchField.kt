package com.moscow.travel.hack.presentation.view

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Filter
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SearchField(
    modifier: Modifier,
    text: String,
    onFilterClick: () -> Unit,
    onType: (String) -> Unit,
) {
    val trailingIconView = @Composable {
        IconButton(
            onClick = onFilterClick,
        ) {
            Icon(
                Icons.Default.Filter,
                contentDescription = "",
                tint = Color.Black
            )
        }
    }
    TextField(
        modifier = modifier,
        value = text,
        onValueChange = { onType(it) },
        trailingIcon = trailingIconView,
    )
}