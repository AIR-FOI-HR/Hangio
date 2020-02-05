package com.example.ws

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class WebServiceProvider {

    companion object{
        private const val BASE_URL = "http://10.24.31.26/php_rest_hangio/event/"
    }

    private val provider: DataProvider
    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        provider = retrofit.create(DataProvider::class.java)
    }

    fun getEvents(responseHandler: ResponseHandler){
        val call = provider.getEvents()

        call.enqueue(object: Callback<List<Event>>{
            override fun onFailure(call: Call<List<Event>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Event>>, response: Response<List<Event>>) {
                if(response.isSuccessful){
                    responseHandler.onData(response.body()!!)
                }
            }
        })
    }
}