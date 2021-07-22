package com.yana.batch5_finaltask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yana.batch5_finaltask.Config.NetworkModule

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listWisata = NetworkModule.getRetrofit().getData
    }
}