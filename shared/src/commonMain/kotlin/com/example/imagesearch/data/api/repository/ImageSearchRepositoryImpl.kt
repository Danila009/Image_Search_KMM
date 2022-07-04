package com.example.imagesearch.data.api.repository

import com.example.imagesearch.data.api.dataRemote.ImageSearchDataRemote
import com.example.imagesearch.data.api.model.GetImageSearchParameters
import com.example.imagesearch.data.api.model.ImageSearchResult

class ImageSearchRepositoryImpl(
    private val dataRemote: ImageSearchDataRemote
):ImageSearchRepository {

    override suspend fun getImageSearchResult(parameters: GetImageSearchParameters): ImageSearchResult {
        return dataRemote.getSearchImage(parameters = parameters)
    }
}