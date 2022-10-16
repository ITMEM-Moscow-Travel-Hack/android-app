package com.moscow.travel.hack.presentation.ui.greeting.recomendation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moscow.travel.hack.domain.entity.hotels
import com.moscow.travel.hack.presentation.view.HotelCard
import com.moscow.travel.hack.presentation.view.SexyTextField

@Composable
fun HotelsScreen() {
    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        SexyTextField(modifier = Modifier.fillMaxWidth(), icon = Icons.Rounded.Search)
        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(hotels) {
                HotelCard(hotel = it, onHotelClick = {})
            }
        }
    }
}