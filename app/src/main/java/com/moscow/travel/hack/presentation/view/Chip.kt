package com.moscow.travel.hack.presentation.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class InterestItem(
    val name: String,
    val isSelected: Boolean = false
)

@Composable
fun Chip(item: InterestItem, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .clickable { onClick() },
        elevation = 4.dp,
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colors.primary,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (item.isSelected) {
                Icon(
                    Icons.Default.Done,
                    null,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Text(
                item.name,
                modifier = Modifier.padding(8.dp),
                color = Color.White,
                style = MaterialTheme.typography.subtitle2
            )
        }
    }
}
