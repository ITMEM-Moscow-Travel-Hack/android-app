package com.moscow.travel.hack.presentation.ui.recommendation

import android.app.DatePickerDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.moscow.travel.hack.domain.entity.cities
import com.moscow.travel.hack.presentation.view.CityCard
import com.moscow.travel.hack.presentation.view.SexyButton
import com.moscow.travel.hack.presentation.view.SexyTextField
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date
import java.util.Locale

@Composable
fun StartSearchScreen(
    viewModel: RecommendationsViewModel,
    onNext: () -> Unit,
) {
    var text by remember { mutableStateOf("") }
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SexyButton(
                    Modifier.width(160.dp),
                    onClick = {
                        val date = LocalDate.now()
                        val dialog = DatePickerDialog(
                            context, { _, year: Int, month: Int, day: Int ->
                                viewModel.startDate = Date(year, month, day)
                            }, date.year, date.month.value, date.dayOfMonth
                        )
                        dialog.show()
                    },
                    name = if (viewModel.startDate == null) "Дата начала" else SimpleDateFormat(
                        "dd MMMM",
                        Locale.getDefault()
                    ).format(viewModel.startDate!!)
                )
                SexyButton(
                    Modifier.width(160.dp), onClick = {
                        val date = LocalDate.now()
                        val dialog = DatePickerDialog(
                            context, { _, year: Int, month: Int, day: Int ->
                                viewModel.endDate = Date(year, month, day)
                            }, date.year, date.month.value, date.dayOfMonth
                        )
                        dialog.show()
                    }, name = if (viewModel.endDate == null) "Дата окончания" else SimpleDateFormat(
                        "dd MMMM",
                        Locale.getDefault()
                    ).format(viewModel.endDate!!)
                )
            }
            SexyTextField(
                modifier = Modifier.fillMaxWidth(),
                placeholder = "Поиск направления",
                icon = Icons.Rounded.Search,
                onChange = { text = it })
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(cities) {
                    CityCard(city = it, onCityClick = { _ ->
                        viewModel.selectedCity = it
                        onNext()
                    })
                }
            }
        }
    }
}