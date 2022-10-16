package com.moscow.travel.hack.presentation.ui.greeting.recomendation

import android.app.DatePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.moscow.travel.hack.domain.entity.cities
import com.moscow.travel.hack.presentation.view.CityCard
import com.moscow.travel.hack.presentation.view.SexyButton
import com.moscow.travel.hack.presentation.view.SexyTextField
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

@Composable
fun StartSearchScreen(
    onTinderClick: (Int) -> Unit,
) {
    var text by remember { mutableStateOf("") }
    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("") }
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
                SexyButton(Modifier.width(160.dp), onClick = {
                    val date = LocalDate.now()
                    val dialog = DatePickerDialog(
                        context, { _, year: Int, month: Int, day: Int ->
                            val date = Date(year, month, day)
                            val formatter = SimpleDateFormat("dd MMMM", Locale.getDefault())
                            startDate = formatter.format(date)
                        }, date.year, date.month.value, date.dayOfMonth
                    )
                    dialog.show()
                }, name = if (startDate == "") "Дата начала" else startDate)
                SexyButton(Modifier.width(160.dp), onClick = {
                    val date = LocalDate.now()
                    val dialog = DatePickerDialog(
                        context, { _, year: Int, month: Int, day: Int ->
                            val date = Date(year, month, day)
                            val formatter = SimpleDateFormat("dd MMMM", Locale.getDefault())
                            endDate = formatter.format(date)
                        }, date.year, date.month.value, date.dayOfMonth
                    )
                    dialog.show()
                }, name = if (endDate == "") "Дата окончания" else endDate)
            }
            SexyTextField(modifier = Modifier.fillMaxWidth(), icon = Icons.Rounded.Search)
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(cities) {
                    CityCard(city = it, onCityClick = onTinderClick)
                }
            }
        }
    }
}