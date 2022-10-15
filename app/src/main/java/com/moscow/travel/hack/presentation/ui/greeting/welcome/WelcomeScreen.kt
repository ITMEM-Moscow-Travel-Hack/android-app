
package com.moscow.travel.hack.presentation.ui.greeting.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.moscow.travel.hack.R

@Composable
fun WelcomeScreen(
    onContinueClick: () -> Unit
) {
    Box(Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 48.dp)
        ) {
            Text(
//                    stringResource(R.string.hello_label),
                "Привет! Я помогу с организацией твоего путешествия",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Center
            )
            Image(
                painterResource(R.drawable.ic_welcome),
                contentDescription = null,
                Modifier.padding(top = 100.dp)
            )
        }
        Column(
            Modifier.align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    onContinueClick()
                },
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .padding(bottom = 8.dp)
                    .height(48.dp)
            ) {
                Text(
//                        stringResource(R.string.continue_label)
                    "Поехали!"
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}