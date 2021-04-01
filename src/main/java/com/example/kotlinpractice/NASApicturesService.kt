package com.example.kotlinpractice

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&apiKey=API_KEY


//https://api.nasa.gov/planetary/apod?api_key=ur65dT0JI2o6Hd3glrzXwzPcdifZhTEsaetuuqyK&start_date=2021-01-01
val BASE_URL = "https://api.nasa.gov/planetary/"
const val API_KEY = "ur65dT0JI2o6Hd3glrzXwzPcdifZhTEsaetuuqyK"

interface NASApicturesInterface {

    @GET("apod?api_key=$API_KEY")
    fun getNASApictures(@Query("start_date") start_date : String) : Call<List<NASApicture>>

    //https://newsapi.org/v2/top-headlines?apiKey=313c13065b984bb2b0d7446a542777b8&country=in&page=1

}

object NASApicturesService{
    val NASApicturesInstance : NASApicturesInterface
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        NASApicturesInstance = retrofit.create(NASApicturesInterface::class.java)
    }
}