package com.example.ws

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class WebServiceProvider {

    companion object{
        private const val BASE_URL = "http://10.24.33.5/php_rest_hangio/event/"
    }

    private val provider: DataProvider
    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        provider = retrofit.create(DataProvider::class.java)
    }

    fun createEvent(event: Event) {

      val call = provider.addEvent(event)

        call.enqueue(object:Callback<Event>{
            override fun onFailure(call: Call<Event>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<Event>, response: Response<Event>) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
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