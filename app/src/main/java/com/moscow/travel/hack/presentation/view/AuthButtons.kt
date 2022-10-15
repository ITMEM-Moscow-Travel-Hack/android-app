package com.moscow.travel.hack.presentation.view

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun AuthButtons(
    onMainClick: () -> Unit,
    onSubtitleClick: () -> Unit,
    @StringRes mainActionText: Int,
    @StringRes subtitleText: Int,
    @StringRes subtitleActionText: Int,
    modifier: Modifier = Modifier,
    buttonModifier: Modifier = Modifier,
    enabledMainButton: Boolean = true,
    subtitleColor: Color = MaterialTheme.colors.primary,
    onlyMainButton: Boolean = false,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { onMainClick() },
            buttonModifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp),
            enabled = enabledMainButton
        ) {
            Text(
                stringResource(mainActionText),
                modifier = Modifier,
            )
        }
        Spacer(Modifier.height(16.dp))
        if (!onlyMainButton) {
            TextButton(
                onClick = { onSubtitleClick() },
                modifier = Modifier
            ) {
                Text("${stringResource(subtitleText)} ", color = Color.Black)
                Text(stringResource(subtitleActionText), color = subtitleColor)
            }
        }
    }
}