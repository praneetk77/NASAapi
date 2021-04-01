package com.example.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AtomicFile
import android.util.Log
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//api key = 313c13065b984bb2b0d7446a542777b8

class MainActivity : AppCompatActivity() {

    lateinit var adapter:MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNASApictures()
    }

    private fun getNASApictures(){
        val pictures = NASApicturesService.NASApicturesInstance.getNASApictures("2021-03-20")
//        val news = NewsService.newsInstance.getHeadlines("in",1)
        pictures.enqueue(object : Callback<List<NASApicture>>{
            override fun onFailure(call: Call<List<NASApicture>>, t: Throwable) {
                Log.d("NASA","Error",t)
            }

            override fun onResponse(call: Call<List<NASApicture>>, response: Response<List<NASApicture>>) {
                val pictures = response.body()
                if(pictures!=null){
                    Log.d("NASA", pictures.toString())
                    adapter = MyAdapter(this@MainActivity,pictures.reversed())
                    val newsList = findViewById<RecyclerView>(R.id.newsList)
                    newsList.adapter = adapter
                    newsList.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

        })

    }
}


