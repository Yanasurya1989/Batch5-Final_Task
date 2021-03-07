package com.example.batch4week3_yana.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {

    companion object {
        fun getRetrofit(): NewsService {

            val retrofit = Retrofit.Builder()
                .baseUrl("http://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val service: NewsService = retrofit.create(NewsService::class.java)
            return service
        }
    }
}