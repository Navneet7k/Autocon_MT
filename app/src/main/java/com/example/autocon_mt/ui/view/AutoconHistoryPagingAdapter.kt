package com.example.autocon_mt.ui.view

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.autocon_mt.model.entity.ResponseData

class AutoconHistoryPagingAdapter() : PagingDataAdapter<ResponseData, HistoryVH>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object :
        DiffUtil.ItemCallback<ResponseData>(){
            override fun areContentsTheSame(oldItem: ResponseData, newItem: ResponseData): Boolean = oldItem==newItem

            override fun areItemsTheSame(oldItem: ResponseData, newItem: ResponseData): Boolean = oldItem.id==newItem.id
        }
    }

    override fun onBindViewHolder(holder: HistoryVH, position: Int) {
        val responseData:ResponseData?=getItem(position)
        holder.bindTo(responseData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryVH {
        return HistoryVH(parent)
    }
}


