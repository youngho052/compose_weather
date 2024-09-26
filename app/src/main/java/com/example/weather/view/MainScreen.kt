package com.example.weather.view

import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weather.viewmodel.MainScreenViewModel
import com.skydoves.landscapist.glide.GlideImage
import timber.log.Timber

@Composable
fun MainScreen (
    mainScreenViewModel: MainScreenViewModel
) {
    val mainScreenUiState = mainScreenViewModel.mainScreenUiState.collectAsState()

    Timber.d("main screen ui state result ${mainScreenUiState.value.menuItems}")

    Text(text = "${mainScreenUiState.value.menuItems.number}")

    GlideImage(
        imageModel = { mainScreenUiState.value.menuItems.menuItems[0].image },
        modifier = Modifier.size(100.dp)
    )
}