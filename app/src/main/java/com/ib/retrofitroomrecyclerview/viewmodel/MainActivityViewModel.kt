package com.ib.retrofitroomrecyclerview.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ib.retrofitroomrecyclerview.model.RecyclerList
import com.ib.retrofitroomrecyclerview.network.RetrofitInstance
import com.ib.retrofitroomrecyclerview.network.Retroservice
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private var recyclerListLiveData: MutableLiveData<RecyclerList>
    init {
        recyclerListLiveData = MutableLiveData()
    }

    fun getRecyclerListObserver(): MutableLiveData<RecyclerList>{
        return recyclerListLiveData
    }

    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO) {
            val retrofitInstance = RetrofitInstance.getRetroInstance().create(Retroservice::class.java)
            val response = retrofitInstance.getDataFromApi("ny")
            recyclerListLiveData.postValue(response)
        }
    }
}