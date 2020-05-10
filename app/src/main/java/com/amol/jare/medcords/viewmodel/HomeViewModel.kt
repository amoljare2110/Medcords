package com.amol.jare.medcords.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amol.jare.medcords.model.ApiResponse
import com.amol.jare.medcords.model.ListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel : ViewModel() {

    var realdata = MutableLiveData<ApiResponse>()

    fun getData(inputValue:String) {
        try {

            ListRepository.getInstance().getVal(inputValue)

            ListRepository.getInstance().getList {isSuccess, response ->
                if (isSuccess) {
                    CoroutineScope(Dispatchers.IO).launch {
                        realdata.postValue(response)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}