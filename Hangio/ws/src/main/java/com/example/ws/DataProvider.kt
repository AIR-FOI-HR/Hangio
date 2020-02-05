package com.example.ws


import retrofit2.Call
import retrofit2.http.GET

interface DataProvider {

    @GET("read.php")
    fun getEvents(): Call<List<Event>>
}