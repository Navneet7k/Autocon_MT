package com.example.autocon_mt.model.entity

import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class ResponseDataDM (
    @SerializedName(value = "ResponseData")
    val ResponseData : List<ResponseData>
)

@Entity(tableName = "tbl_history")
data class ResponseData (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerializedName(value = "INVH_SERV_MODE")
    val INVH_SERV_MODE: String,
    @SerializedName(value = "INVH_SM_NAME")
    val INVH_SM_NAME: String?,
)