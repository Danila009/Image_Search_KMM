package com.example.imagesearch.data.api.model

data class GetImageSearchParameters(
    val search:String,
    val pageNumber:Int = 1,
    val pageSize:Int = 50,
    val autoCorrect:Boolean = true
)