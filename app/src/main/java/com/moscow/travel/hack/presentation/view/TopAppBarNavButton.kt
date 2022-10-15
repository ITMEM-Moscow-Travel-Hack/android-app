package com.moscow.travel.hack.presentation.view

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun TopAppBarNavButton(onNavClick: () -> Unit) {
    IconButton(onClick = { onNavClick() }) {
        Icon(
            Icons.Default.ArrowBack,
            contentDescription = null,
            tint = MaterialTheme.colors.primary
        )
    }
}