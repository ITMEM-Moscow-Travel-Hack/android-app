package com.moscow.travel.hack.presentation.ui.greeting.recomendation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.moscow.travel.hack.presentation.view.SearchField
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
        sheetState = sheetState
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = onTinderClick,
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp),
            ) {
                Text(
                    "Рекомендации",
                    modifier = Modifier,
                )
            }
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
    Button(
        onClick = onApplyClick,
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .padding(vertical = 20.dp)
            .height(48.dp)
    ) {
        Text(
            "Применить"
        )
    }
}