package com.example.imagesearch.android.ui.navigation.host

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.imagesearch.android.ui.screens.imageSearchScreen.navigation.ImageSearchDestination
import com.example.imagesearch.android.ui.screens.imageSearchScreen.navigation.imageSearchNav
import com.example.imagesearch.android.ui.screens.imageSearchScreen.viewModel.ImageSearchViewModel

@Composable
fun BaseNavHost(
    imageSearchViewModel: ImageSearchViewModel
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = ImageSearchDestination.route,
        builder = {
            imageSearchNav(
                viewModel = imageSearchViewModel
            )
        }
    )
}