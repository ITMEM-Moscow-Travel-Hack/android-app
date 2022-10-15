package com.moscow.travel.hack.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
    onSkip: () -> Unit,
    onFav: () -> Unit
) {
    Card(
        modifier
            .clip(MaterialTheme.shapes.large)
            .border(2.dp, MaterialTheme.colors.Background2, MaterialTheme.shapes.large)
            .background(MaterialTheme.colors.background)
            .clickable(enabled = onClick != null) {
                onClick?.invoke(place.id)
            }) {
        Column(Modifier.background(MaterialTheme.colors.background)) {
            Box {
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
                        .fillMaxHeight(0.85f)
                        .drawWithContent {
                            val colors = listOf(Color.Black, Color.Transparent)
                            drawContent()
                            drawRect(
                                brush = Brush.verticalGradient(colors),
                                blendMode = BlendMode.DstIn
                            )
                        }
                )
                Text(
                    text = place.name,
                    color = Color.White,
                    fontSize = 38.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.BottomStart)
                        .fillMaxWidth(0.68f)
                )
                Text(
                    text = "от ${place.price.toInt()}р",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Right,
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.BottomEnd)
                        .fillMaxWidth(0.35f)
                )
            }
            Divider(color = MaterialTheme.colors.Background2, thickness = 2.dp)
            Row(
                Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                val btnModifier = Modifier.size(56.dp)
                SexyButton(
                    btnModifier,
                    onClick = onSkip,
                    icon = Icons.Rounded.Close
                )
                SexyButton(
                    btnModifier,
                    onClick = onFav,
                    icon = Icons.Rounded.Favorite
                )
            }
        }
    }
}
