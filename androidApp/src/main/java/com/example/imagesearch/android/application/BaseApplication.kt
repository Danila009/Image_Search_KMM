package com.example.imagesearch.android.application

import android.app.Application
import com.example.imagesearch.android.di.viewModelModule
import com.example.imagesearch.di.initKoin
import org.koin.android.ext.koin.androidContext

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@BaseApplication)
            modules(
                viewModelModule
            )
        }
    }
}