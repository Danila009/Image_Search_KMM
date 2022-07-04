package com.example.imagesearch.data.api.model

import kotlinx.serialization.Serializable

@Serializable
data class ImageSearchResult(
    val totalCount:Int,
    val value:List<ImageSearchResultItem>
)

@Serializable
data class ImageSearchResultItem(
    val url:String,
    val title:String
)