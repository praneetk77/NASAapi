package com.example.kotlinpractice.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.Repo.Repository
import com.example.app.ViewModel.ViewModelFactory
import com.example.kotlinpractice.Model.Info
import com.example.kotlinpractice.R
import com.example.kotlinpractice.ViewModel.NASApictureViewModel

//api key = 313c13065b984bb2b0d7446a542777b8

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapt: MyAdapter
    private lateinit var vm: NASApictureViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inRecyclerView()
        val repos = Repository()
        val viewModelFactory = ViewModelFactory(repos)
        vm = ViewModelProvider(this, viewModelFactory)[NASApictureViewModel::class.java]
        vm.getItem()
        vm.itemMutable.observe(this, Observer {
            adapt.setData(it as ArrayList<Info>)
        })


    }

    private fun inRecyclerView() {
        Log.d("INDIA","going")
        recyclerView = findViewById(R.id.newsList)
        adapt = MyAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapt
        }
    }
}


