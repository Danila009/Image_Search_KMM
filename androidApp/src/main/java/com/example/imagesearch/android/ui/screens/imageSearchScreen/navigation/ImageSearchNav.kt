package com.example.imagesearch.android.ui.screens.imageSearchScreen.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.imagesearch.android.ui.navigation.NiaNavigationDestination
import com.example.imagesearch.android.ui.screens.imageSearchScreen.ImageSearchScreen
import com.example.imagesearch.android.ui.screens.imageSearchScreen.viewModel.ImageSearchViewModel

object ImageSearchDestination:NiaNavigationDestination {
    override val route: String = "image_search_route"
}

fun NavGraphBuilder.imageSearchNav(
    viewModel: ImageSearchViewModel
) {
    composable(ImageSearchDestination.route){
        ImageSearchScreen(
            viewModel = viewModel
        )
    }
}