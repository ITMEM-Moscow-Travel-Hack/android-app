package com.moscow.travel.hack.presentation.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.moscow.travel.hack.presentation.theme.Purple200
import com.moscow.travel.hack.presentation.theme.Teal200

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun PagerContent(
    pagerState: PagerState,
    content: List<PagerItem>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            count = content.size,
            state = pagerState,
        ) { page ->
            content[page].Draw(pagerScope = this, index = page)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun PagerIndicator(
    pagerState: PagerState,
    pageCount: Int,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(Modifier.weight(1f))
        for (i in 0..pageCount) {
            if (pagerState.currentPage == i) {
                Canvas(modifier = Modifier.size(12.dp)) {
                    drawCircle(
                        color = Purple200
                    )
                }
            } else {
                Canvas(modifier = Modifier.size(8.dp)) {
                    drawCircle(
                        color = Teal200
                    )
                }
            }
        }
        Spacer(Modifier.weight(1f))
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerView(
    pagerState: PagerState,
    data: List<PagerItem>,
    modifier: Modifier = Modifier,
) {
    ConstraintLayout(modifier = modifier) {
        val (content, indicators) = createRefs()

        PagerContent(
            pagerState,
            data,
            modifier = Modifier
                .constrainAs(content) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(indicators.top)
                })
        PagerIndicator(
            pagerState,
            data.size - 1,
            modifier = Modifier
                .constrainAs(indicators) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    height = Dimension.wrapContent
                    width = Dimension.matchParent
                })
    }
}