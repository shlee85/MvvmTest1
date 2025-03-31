package com.example.mvvmtest1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    //내부에서만 변경 가능한 변수 (MutableLiveData)
    private val _count = MutableLiveData(0)

    //외부에서 읽기만 가능하도록
    val count: LiveData<Int>  get() = _count

    //카운트 증가 함수
    fun increaseCount() {
        _count.value = (_count.value ?: 0) + 1
    }
}