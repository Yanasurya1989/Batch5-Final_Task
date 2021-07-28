package com.yana.batch5_finaltask.Config

import com.yana.batch5_finaltask.Module.ResponseGetData
import com.yana.batch5_finaltask.Module.action.ResponseAction
import com.yana.batch5_finaltask.Module.getData.ResponseGetDataHewan
import com.yana.batch5_finaltask.Module.getData.ResponseGetDataPantai
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
//    getData
    @GET("getData.php")
    fun getData(): Call<ResponseGetData>

//    getDataPantai
    @GET("getDataPantai.php")
    fun getDataPantai(): Call<ResponseGetDataPantai>

    @GET("getDataHewan.php")
    fun getDataHewan(): Call<ResponseGetDataHewan>

//    get data by id
    @GET("getDataHewan.php")
    fun getDataHewanById(@Query("id") id: String): Call<ResponseGetDataHewan>

//    insert
    @FormUrlEncoded
    @POST("insertDataHewan.php")
    fun insertDataHewan(@Field("nama_hewan") nama_hewan : String,
                        @Field("jenis") jenis: String,
                        @Field("cara_berjalan") cara_berjalan: String
    ): Call<ResponseAction>

//    update
    @FormUrlEncoded
    @POST("updateDataHewan.php")
    fun updateDataHewan(@Field("id") id : String,
                        @Field("nama_hewan") nama_hewan : String,
                        @Field("jenis") jenis: String,
                        @Field("cara_berjalan") cara_berjalan: String
    ): Call<ResponseAction>

//    delete
    @FormUrlEncoded
    @POST("deleteDataHewan.php")
    fun deleteDataHewan(@Field("id") id : String): Call<ResponseAction>
}