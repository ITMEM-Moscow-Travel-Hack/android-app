package com.moscow.travel.hack.presentation.ui.greeting.recomendation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moscow.travel.hack.domain.entity.hotels
import com.moscow.travel.hack.presentation.view.HotelCard

@Composable
fun HotelsScreen() {
    LazyColumn {
        items(hotels) {
            HotelCard(hotel = it, onHotelClick = {})
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}