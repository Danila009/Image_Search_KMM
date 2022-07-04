package com.example.imagesearch.android.ui.screens.imageSearchScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStateAtLeast
import coil.compose.rememberAsyncImagePainter
import com.example.imagesearch.android.ui.screens.imageSearchScreen.viewModel.ImageSearchViewModel
import com.example.imagesearch.data.api.model.ImageSearchResultItem
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "FlowOperatorInvokedInComposition")
@Composable
fun ImageSearchScreen(
    viewModel:ImageSearchViewModel
) {
    val lifecycleScope = LocalLifecycleOwner.current.lifecycleScope
    val lifecycle = LocalLifecycleOwner.current.lifecycle

    var search by rememberSaveable { mutableStateOf("") }

    var imageSearchResult by rememberSaveable { mutableStateOf(emptyList<ImageSearchResultItem>()) }

    lifecycleScope.launchWhenStarted {
        lifecycle.whenStateAtLeast(Lifecycle.State.STARTED){
            viewModel.responseImageSearchResult.onEach {
                imageSearchResult = it.value
            }.collect()
        }
    }

    Scaffold(
        topBar = {
            TextField(
                value = search,
                onValueChange = { search = it },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        if (search.isNotEmpty()){
                            viewModel.getImageSearchResult(search)
                        }
                    }
                )
            )
        },
        content = {
            LazyColumn(content = {
                 item {
                     if(imageSearchResult.isEmpty()){
                         Text(text = "English keyboard layout only", color = Color.Red)
                     }
                 }

                items(imageSearchResult){ item ->
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = item.url),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth()
                                .height(300.dp)
                        )

                        Text(
                            text = item.title,
                            fontWeight = FontWeight.W900,
                            fontSize = 18.sp,
                            color = Color.Blue
                        )
                    }
                }
            })
        }
    )
}