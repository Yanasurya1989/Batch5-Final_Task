package com.example.batch4week3_yana.network

import com.example.batch4week3_yana.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface NewsService {

    @GET("v2/everything?q=tesla&from=2021-02-02&sortBy=publishedAt&apiKey=9ef3c81be6b04995b9cf4f610c2d01e5")
    fun getDataNews(): Call<ResponseServer>

    @GET("v2/top-headlines?country=us&category=business&apiKey=9ef3c81be6b04995b9cf4f610c2d01e5")
    fun getDataTopBusinesNews(): Call<ResponseServer>

    @GET("v2/top-headlines?sources=techcrunch&apiKey=9ef3c81be6b04995b9cf4f610c2d01e5")
    fun getDataTech(): Call<ResponseServer>

    @GET("v2/everything?domains=wsj.com&apiKey=9ef3c81be6b04995b9cf4f610c2d01e5")
    fun getDataWS(): Call<ResponseServer>

}