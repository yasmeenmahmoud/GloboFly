package com.example.globofly.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private const val URL = "http://10.0.2.2:9000/"

    //create okhttp client
    private val okHttp = OkHttpClient.Builder()

    //create retrofit builder
     val builder =
        Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build())

    //retrofit instance
    private val retrofit = builder.build()
    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}