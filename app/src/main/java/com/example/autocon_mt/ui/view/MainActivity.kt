package com.example.autocon_mt.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.autocon_mt.ui.vm.MainActivityVM
import com.example.autocon_mt.databinding.ActivityMainBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainActivityVM by viewModel<MainActivityVM>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lifecycleOwner=this
        binding.viewModel = mainActivityVM

        mainActivityVM.loadJson()

        mainActivityVM.navigateToHistoryActivity.observe(this,{
            if (it){
                val intent = Intent(this, HistoryActivity::class.java)
                startActivity(intent)
            }
        })
    }
}