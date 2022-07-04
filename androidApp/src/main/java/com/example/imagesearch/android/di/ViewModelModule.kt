package com.example.imagesearch.android.di

import com.example.imagesearch.android.ui.screens.imageSearchScreen.viewModel.ImageSearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ImageSearchViewModel(
        imageSearchRepository = get()
    ) }
}