package com.moscow.travel.hack.presentation.view

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.moscow.travel.hack.presentation.theme.Background2

@Composable
fun CityCard(
    city: City,
    modifier: Modifier = Modifier,
    onCityClick: (String) -> Unit,
) {
    Card(
        modifier = Modifier
            .clip(MaterialTheme.shapes.large)
            .border(
                2.dp,
                color = MaterialTheme.colors.Background2,
                shape = MaterialTheme.shapes.large
            )
            .clickable { onCityClick(city.id) }) {
        Row(
            modifier
                .fillMaxWidth()
                .padding(8.dp), verticalAlignment = Alignment.CenterVertically
        ) {
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
                    .size(90.dp)
                    .clip(MaterialTheme.shapes.large)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = city.name,
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = city.description,
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 16.sp,
                    maxLines = 3,
                )
            }
        }
    }
}