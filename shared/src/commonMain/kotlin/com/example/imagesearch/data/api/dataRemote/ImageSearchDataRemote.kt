package com.example.imagesearch.data.api.dataRemote

import com.example.imagesearch.data.api.model.GetImageSearchParameters
import com.example.imagesearch.data.api.model.ImageSearchResult
import io.ktor.client.*
import io.ktor.client.request.*

class ImageSearchDataRemote(
    private val httpClient: HttpClient
) {
    suspend fun getSearchImage(parameters: GetImageSearchParameters):ImageSearchResult{
        return httpClient.get(urlString = "/Search/ImageSearchAPI"){
            parameter("q",parameters.search)
            parameter("pageNumber", parameters.pageNumber)
            parameter("pageSize", parameters.pageSize)
            parameter("autoCorrect", parameters.autoCorrect)
        }
    }
}