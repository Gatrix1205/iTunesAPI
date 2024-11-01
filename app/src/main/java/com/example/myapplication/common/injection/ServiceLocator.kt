package com.example.myapplication.common.injection

import com.example.myapplication.common.services.RetrofitBuilder
import com.example.myapplication.views.homepage.data.`interface`.ITunesApiService
import com.example.myapplication.views.homepage.viewmodel.HomePageViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ServiceLocator {


    @Provides
    @Singleton

    fun provideAlbumService(): ITunesApiService {
        return RetrofitBuilder.retrofit.create(ITunesApiService::class.java)
    }

    fun provideAlbumViewModel() : HomePageViewModel {
        return HomePageViewModel(provideAlbumService())

    }

}