package com.example.autocon_mt.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.autocon_mt.R
import com.example.autocon_mt.model.entity.ResponseData

class HistoryVH(parent: ViewGroup): RecyclerView.ViewHolder (
    LayoutInflater.from(parent.context).inflate(R.layout.history_item,parent,false)) {

    private val text = itemView.findViewById<TextView>(R.id.text)
    var responseData : ResponseData?=null

    fun bindTo(responseData: ResponseData?) {
        this.responseData = responseData
        this.text.text = responseData?.INVH_SERV_MODE + responseData?.id
    }
}
