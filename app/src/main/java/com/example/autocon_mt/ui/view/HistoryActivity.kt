package com.example.autocon_mt.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.autocon_mt.databinding.ActivityHistoryBinding
import com.example.autocon_mt.databinding.ActivityMainBinding
import com.example.autocon_mt.ui.vm.MainActivityVM
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryActivity : AppCompatActivity() {

    private val mainActivityVM by viewModel<MainActivityVM>()
    private lateinit var _adapter: AutoconHistoryPagingAdapter
    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        _adapter= AutoconHistoryPagingAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter=_adapter
        }

        lifecycleScope.launch {
            @OptIn(ExperimentalCoroutinesApi::class)
            mainActivityVM.items.collectLatest {
                _adapter.submitData(it)
            }
        }

    }
}