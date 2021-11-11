package com.example.autocon_mt.model.repo

import androidx.paging.Pager
import androidx.paging.PagingData
import com.example.autocon_mt.model.entity.ResponseData
import kotlinx.coroutines.flow.Flow

interface AutoconAppReposity {
    fun getHistoryData() : Flow<PagingData<ResponseData>>
    fun saveJsonData(h_data:List<ResponseData>)
    fun loadJsonData()
}