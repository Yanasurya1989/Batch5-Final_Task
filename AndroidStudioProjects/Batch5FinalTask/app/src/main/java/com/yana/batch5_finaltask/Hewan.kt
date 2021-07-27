package com.yana.batch5_finaltask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.yana.batch5_finaltask.Adapter.AdapterHewan
import com.yana.batch5_finaltask.Config.NetworkModule
import com.yana.batch5_finaltask.Module.getData.DataItemHewan
import com.yana.batch5_finaltask.Module.getData.ResponseGetDataHewan
import kotlinx.android.synthetic.main.activity_hewan.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Hewan : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hewan)

        val listHewan = NetworkModule.service().getDataHewan()
        listHewan.enqueue(object : Callback<ResponseGetDataHewan>{
            override fun onResponse(
                call: Call<ResponseGetDataHewan>,
                response: Response<ResponseGetDataHewan>
            ) {
                if (response.isSuccessful){
                    val item = response.body()?.data
                    val adapter = AdapterHewan(item, object : AdapterHewan.OnClickListener{
                        override fun detail(item: DataItemHewan?) {

                        }

                    })
                    list_hewan.adapter=adapter
                }
            }

            override fun onFailure(call: Call<ResponseGetDataHewan>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }


        })
    }
}