package com.moscow.travel.hack.presentation.ui.greeting.recomendation

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moscow.travel.hack.presentation.view.SearchField
import com.moscow.travel.hack.presentation.view.SexyButton
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StartSearchScreen(
    onTinderClick: () -> Unit,
) {
    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val scope = rememberCoroutineScope()

    var text by remember { mutableStateOf("") }

    ModalBottomSheetLayout(
        sheetContent = {
            BottomSheetSearch {
                scope.launch {
                    sheetState.hide()
                }
            }
        },
        sheetState = sheetState,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            SexyButton(
                onClick = onTinderClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp),
                name = "Рекомендации"
            )
            SearchField(modifier = Modifier.fillMaxWidth(), text = text, onFilterClick = {
                scope.launch {
                    sheetState.show()
                }
            }, onType = { text = it })
        }
    }
}

@Composable
fun BottomSheetSearch(
    onApplyClick: () -> Unit,
) {
    SexyButton(
        onClick = onApplyClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .padding(vertical = 20.dp)
            .height(48.dp),
        name = "Применить"
    )
}