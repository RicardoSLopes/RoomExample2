package com.example.roomexample

import android.app.Application
import com.example.roomexample.di.dbModule
import com.example.roomexample.di.repositoryModule
import com.example.roomexample.di.uiModule
import com.example.roomexample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(
                listOf(
                    viewModelModule,
                    uiModule,
                    dbModule,
                    repositoryModule
                )
            )
        }
    }
}