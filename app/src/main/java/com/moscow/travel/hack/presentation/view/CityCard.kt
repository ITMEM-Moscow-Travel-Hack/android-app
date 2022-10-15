package com.moscow.travel.hack.presentation.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.moscow.travel.hack.R
import com.moscow.travel.hack.domain.entity.City

@Composable
fun CityCard(
    city: City,
    modifier: Modifier = Modifier,
    onCityClick: (Int) -> Unit,
) {
    Card(modifier = Modifier.clickable { onCityClick(city.id) }) {
        Row(modifier.fillMaxWidth()) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(city.photoUri)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_placeholder),
                error = painterResource(R.drawable.ic_placeholder),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(85.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = city.name,
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                )
                Text(
                    text = city.places.joinToString(", "),
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}