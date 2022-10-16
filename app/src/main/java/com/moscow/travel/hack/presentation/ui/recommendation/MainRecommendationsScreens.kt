package com.moscow.travel.hack.presentation.ui.recommendation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.moscow.travel.hack.presentation.theme.Background2
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
                modifier = Modifier.height(100.dp),
                title = {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 12.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth().height(49.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TopAppBarNavButton { handleBackPress() }
                            Spacer(modifier = Modifier.size(8.dp))
                            Title(stepNumber = currentStep.value)
                            Spacer(modifier = Modifier.weight(1f))
                            if (currentStep.value in 2..3) {
                                TextButton(
                                    onClick = {
                                        when (currentStep.value) {
                                            2 -> currentStep.value = 3
                                            3 -> currentStep.value = 0
                                        }
                                    },
                                    modifier = Modifier.height(44.dp)
                                ) {
                                    ButtonText(stepNumber = currentStep.value)
                                }
                            }
                        }
                        Divider(thickness = 2.5.dp, color = MaterialTheme.colors.Background2)
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            StepsProgressBar(
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .fillMaxWidth(0.5f),
                                numberOfSteps = 4,
                                currentStep = currentStep.value
                            )
                        }
                    }
                },
                backgroundColor = MaterialTheme.colors.background,
            )
        },

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
            0 -> "Выберите дату и город"
            1 -> "Выберите интересные места"
            2 -> "Выберите отель"
            3 -> "Ваша поездка"
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