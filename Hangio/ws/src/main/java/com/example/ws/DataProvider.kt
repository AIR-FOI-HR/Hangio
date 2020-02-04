package com.example.ws

import android.telecom.Call
import retrofit2.http.GET

interface DataProvider {

    @GET("read.php")
    fun getEvents(): retrofit2.Call<List<Event>>
}