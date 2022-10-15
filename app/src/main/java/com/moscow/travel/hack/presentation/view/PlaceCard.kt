package com.moscow.travel.hack.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.moscow.travel.hack.domain.entity.Place
import com.moscow.travel.hack.presentation.theme.Background2

@Composable
fun PlaceCard(
    modifier: Modifier,
    place: Place,
    onClick: ((placeId: Int) -> Unit)? = null,
) {
    Card(
        modifier
            .clip(MaterialTheme.shapes.large)
            .border(2.dp, MaterialTheme.colors.Background2, MaterialTheme.shapes.large)
            .background(MaterialTheme.colors.background)
            .clickable(enabled = onClick != null) {
                onClick?.invoke(place.id)
            }) {
        Column(modifier = Modifier.background(MaterialTheme.colors.primary)) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(place.photoUri)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.ic_placeholder),
                error = painterResource(R.drawable.ic_placeholder),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .fillMaxHeight(0.8f)
            )
            Text(
                text = "${place.name}, ${place.price.toInt()} руб.",
                color = MaterialTheme.colors.onPrimary,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}
