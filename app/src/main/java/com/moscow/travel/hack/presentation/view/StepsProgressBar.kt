package com.moscow.travel.hack.presentation.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StepsProgressBar(modifier: Modifier = Modifier, numberOfSteps: Int, currentStep: Int) {
    Box(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            val color = if (currentStep > 0) MaterialTheme.colors.primary else Color.LightGray
            Canvas(modifier = Modifier
                .size(15.dp)
                .border(
                    shape = CircleShape,
                    width = 2.dp,
                    color = MaterialTheme.colors.primary
                ),
                onDraw = {
                    drawCircle(color)
                }
            )
            for (step in 1 until numberOfSteps) {
                Step(
                    modifier = Modifier.weight(1F),
                    isCompete = step < currentStep,
                    isCurrent = step == currentStep,
                    step != 0
                )
            }
        }
    }
}

@Composable
fun Step(
    modifier: Modifier = Modifier,
    isCompete: Boolean,
    isCurrent: Boolean,
    showDivider: Boolean
) {
    val color = if (isCompete || isCurrent) MaterialTheme.colors.primary else Color.LightGray
    val innerCircleColor = if (isCompete) MaterialTheme.colors.primary else Color.LightGray

    Box(modifier = modifier) {
        if (showDivider) {
            Divider(
                modifier = Modifier.align(Alignment.CenterStart),
                color = color,
                thickness = 2.dp
            )
        }
        Canvas(modifier = Modifier
            .size(15.dp)
            .align(Alignment.CenterEnd)
            .border(
                shape = CircleShape,
                width = 2.dp,
                color = color
            ),
            onDraw = {
                drawCircle(color = innerCircleColor)
            }
        )
    }
}