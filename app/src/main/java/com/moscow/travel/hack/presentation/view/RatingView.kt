package com.moscow.travel.hack.presentation.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material.icons.outlined.Grade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RatingView(
    rating: Float,
    modifier: Modifier = Modifier,
    distanceBetweenStars: Dp = 8.dp,
    starsSize: Dp = 24.dp,
    clickable: Boolean = false,
    onClickStar: (star: Int) -> Unit = {}
) {
    var rating by rememberSaveable { mutableStateOf(rating) }

    Row(horizontalArrangement = Arrangement.spacedBy(distanceBetweenStars), modifier = modifier) {
        repeat(5) {
            if (rating > it && rating < it + 1) {
                if (rating % 1 >= 0.5) {
                    Icon(
                        Icons.Default.StarHalf,
                        null,
                        tint = MaterialTheme.colors.primary,
                        modifier =
                        if (clickable)
                            Modifier
                                .size(starsSize)
                                .clickable {
                                    if (clickable) rating = it + 1f
                                    onClickStar(rating.toInt())
                                }
                        else
                            Modifier.size(starsSize)
                    )
                } else {
                    Icon(
                        Icons.Outlined.Grade,
                        null,
                        tint = MaterialTheme.colors.primary,
                        modifier =
                        if (clickable)
                            Modifier
                                .size(starsSize)
                                .clickable {
                                    if (clickable) rating = it + 1f
                                    onClickStar(rating.toInt())
                                }
                        else
                            Modifier.size(starsSize)
                    )
                }
            } else if (rating > it) {
                Icon(
                    Icons.Default.Star,
                    null,
                    tint = MaterialTheme.colors.primary,
                    modifier =
                    if (clickable)
                        Modifier
                            .size(starsSize)
                            .clickable {
                                if (clickable) rating = it + 1f
                                onClickStar(rating.toInt())
                            }
                    else
                        Modifier.size(starsSize)
                )
            } else {
                Icon(
                    Icons.Outlined.Grade,
                    null,
                    tint = MaterialTheme.colors.primary,
                    modifier =
                    if (clickable)
                        Modifier
                            .size(starsSize)
                            .clickable {
                                if (clickable) rating = it + 1f
                                onClickStar(rating.toInt())
                            }
                    else
                        Modifier.size(starsSize)
                )
            }
        }
    }
}