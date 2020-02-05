package com.example.ws

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Event(
    @SerializedName("idevent") var idevent: Int,
    @SerializedName("title") var title: String,
    @SerializedName("start_date") var start_date: String,
    @SerializedName("address") var address: String,
    @SerializedName("description") var description: String,
    @SerializedName("capacity") var capacity: Int,
    @SerializedName("registered") var registered: Int,
    @SerializedName("creator_id") var creator_id: Int,
    @SerializedName("city_id") var city_id: Int,
    @SerializedName("event_category_id") var event_category_id: Int
    ): Serializable

//    @SerializedName("userId") var userId: String,
//    @SerializedName("id") var id: Int,
//    @SerializedName("title") var title: String,
//    @SerializedName("completed") var completed: Boolean
//):Serializable

