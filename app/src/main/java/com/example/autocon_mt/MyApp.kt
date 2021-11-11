package com.example.autocon_mt

import android.app.Application
import com.example.autocon_mt.di.databaseModule
import com.example.autocon_mt.di.repositoryModule
import com.example.autocon_mt.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
      startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(listOf(
                viewModelModule,
                databaseModule,
                repositoryModule
            )
            )
        }
    }
}