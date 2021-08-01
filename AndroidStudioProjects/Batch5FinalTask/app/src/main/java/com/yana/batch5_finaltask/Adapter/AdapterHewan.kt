package com.yana.batch5_finaltask.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yana.batch5_finaltask.Module.getData.DataItemHewan
import com.yana.batch5_finaltask.R
import kotlinx.android.synthetic.main.list_hewan.view.*

class AdapterHewan(val datahewan: List<DataItemHewan>?, val itemClick : OnClickListener) :
    RecyclerView.Adapter<AdapterHewan.ViewHolder>(){
        class ViewHolder(val view: View):RecyclerView.ViewHolder(view){
            val namaHewan = view.txtNamaHewan
            val jenis = view.txtJenis
            val caraberjalan = view.txtJalan
            val btnHapus = view.btnHapus
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_hewan, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = datahewan?.get(position)
        holder.namaHewan.text = item?.namaHewan
        holder.jenis.text = item?.jenis
        holder.caraberjalan.text = item?.caraBerjalan

        holder.view.setOnClickListener {
            itemClick.detail(item)
        }

        holder.btnHapus.setOnClickListener {
            itemClick.hapus(item)
        }
    }

    override fun getItemCount(): Int = datahewan?.size ?: 0

    interface OnClickListener{
        fun detail(item: DataItemHewan?)

        fun hapus(item: DataItemHewan?)
    }
}