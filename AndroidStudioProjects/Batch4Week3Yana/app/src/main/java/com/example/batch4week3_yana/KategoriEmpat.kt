package com.example.batch4week3_yana

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import com.example.batch4week3_yana.adapter.NewsAdapter
import com.example.batch4week3_yana.model.News
import com.example.batch4week3_yana.model.ResponseServer
import com.example.batch4week3_yana.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_kategori_dua.*
import kotlinx.android.synthetic.main.activity_kategori_dua.listNews
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_kategori_dua.progress as progress1
import kotlinx.android.synthetic.main.activity_main.searchView as searchView1

class KategoriEmpat : AppCompatActivity() {
    var articles: MutableList<News>? = null
    var adapter: NewsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kategori_empat)

        val search = findViewById<SearchView>(R.id.searchView)
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                searchView.clearFocus()

                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                var new_data: MutableList<News> = ArrayList()
                for (i in articles!!.indices) {
                    if (articles?.get(i)?.title?.contains(p0 ?: "") ?: false) {
                        new_data.add(articles!!.get(i))
                        // adapter.filter.filter(p0)
                    }
                }

                adapter = NewsAdapter(new_data)
                listNews.adapter = adapter
                return false
            }
        })
        if (isConnect()) {
            ConfigNetwork.getRetrofit().getDataTech().enqueue(object : Callback<ResponseServer> {
                override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
                    progress.visibility = View.GONE
                    t.message?.let { Log.d("error server", it) }
                }

                override fun onResponse(
                    call: Call<ResponseServer>,
                    response: Response<ResponseServer>
                ) {
                    Log.d("response server", response.message())

                    if (response.isSuccessful) {
                        progress.visibility = View.GONE

//                        val status = response.body()?.status
                        val status = response.body()?.status

                        if (status == "ok") {

                            articles = response.body()?.articles
                            showArticles(articles)
                        }
                    }
                }
            })
        } else {
            progress.visibility = View.GONE
            Toast.makeText(this, "device tidak terkoneksi dengan internet", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun showArticles(articles: MutableList<News>?) {
        TODO("Not yet implemented")
    }

    private fun isConnect(): Boolean {
        val connect: ConnectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return connect.activeNetworkInfo != null && connect.activeNetworkInfo!!.isConnected
    }
}

