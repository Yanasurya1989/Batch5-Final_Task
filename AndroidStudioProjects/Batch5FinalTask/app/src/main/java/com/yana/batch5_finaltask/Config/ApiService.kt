package com.yana.batch5_finaltask.Config

import com.yana.batch5_finaltask.Module.ResponseGetData
import com.yana.batch5_finaltask.Module.getData.ResponseGetDataPantai
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
//    getData
    @GET("getData.php")
    fun getData(): Call<ResponseGetData>

//    getDataPantai
    @GET("getDataPantai.php")
    fun getDataPantai(): Call<ResponseGetDataPantai>
}