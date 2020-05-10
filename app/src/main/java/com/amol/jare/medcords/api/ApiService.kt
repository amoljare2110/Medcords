package com.amol.jare.myapplication.model.api

import com.amol.jare.medcords.model.ApiResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {
    @Headers("Content-Type:application/json")
    @POST("mhc/test_handle_click")
    fun getList(@Body jsonBody: Map<String, String>): Call<ApiResponse>
}