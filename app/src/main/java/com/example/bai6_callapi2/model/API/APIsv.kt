package com.example.bai6_callapi2.model.API

import com.example.bai6_callapi2.model.UsersResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIsv {
    @GET("api/?results=20")
    fun getUsers(): Call<UsersResponse>
}

object RetrofitInstance {
    private const val BASE_URL = "https://randomuser.me/"

    val api: APIsv by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIsv::class.java)
    }
}