package com.moscow.travel.hack.presentation.ui.greeting.recomendation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexstyl.swipeablecard.Direction
import com.alexstyl.swipeablecard.ExperimentalSwipeableCardApi
import com.alexstyl.swipeablecard.rememberSwipeableCardState
import com.alexstyl.swipeablecard.swipableCard
import com.moscow.travel.hack.domain.entity.places
import com.moscow.travel.hack.presentation.view.PlaceCard
import com.moscow.travel.hack.presentation.view.SexyButton
import com.moscow.travel.hack.presentation.view.SexyTextField
import kotlinx.coroutines.launch
import timber.log.Timber

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalSwipeableCardApi::class)
@Composable
fun TinderScreen(
    onBackPressed: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val states = places.reversed().map { it to rememberSwipeableCardState() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SexyTextField(
            placeholder = "Поиск места",
            modifier = Modifier.fillMaxWidth(),
            icon = Icons.Rounded.Search
        )
        Box(
            Modifier.fillMaxHeight(0.8f)
        ) {
            states.forEach { (place, state) ->
                if (state.swipedDirection == null) {
                    PlaceCard(
                        modifier = Modifier
                            .fillMaxSize()
                            .swipableCard(
                                state = state,
                                blockedDirections = listOf(Direction.Down, Direction.Up),
                                onSwiped = {
                                },
                                onSwipeCancel = {
                                }
                            ),
                        place = place,
                        onClick = {
                            Timber.tag("open place").e(it.toString())
                        },
                        onSkip = {
                            scope.launch {
                                val last = states.reversed()
                                    .firstOrNull {
                                        it.second.offset.value == Offset(0f, 0f)
                                    }?.second
                                last?.swipe(Direction.Left)
                            }
                        },
                        onFav = {
                            scope.launch {
                                val last = states.reversed()
                                    .firstOrNull {
                                        it.second.offset.value == Offset(0f, 0f)
                                    }?.second

                                last?.swipe(Direction.Right)
                            }
                        }
                    )
                }
                LaunchedEffect(place, state.swipedDirection) {
                    if (state.swipedDirection != null) {
//                        hint = "You swiped ${stringFrom(state.swipedDirection!!)}"
                    }
                }
            }
        }
//        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Понравилось: X",
            color = MaterialTheme.colors.onBackground,
            fontSize = 32.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
//        Spacer(modifier = Modifier.height(16.dp))
        SexyButton(name = "Следующий шаг", modifier = Modifier.fillMaxWidth())
//        Spacer(modifier = Modifier.height(16.dp))
    }
}
