package com.example.autocon_mt.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import com.example.autocon_mt.model.entity.ResponseData
import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.OnConflictStrategy.ABORT


@Dao
interface AutoconDao {
    @Insert(onConflict = ABORT)
    fun insertHistoryRecords(responseData: List<ResponseData>)

    @Query("SELECT * FROM tbl_history")
    fun getAllHistoryRecords(): List<ResponseData>

    @Query("SELECT * FROM tbl_history ORDER BY id ASC")
    fun getAllHistoryRecordsPaged(): PagingSource<Int,ResponseData>
}