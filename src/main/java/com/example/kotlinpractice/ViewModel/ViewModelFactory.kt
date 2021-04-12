package com.example.app.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app.Repo.Repository
import com.example.kotlinpractice.ViewModel.NASApictureViewModel

//import com.example.kotlinpractice.ViewModel.NASApictureViewModel

class ViewModelFactory(private val rep: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NASApictureViewModel(rep) as T
    }
}