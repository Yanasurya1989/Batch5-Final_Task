package com.yana.batch5_finaltask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.yana.batch5_finaltask.Config.NetworkModule
import com.yana.batch5_finaltask.Module.action.ResponseAction
import com.yana.batch5_finaltask.Module.getData.DataItemHewan
import kotlinx.android.synthetic.main.activity_input.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val getDatahewan = intent.getParcelableExtra<DataItemHewan>("data")

        if (getDatahewan != null) {
            edtNamaHewan.setText(getDatahewan.namaHewan)
            edtJenis.setText(getDatahewan.jenis)
            edtJalan.setText(getDatahewan.caraBerjalan)

            btnSimpan.text = "Update"
        }
        when (btnSimpan.text) {
            "Update" -> {
                btnSimpan.setOnClickListener {
                    updateData(getDatahewan?.id, edtNamaHewan.text.toString(), edtJenis.text.toString(), edtJalan.text.toString())
                }
            }
            else -> {
                btnSimpan.setOnClickListener {
                    inputData(
                        edtNamaHewan.text.toString(),
                        edtJenis.text.toString(),
                        edtJalan.text.toString()
                    )
                }
            }
        }



        btnBatal.setOnClickListener {
            finish()
        }
    }

    private fun inputData(nama: String?, jenis: String?, jalan: String?) {
        val input = NetworkModule.service().insertDataHewan(nama ?: "", jenis ?: "", jalan ?: "")
        input.enqueue(object : Callback<ResponseAction> {
            override fun onResponse(
                call: Call<ResponseAction>,
                response: Response<ResponseAction>
            ) {
                Toast.makeText(applicationContext, "Data berhasil disimpan", Toast.LENGTH_SHORT)
                    .show()
                finish()
            }

            override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun updateData(id: String?, nama: String?, jenis: String?, jalan: String?) {
        val input = NetworkModule.service().updateDataHewan(id ?: "", nama ?: "", jenis ?: "", jalan ?: "")
        input.enqueue(object : Callback<ResponseAction> {
            override fun onResponse(
                call: Call<ResponseAction>,
                response: Response<ResponseAction>
            ) {
                Toast.makeText(applicationContext, "Data berhasil diupdate", Toast.LENGTH_SHORT)
                    .show()
                finish()
            }

            override fun onFailure(call: Call<ResponseAction>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}