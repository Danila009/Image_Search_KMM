package com.example.imagesearch.android.ui.screens.imageSearchScreen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagesearch.data.api.model.GetImageSearchParameters
import com.example.imagesearch.data.api.model.ImageSearchResult
import com.example.imagesearch.data.api.repository.ImageSearchRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

class ImageSearchViewModel(
    private val imageSearchRepository: ImageSearchRepository
):ViewModel() {

    private val _responseImageSearchResult:MutableStateFlow<ImageSearchResult?> =
        MutableStateFlow(null)
    val responseImageSearchResult = _responseImageSearchResult.asStateFlow().filterNotNull()

    fun getImageSearchResult(search:String){
        viewModelScope.launch {
            val response = imageSearchRepository.getImageSearchResult(
                GetImageSearchParameters(
                    search = search
                )
            )
            _responseImageSearchResult.value = response
        }
    }
}