package com.example.imagesearch.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.imagesearch.android.ui.navigation.host.BaseNavHost
import com.example.imagesearch.android.ui.screens.imageSearchScreen.viewModel.ImageSearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val imageSearchViewModel by viewModel<ImageSearchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BaseNavHost(
                imageSearchViewModel = imageSearchViewModel
            )
        }
    }
}
