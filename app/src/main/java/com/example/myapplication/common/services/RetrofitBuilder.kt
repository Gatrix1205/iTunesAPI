package com.example.myapplication.common.services

import com.example.myapplication.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    val retrofit : Retrofit = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL_ITUNES_SERVICE).addConverterFactory(
        GsonConverterFactory.create()).build()
}