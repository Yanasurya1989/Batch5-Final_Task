package com.example.batch4week3_yana.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.batch4week3_yana.R
import com.example.batch4week3_yana.detil.NewsDetil
import com.example.batch4week3_yana.model.News
import kotlinx.android.synthetic.main.newsitem.view.*
import java.util.ArrayList

class NewsAdapter(var articles: MutableList<News>?) : RecyclerView.Adapter<NewsAdapter.NewsHolder>() {
    class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val img = itemView.itemImg
        val textJudulBerita = itemView.textJudulBerita
        val itemDeskripsiBerita = itemView.itemDeskripsiBerita

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.newsitem, parent, false)

        val holder = NewsHolder(view)
        return holder
    }

    override fun getItemCount(): Int {

        return articles?.size ?: 0
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.textJudulBerita.text = articles?.get(position)?.title

        Glide.with(holder.itemView.context).load(articles?.get(position)?.urlToImage)
            .into(holder.img)

        holder.itemView.setOnClickListener {
//        action click
            val intent = Intent(holder.itemView.context, NewsDetil::class.java)
            intent.putExtra("jdl", articles?.get(position)?.title)
            intent.putExtra("img", articles?.get(position)?.urlToImage)
            intent.putExtra("desk", articles?.get(position)?.description)

            holder.itemView.context.startActivity(intent)
        }
    }
}