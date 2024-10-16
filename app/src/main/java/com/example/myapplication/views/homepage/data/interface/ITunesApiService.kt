package com.example.myapplication.views.homepage.data.`interface`
import com.example.myapplication.views.homepage.data.models.ItunesModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ITunesApiService {

    @GET("search")
    suspend fun getAlbumDetails(@Query("term") term: String, @Query("entity") entity: String): ItunesModel
}