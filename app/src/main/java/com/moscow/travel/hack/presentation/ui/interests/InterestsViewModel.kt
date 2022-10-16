package com.moscow.travel.hack.presentation.ui.interests

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.moscow.travel.hack.R
import com.moscow.travel.hack.data.dto.CategoriesRequest
import com.moscow.travel.hack.data.repository.MTHRepository
import com.moscow.travel.hack.presentation.view.InterestItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InterestsViewModel @Inject constructor(
    private val repository: MTHRepository
) : ViewModel() {

    val categories = mutableStateListOf(
        InterestItem("Музей", R.drawable.ic_camera),
        InterestItem("Достопримечательность", R.drawable.ic_screenshot),
        InterestItem("Жанровая скульптура", R.drawable.ic_brush),
        InterestItem("Православный храм", R.drawable.ic_sun),
        InterestItem("Театр", R.drawable.ic_user),
        InterestItem("Парк культуры", R.drawable.ic_image),
        InterestItem("Астрономия", R.drawable.ic_astro),
        InterestItem("Шоппинг", R.drawable.ic_shop),
        InterestItem("Музыка", R.drawable.ic_music),
    )

    val isButtonEnabled: Boolean
        get() = categories.any { it.isSelected }

    fun sendCategories() {
        viewModelScope.launch {
            repository.sendCategories(
                CategoriesRequest(
                    "123",
                    categories.filter { it.isSelected }.map {
                        it.name
                    }
                ))
        }
    }
}