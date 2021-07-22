package com.yana.batch5_finaltask.Config

import com.yana.batch5_finaltask.Module.ResponseGetData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
//    getData
    @GET("getData.php")
    fun getData(): Call<ResponseGetData>

//    getDataById
}