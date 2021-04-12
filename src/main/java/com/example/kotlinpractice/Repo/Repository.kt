
package com.example.app.Repo

import android.util.Log
import com.example.kotlinpractice.Model.Info
import com.example.kotlinpractice.Model.NASApicture
import com.example.kotlinpractice.Network.NASApicturesService

class Repository {

    suspend fun getItem(): List<Info> {
        Log.d("GETITEM","worked")
        val list : List<com.example.kotlinpractice.Model.Info> = NASApicturesService.api.getInfo()
        if(list==null)Log.d("GETITEM","null")
        else Log.d("GETITEM","not null")
        return list
    }

}