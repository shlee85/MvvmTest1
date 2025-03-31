package com.example.mvvmtest1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call

//만약 object:Callback<Int>에서 Callback부분이 계속 빨간색인데 해당 import하는 부분이 자동으로 나오지 않으면 수동으로 import해주면 빨간줄 사라진다.
import retrofit2.Callback
import retrofit2.Response

import android.util.Log

class CounterViewModel: ViewModel() {
    //내부에서만 변경 가능한 변수 (MutableLiveData)
    private val _count = MutableLiveData(0)

    //외부에서 읽기만 가능하도록
    val count: LiveData<Int>  get() = _count

    //카운트 증가 함수
    fun increaseCount() {
        _count.value = (_count.value ?: 0) + 1
    }

    //서버에서 랜덤 숫자 호출
    fun fetchRandomNumber() {
        //REST API를 호출하는 메서드.
        //.enqueue (비동기(Async)로 API 요청을 실행 (메인 스레드에서 실행됨)
        RetrofitInstance.api.getRandomNumber().enqueue(object: Callback<List<Int>> {
            override fun onResponse(p0: Call<List<Int>>, p1: Response<List<Int>>) {
                Log.i(TAG, "response : ${p1.body()}")
                if(p1.isSuccessful) {
                    _count.value = p1.body()?.get(0)
                }
            }

            override fun onFailure(p0: Call<List<Int>>, p1: Throwable) {
                Log.i(TAG, "onFailure:${p1.message}")
            }
        })
    }

    companion object {
        val TAG = CounterViewModel::class.java.simpleName
    }
}