package com.example.autocon_mt.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.autocon_mt.ui.vm.MainActivityVM
import com.example.autocon_mt.model.AppDatabase
import com.example.autocon_mt.model.dao.AutoconDao
import com.example.autocon_mt.model.repo.AutoconAppRepositoryImpl
import com.example.autocon_mt.model.repo.AutoconAppReposity
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val viewModelModule = module {
    single { MainActivityVM(get()) }
}

val databaseModule = module {

    fun provideDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "autocon.database")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }


    fun provideDao(database: AppDatabase): AutoconDao {
        return database.autoconDao
    }

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}

val repositoryModule = module {
    fun provideAutoconRepository(context: Context, dao: AutoconDao): AutoconAppReposity {
        return AutoconAppRepositoryImpl(context, dao)
    }

    single { provideAutoconRepository(androidContext(), get()) }
}