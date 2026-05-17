package com.rlb.yaounde_taxi_price.android

import android.app.Application
import com.rlb.yaounde_taxi_price.di.sharedModule
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@HiltAndroidApp
class App: Application() {
    override fun onCreate(){
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(sharedModule)
        }

    }

}