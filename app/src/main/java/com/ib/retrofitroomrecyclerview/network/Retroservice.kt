package com.ib.retrofitroomrecyclerview.network

import com.ib.retrofitroomrecyclerview.model.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface Retroservice {
    @GET("repositories")
    suspend fun getDataFromApi(@Query("q") query: String) : RecyclerList
}