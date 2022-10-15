package com.moscow.travel.hack.presentation.ui.greeting.recomendation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import com.alexstyl.swipeablecard.Direction
import com.alexstyl.swipeablecard.ExperimentalSwipeableCardApi
import com.alexstyl.swipeablecard.rememberSwipeableCardState
import com.alexstyl.swipeablecard.swipableCard
import com.moscow.travel.hack.domain.entity.places
import com.moscow.travel.hack.presentation.view.CircleButton
import com.moscow.travel.hack.presentation.view.PlaceCard
import com.moscow.travel.hack.presentation.view.TopAppBarNavButton
import kotlinx.coroutines.launch
import timber.log.Timber

@OptIn(ExperimentalSwipeableCardApi::class)
@Composable
fun TinderScreen(
    onBackPressed: () -> Unit,
) {
    val scope = rememberCoroutineScope()
    val states = places.reversed().map { it to rememberSwipeableCardState() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Назад")
                },
                backgroundColor = MaterialTheme.colors.background,
                navigationIcon = { TopAppBarNavButton(onBackPressed) },
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Box(
                Modifier
                    .padding(24.dp)
                    .weight(1f)
                    .fillMaxHeight(0.8f)
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
            Row(
                Modifier
                    .padding(horizontal = 24.dp, vertical = 32.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom
            ) {
                CircleButton(
                    onClick = {
                        scope.launch {
                            val last = states.reversed()
                                .firstOrNull {
                                    it.second.offset.value == Offset(0f, 0f)
                                }?.second
                            last?.swipe(Direction.Left)
                        }
                    },
                    icon = Icons.Rounded.Close
                )
                CircleButton(
                    onClick = {
                        scope.launch {
                            val last = states.reversed()
                                .firstOrNull {
                                    it.second.offset.value == Offset(0f, 0f)
                                }?.second

                            last?.swipe(Direction.Right)
                        }
                    },
                    icon = Icons.Rounded.Favorite
                )
            }
        }
    }
}
