package com.yana.batch5_finaltask.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yana.batch5_finaltask.Module.getData.DataItemPantai
import com.yana.batch5_finaltask.R
import kotlinx.android.synthetic.main.list_item.view.*

class AdapterPantai(val dataPantai: List<DataItemPantai>?, val itemClickPantai : OnClickListener):
RecyclerView.Adapter<AdapterPantai.ViewHolder>(){
    class ViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val namaPantai = view.txtNamaPantai
        val lokasiPantai = view.txtLokasiPantai
        val provinsiPantai = view.txtProvPantai
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemPantai = dataPantai?.get(position)
        holder.namaPantai.text = itemPantai?.namaPantai
        holder.lokasiPantai.text = itemPantai?.lokasiPantai
        holder.provinsiPantai.text = itemPantai?.provinsi
        holder.view.setOnClickListener {
            itemClickPantai.detailPantai(itemPantai)
        }

    }

    override fun getItemCount(): Int = dataPantai?.size ?:0

    interface OnClickListener{
        fun detailPantai(itemPantai: DataItemPantai?)
    }
}