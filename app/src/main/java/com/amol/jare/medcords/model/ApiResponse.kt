package com.amol.jare.medcords.model


data class ApiResponse(
    val status: Int,
    val errCode: Int,
    val msg: String,
    val data: myData
)

data class myData(
    val rstr: String
)