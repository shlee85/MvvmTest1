package com.example.mvvmtest1

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.mvvmtest1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //ViewModel 초기화
    private val viewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //LiveData 옵져빙 ( 관찰 하여 변경시 UI 업데이트 )
        viewModel.count.observe(this, Observer { count ->
            binding.tvCount.text = count.toString()
        })

        //버튼 클릭시 viewModel의 count증가
        binding.btnIncrease.setOnClickListener {
            viewModel.increaseCount()
        }

        binding.btnRandom.setOnClickListener {
            viewModel.fetchRandomNumber()
        }
    }
}