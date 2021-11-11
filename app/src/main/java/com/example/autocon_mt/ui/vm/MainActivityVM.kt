package com.example.autocon_mt.ui.vm

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.autocon_mt.model.entity.ResponseData
import com.example.autocon_mt.model.entity.ResponseDataDM
import com.example.autocon_mt.model.repo.AutoconAppReposity
import com.google.gson.Gson
import kotlinx.coroutines.launch
import java.io.InputStream

class MainActivityVM(private val autoconAppReposity: AutoconAppReposity) : ViewModel()  {

    val items=autoconAppReposity.getHistoryData()

    private val _navigateToHistory = MutableLiveData<Boolean>(false)
    val navigateToHistoryActivity: LiveData<Boolean>
        get()=_navigateToHistory


    fun loadJson() {
        autoconAppReposity.loadJsonData()
    }

    fun onHistoryClick(){
        _navigateToHistory.value = true
    }
}