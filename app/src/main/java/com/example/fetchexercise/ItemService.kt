package com.example.fetchexercise

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ItemService {
    @GET("/hiring.json")
    suspend fun getItems(): List<ItemData>
}

object RetrofitInstance {
    private val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"
    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
        GsonConverterFactory.create()).build()
    val api = retrofit.create(ItemService::class.java)
}
