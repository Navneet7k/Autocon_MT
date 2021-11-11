package com.example.autocon_mt.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.autocon_mt.model.dao.AutoconDao
import com.example.autocon_mt.model.entity.ResponseData

@Database(entities = [ResponseData::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val autoconDao: AutoconDao
}