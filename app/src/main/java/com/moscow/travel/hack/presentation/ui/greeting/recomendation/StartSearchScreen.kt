package com.moscow.travel.hack.presentation.ui.greeting.recomendation

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moscow.travel.hack.domain.entity.cities
import com.moscow.travel.hack.presentation.view.CityCard
import com.moscow.travel.hack.presentation.view.SearchField
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.Date
import java.util.Locale

@Composable
fun StartSearchScreen(
    onTinderClick: () -> Unit,
) {
    var text by remember { mutableStateOf("") }
    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("") }
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Card(modifier = Modifier
                    .weight(1f)
                    .clickable {
                        val date = Date()
                        val dialog = DatePickerDialog(
                            context, { _, year: Int, month: Int, day: Int ->
                                val date = Date(year, month, day)
                                val formatter = SimpleDateFormat("dd MMMM", Locale.getDefault())
                                startDate = formatter.format(date)
                            }, date.year, date.month, date.day
                        )
                        dialog.show()
                    }) {
                    Text(
                        text = if (startDate == "") "Дата начала" else startDate,
                        color = MaterialTheme.colors.onPrimary,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Card(modifier = Modifier
                    .weight(1f)
                    .clickable {
                        val date = LocalDate.now()
                        val dialog = DatePickerDialog(
                            context, { _, year: Int, month: Int, day: Int ->
                                val date = Date(year, month, day)
                                val formatter = SimpleDateFormat("dd MMMM", Locale.getDefault())
                                endDate = formatter.format(date)
                            }, date.year, date.month.value, date.dayOfYear
                        )
                        dialog.show()
                    }) {
                    Text(
                        text = if (endDate == "") "Дата окончания" else endDate,
                        color = MaterialTheme.colors.onPrimary,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
            SearchField(modifier = Modifier.fillMaxWidth(),
                text = text,
                onSearchClick = {},
                onType = { text = it })
            LazyColumn {
                items(cities) {
                    CityCard(city = it, onCityClick = {})
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}