package com.moscow.travel.hack.presentation.ui.greeting.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.google.accompanist.pager.*
import com.moscow.travel.hack.R
import com.moscow.travel.hack.presentation.view.AuthButtons
import com.moscow.travel.hack.presentation.view.PagerItem
import com.moscow.travel.hack.presentation.view.PagerView
import kotlin.math.absoluteValue

data class OnboardingPagerItem(val image: Painter, val text: String) : PagerItem {

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    override fun Draw(pagerScope: PagerScope, index: Int) {
        Column(
            Modifier
                .padding(top = 48.dp)
                .graphicsLayer {
                    val pageOffset = pagerScope.calculateCurrentOffsetForPage(index).absoluteValue
                    alpha = lerp(
                        start = 0.1f,
                        stop = 1f,
                        fraction = 1f - (pageOffset * 2).coerceIn(0f, 1f)
                    )
                }
        ) {
            Image(
                image,
                contentDescription = "Onboarding $index",
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(horizontal = 32.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text,
                Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(horizontal = 24.dp)
                    .padding(top = 36.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body1.copy(fontSize = 18.sp)
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingScreen(onSignUpClick: () -> Unit, onLoginClick: () -> Unit) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

    val onboardingList = listOf(
        OnboardingPagerItem(
            painterResource(R.drawable.ic_launcher_background),
            stringResource(R.string.app_name)
        ),
        OnboardingPagerItem(
            painterResource(R.drawable.ic_launcher_background),
            stringResource(R.string.app_name)
        ),
        OnboardingPagerItem(
            painterResource(R.drawable.ic_launcher_background),
            stringResource(R.string.app_name)
        ),
        OnboardingPagerItem(
            painterResource(R.drawable.ic_launcher_background),
            stringResource(R.string.app_name)
        ),
    )

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (pager, buttons) = createRefs()

        PagerView(
            pagerState = pagerState,
            data = onboardingList,
            modifier = Modifier
                .padding(bottom = 40.dp)
                .constrainAs(pager) {
                    top.linkTo(parent.top)
                    bottom.linkTo(buttons.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    height = Dimension.fillToConstraints
                }
        )

        AuthButtons(
            onMainClick = { onSignUpClick() },
            onSubtitleClick = { onLoginClick() },
            mainActionText = R.string.registration_label,
            subtitleText = R.string.have_an_account_label,
            subtitleActionText = R.string.login_label,
            modifier = Modifier
                .padding(bottom = 36.dp)
                .constrainAs(buttons) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    height = Dimension.wrapContent
                },
            buttonModifier = Modifier.height(48.dp)
        )
    }
}