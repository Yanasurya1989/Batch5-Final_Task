package com.yana.batch5_finaltask.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yana.batch5_finaltask.Module.DataItem
import com.yana.batch5_finaltask.R
import kotlinx.android.synthetic.main.list_item.view.*

class DataAdapter (val data: List<DataItem>?, val itemClick : OnClickListener) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){

        val namaWisata = view.txtNamaWisata
        val lokasi = view.txtLokasi
        val alamat = view.txtAlamat

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = data?.get(position)
        holder.namaWisata.text = item?.namaTempat
        holder.lokasi.text = item?.lokasi
        holder.alamat.text = item?.alamat
        holder.view.setOnClickListener {
            itemClick.detail(item)
        }

    }

    override fun getItemCount(): Int = data?.size ?: 0

    interface OnClickListener{
        fun detail(item: DataItem?)
    }

}