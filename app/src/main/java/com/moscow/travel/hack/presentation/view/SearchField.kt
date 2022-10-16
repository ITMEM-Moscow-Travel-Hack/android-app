package com.moscow.travel.hack.presentation.view

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SearchField(
    modifier: Modifier,
    text: String,
    onSearchClick: () -> Unit,
    onType: (String) -> Unit,
) {
    val trailingIconView = @Composable {
        IconButton(
            onClick = onSearchClick,
        ) {
            Icon(
                Icons.Default.Search,
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