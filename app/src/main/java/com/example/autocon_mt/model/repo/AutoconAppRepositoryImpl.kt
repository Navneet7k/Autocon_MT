package com.example.autocon_mt.model.repo

import android.content.Context
import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.autocon_mt.model.dao.AutoconDao
import com.example.autocon_mt.model.entity.ResponseData
import com.example.autocon_mt.model.entity.ResponseDataDM
import com.google.gson.Gson
import kotlinx.coroutines.launch
import java.io.InputStream
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AutoconAppRepositoryImpl(private val context: Context,
                                   private val dao: AutoconDao) : AutoconAppReposity {

    private val mExecutor: Executor = Executors.newSingleThreadExecutor()
    override fun getHistoryData() =
        Pager(
            PagingConfig(
                pageSize = 10,
                maxSize = 100,
                enablePlaceholders = true
            )
        ) {
            dao.getAllHistoryRecordsPaged()
        }.flow


    override fun saveJsonData(h_data: List<ResponseData>) {
        mExecutor.execute {
                dao.insertHistoryRecords(h_data)
        }
    }



    override fun loadJsonData() {
        var input: InputStream?=null
        val jsonString:String

        try {
            input=context.assets.open("history.json")
            val size = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            jsonString= String(buffer)
            val historyList = Gson().fromJson(jsonString, ResponseDataDM::class.java)
            saveJsonData(historyList.ResponseData)

        } catch (e:Exception){
            Log.d("TAG", "my Message")
        } finally {
            input?.close()
        }
    }
}