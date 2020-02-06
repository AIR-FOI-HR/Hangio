package com.example.ws


import retrofit2.Call
import retrofit2.http.*

interface DataProvider {

    @GET("read.php")
    fun getEvents(): Call<List<Event>>


    @POST("create.php")
    fun addEvent(@Body newEvent:Event):Call<Event>

}