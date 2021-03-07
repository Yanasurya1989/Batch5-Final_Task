package com.example.batch4week3_yana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        kategori1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        kategori2.setOnClickListener {
            val Cat2 = Intent(this, KategoriDua::class.java)
            startActivity(Cat2)
        }

        kategori3.setOnClickListener {
            val Cat3 = Intent(this, KategoriTiga::class.java)
            startActivity(Cat3)
        }

    }
}