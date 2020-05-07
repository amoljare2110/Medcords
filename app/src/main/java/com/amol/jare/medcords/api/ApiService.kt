package com.amol.jare.myapplication.model.api

import com.amol.jare.medcords.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("mhc/test_handle_click")
    fun getList(): Call<ApiResponse>
}