package com.moscow.travel.hack.presentation.ui.recommendation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.moscow.travel.hack.presentation.view.StepsProgressBar
import com.moscow.travel.hack.presentation.view.TopAppBarNavButton

@Composable
fun MainRecommendationsScreen(
    onBackPressed: () -> Unit
) {
    val currentStep = remember { mutableStateOf(0) }
    val scaffoldState = rememberScaffoldState()

    val handleBackPress = {
        if (currentStep.value == 0) onBackPressed()
        else currentStep.value--
    }
    BackHandler {
        handleBackPress()
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TopAppBarNavButton { handleBackPress() }
                            Title(stepNumber = currentStep.value)
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            StepsProgressBar(
                                modifier = Modifier.weight(1f),
                                numberOfSteps = 4,
                                currentStep = currentStep.value
                            )
                            if (currentStep.value in listOf(2, 3)) {
                                TextButton(
                                    onClick = {
                                        when (currentStep.value) {
                                            2 -> currentStep.value = 3
                                            3 -> currentStep.value = 0
                                        }
                                    },
                                    modifier = Modifier
                                ) {
                                    ButtonText(stepNumber = currentStep.value)
                                }
                            }
                        }
                    }
                },
                backgroundColor = MaterialTheme.colors.background,
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            CurrentStepScreen(stepNumber = currentStep.value) { currentStep.value = it }
        }
    }
}

@Composable
fun Title(stepNumber: Int) {
    Text(
        when (stepNumber) {
            0 -> "Выберите даты и город поездки"
            1 -> "Выберите интересные места"
            2 -> "Выберите отель"
            3 -> "Проверьте заказ и произведите оплату"
            else -> ""
        }, color = Color.Black
    )
}

@Composable
fun ButtonText(stepNumber: Int) {
    Text(
        when (stepNumber) {
            2 -> "Пропустить"
            3 -> "Сбросить"
            else -> ""
        }, color = Color.Black
    )
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