package com.example.imagesearch.di

import com.example.imagesearch.data.api.dataRemote.ImageSearchDataRemote
import com.example.imagesearch.data.api.repository.ImageSearchRepository
import com.example.imagesearch.data.api.repository.ImageSearchRepositoryImpl
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(
        ktorModule,
        dataRemoteModule,
        repositoryModule
    )
}

// IOS
fun initKoin() = initKoin {}

val ktorModule = module {
    single {
        HttpClient {
            install(JsonFeature) {
                val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
                serializer = KotlinxSerializer(json)
            }
            defaultRequest {
                url {
                    val basePath = "/api/"
                    protocol = URLProtocol.HTTPS
                    host = "contextualwebsearch-websearch-v1.p.rapidapi.com"
                    encodedPath = "$basePath$encodedPath"
                }
                header("X-RapidAPI-Key","ef79fc988fmsheb45817ca6ce2dbp164c0bjsn1df6d809922b")
            }
        }
    }
}

val dataRemoteModule = module {
    single { ImageSearchDataRemote(
        httpClient = get()
    ) }
}

val repositoryModule = module {

    single<ImageSearchRepository> {  ImageSearchRepositoryImpl(
        dataRemote = get()
    )}
}