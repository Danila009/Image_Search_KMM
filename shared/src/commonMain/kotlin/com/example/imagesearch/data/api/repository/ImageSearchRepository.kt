package com.example.imagesearch.data.api.repository

import com.example.imagesearch.data.api.model.GetImageSearchParameters
import com.example.imagesearch.data.api.model.ImageSearchResult

interface ImageSearchRepository {

    suspend fun getImageSearchResult(parameters:GetImageSearchParameters): ImageSearchResult

}