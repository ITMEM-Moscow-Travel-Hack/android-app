package com.moscow.travel.hack.presentation.view

import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerScope

interface PagerItem {

    @OptIn(ExperimentalPagerApi::class)
    @Composable
    fun Draw(pagerScope: PagerScope, index: Int)
}