package com.moscow.travel.hack.presentation.view

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

data class InterestItem(
    val name: String,
    val img: Int,
    val isSelected: Boolean = false
)

@Composable
fun Chip(item: InterestItem, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Surface(
        modifier = modifier
            .padding(4.dp)
            .clip(MaterialTheme.shapes.medium)
            .clickable { onClick() },
        elevation = 4.dp,
        shape = MaterialTheme.shapes.medium,
        color = if (item.isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
    ) {
        val chipModifier =
            if (!item.isSelected) Modifier.border(
                1.dp,
                MaterialTheme.colors.onBackground,
                MaterialTheme.shapes.medium
            ) else Modifier
        Row(
            chipModifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painterResource(id = item.img),
                null,
                modifier = Modifier.padding(start = 8.dp)
            )
            Text(
                item.name,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.subtitle2
            )
        }
    }
}
