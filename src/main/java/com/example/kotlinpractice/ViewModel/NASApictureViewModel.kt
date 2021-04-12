package com.example.kotlinpractice.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.Repo.Repository
import com.example.kotlinpractice.Model.Info
import com.example.kotlinpractice.Model.NASApicture
import com.example.kotlinpractice.Network.NASApicturesService
import com.example.kotlinpractice.View.MyAdapter
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NASApictureViewModel(private val Repository: Repository) : ViewModel() {

    val itemMutable: MutableLiveData<List<Info>> = MutableLiveData()
    fun getItem() {
        viewModelScope.launch {
            try {
                Log.d("main","Worked")
                val response: List<Info> = Repository.getItem()
                itemMutable.value = response
            }
            catch (e: Exception){
                Log.d("main", "getPost: ${e.message}")
            }
        }
    }


}