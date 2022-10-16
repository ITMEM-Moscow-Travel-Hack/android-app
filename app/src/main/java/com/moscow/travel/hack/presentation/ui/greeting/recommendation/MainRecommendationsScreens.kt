package com.moscow.travel.hack.presentation.ui.greeting.recommendation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.moscow.travel.hack.presentation.view.StepsProgressBar

@Composable
fun MainRecommendationsScreen() {
    val currentStep = remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxSize()) {
        StepsProgressBar(
            modifier = Modifier.fillMaxWidth(),
            numberOfSteps = 4,
            currentStep = currentStep.value
        )
        CurrentStepScreen(stepNumber = currentStep.value) { currentStep.value = it }
    }
}

@Composable
fun CurrentStepScreen(
    stepNumber: Int,
    onChangeStep: (Int) -> Unit,
) {
    when (stepNumber) {
        0 -> StartSearchScreen(onNext = {
            onChangeStep(1)
        })
        1 -> TinderScreen(onNextStepClick = {
            onChangeStep(2)
        })
        2 -> HotelsScreen(onNextStepClick = {
            onChangeStep(3)
        })
        3 -> SummaryScreen()
    }
}