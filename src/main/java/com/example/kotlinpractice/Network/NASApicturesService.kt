package com.example.kotlinpractice.Network

import com.example.kotlinpractice.Model.Info
import com.example.kotlinpractice.Model.NASApicture
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?country=in&apiKey=API_KEY


//https://api.nasa.gov/planetary/apod?api_key=ur65dT0JI2o6Hd3glrzXwzPcdifZhTEsaetuuqyK&start_date=2021-01-01
val base = "https://jsonplaceholder.typicode.com"
val BASE_URL = "https://api.nasa.gov/planetary/"
const val API_KEY = "ur65dT0JI2o6Hd3glrzXwzPcdifZhTEsaetuuqyK"

interface NASApicturesInterface {

    @GET("/posts")
    suspend fun getInfo(): List<Info>

//    @GET("apod?api_key=$API_KEY")
//    suspend fun getNASApictures(@Query("start_date") start_date : String) : List<NASApicture>


}

object NASApicturesService{

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: NASApicturesInterface by lazy {
        retrofit.create(NASApicturesInterface::class.java)
    }

//    val NASApicturesInstance : NASApicturesInterface
//    init{
//        val retrofit = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        NASApicturesInstance = retrofit.create(
//            NASApicturesInterface::class.java)
//    }


//    private val retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(Url.baseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//    val api: ApiInterface by lazy {
//        retrofit.create(ApiInterface::class.java)
//    }
}