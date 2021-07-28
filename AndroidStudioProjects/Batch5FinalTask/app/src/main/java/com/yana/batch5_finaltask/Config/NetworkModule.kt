package com.yana.batch5_finaltask.Config

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("http://192.168.53.77/finaltask_batch5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    fun service(): ApiService = getRetrofit().create(ApiService::class.java)

}