package com.example.kotlinpractice.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.kotlinpractice.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val imagev = findViewById<ImageView>(R.id.image)
        val titletv = findViewById<TextView>(R.id.title)
        val datetv = findViewById<TextView>(R.id.date)
        val explanationtv = findViewById<TextView>(R.id.desc)

        val intent = intent

        val title = intent.getStringExtra("title")
        val date = intent.getStringExtra("date")
        val explanation = intent.getStringExtra("explanation")
        val url = intent.getStringExtra("url")

        Glide.with(this)
            .load(url)
            .into(imagev)
        titletv.text = title
        datetv.text = date
        explanationtv.text = explanation

    }
}