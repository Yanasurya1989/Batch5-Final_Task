package com.yana.batch5_finaltask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.yana.batch5_finaltask.Adapter.AdapterHewan
import com.yana.batch5_finaltask.Config.NetworkModule
import com.yana.batch5_finaltask.Module.action.ResponseAction
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

        fab.setOnClickListener {
            val intent = Intent(this, InputActivity::class.java)
            startActivity(intent)
        }

        showData()

    }
    private fun showData(){
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

                            val intent = Intent(applicationContext, InputActivity::class.java)
                            intent.putExtra("data", item)
                            startActivity(intent)
                        }

                        override fun hapus(item: DataItemHewan?) {

                            AlertDialog.Builder(this@Hewan).apply {
                                setTitle("Hapus Data")
                                setMessage("Are you sure want to delete?")
                                setPositiveButton("Hapus"){ dialog, which ->
                                    hapusData(item?.id)
                                    dialog.dismiss()
                                }
                                setNegativeButton("Batal"){dialog, which ->
                                    dialog.dismiss()
                                }
                            }.show()
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

    private fun hapusData(id: String?) {
        val hapus = NetworkModule.service().deleteDataHewan(id ?: "")
        hapus.enqueue(object : Callback<ResponseAction>{
            override fun onResponse(
                call: Call<ResponseAction>,
                response: Response<ResponseAction>
            ) {
                Toast.makeText(applicationContext, "Data Berhasil dihapus", Toast.LENGTH_SHORT).show()
                showData()
            }

            override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    override fun onResume() {
        super.onResume()
        showData()
    }
}