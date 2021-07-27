package com.yana.batch5_finaltask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.yana.batch5_finaltask.Adapter.AdapterPantai
import com.yana.batch5_finaltask.Adapter.DataAdapter
import com.yana.batch5_finaltask.Config.NetworkModule
import com.yana.batch5_finaltask.Module.DataItem
import com.yana.batch5_finaltask.Module.ResponseGetData
import com.yana.batch5_finaltask.Module.getData.DataItemPantai
import com.yana.batch5_finaltask.Module.getData.ResponseGetDataPantai
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listWisata = NetworkModule.service().getData()
        listWisata.enqueue(object : Callback<ResponseGetData>{
            override fun onResponse(
                call: Call<ResponseGetData>,
                response: Response<ResponseGetData>
            ) {
                if (response.isSuccessful){
                    val item = response.body()?.data
                    val itemPantai = response.body()?.data
                    val adapter = DataAdapter(item, object : DataAdapter.OnClickListener{
                        override fun detail(item: DataItem?) {

                        }

                    })

                    list.adapter = adapter

                }
            }

            override fun onFailure(call: Call<ResponseGetData>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}

