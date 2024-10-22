package com.example.myapplication.views.homepage.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.extensions.toSmallerCase
import com.example.myapplication.common.services.RetrofitBuilder
import com.example.myapplication.views.homepage.data.`interface`.ITunesApiService
import com.example.myapplication.views.homepage.data.models.EntityItemModel
import com.example.myapplication.views.homepage.data.models.ItunesModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import androidx.compose.runtime.State

enum class HomePageStatus {
    SUCCESS, FAILURE
}

enum class EntityType {
    Movie, Podcast, MusicVideo, Audiobook, ShortFilm, TvShow, Software, Ebook
}

class HomePageViewModel : ViewModel() {
    private val apiService = RetrofitBuilder.retrofit
    private var _response: MutableState<HomePageState> = mutableStateOf(
        HomePageState.HomePageSuccess(null)
    )
    var stateVal: State<HomePageState> = _response
    private val iTunesApiService: ITunesApiService = apiService.create(ITunesApiService::class.java)
    val entityList: List<EntityItemModel> = (listOf(
        EntityItemModel(
            id = 0,
            isSelected = false,
            name = EntityType.Movie
        ),
        EntityItemModel(
            id = 1,
            isSelected = false,
            name = EntityType.Podcast
        ),
        EntityItemModel(
            id = 3,
            isSelected = false,
            name = EntityType.MusicVideo
        ),
        EntityItemModel(
            id = 4,
            isSelected = false,
            name = EntityType.Audiobook
        ),
        EntityItemModel(
            id = 5,
            isSelected = false,
            name = EntityType.ShortFilm
        ),
        EntityItemModel(
            id = 6,
            isSelected = false,
            name = EntityType.TvShow
        ),
        EntityItemModel(
            id = 7,
            isSelected = false,
            name = EntityType.Software
        ),
        EntityItemModel(
            id = 8,
            isSelected = false,
            name = EntityType.Ebook
        ),

        ))
    val responseModels: MutableMap<EntityType, ItunesModel> = mutableMapOf(

    )


    fun getAlbumDetails(name: String, entityList: List<EntityType>) {
        if (stateVal.value == HomePageState.HomePageLoading) return
        viewModelScope.launch {
            try {
                _response.value = HomePageState.HomePageLoading
                var iTunesModelEbook: Deferred<ItunesModel>? = null
                var iTunesModelMovie: Deferred<ItunesModel>? = null
                var iTunesModelPodcast: Deferred<ItunesModel>? = null
                var iTunesModelMusicVideo: Deferred<ItunesModel>? = null
                var iTunesModelAudiobook: Deferred<ItunesModel>? = null
                var iTunesModelShortFilm: Deferred<ItunesModel>? = null
                var iTunesModelTvShow: Deferred<ItunesModel>? = null
                var iTunesModelSoftware: Deferred<ItunesModel>? = null

                CoroutineScope(Dispatchers.IO).launch {
                    for (entity in entityList) {
                        when (entity) {
                            EntityType.Ebook -> {
                                iTunesModelEbook = async {
                                    iTunesApiService.getAlbumDetails(
                                        name,
                                        entity.name.toSmallerCase()
                                    )
                                }
                            }

                            EntityType.Movie -> {
                                iTunesModelMovie = async {
                                    iTunesApiService.getAlbumDetails(
                                        name,
                                        entity.name.toSmallerCase()
                                    )
                                }
                            }

                            EntityType.Podcast -> {
                                iTunesModelPodcast = async {
                                    iTunesApiService.getAlbumDetails(
                                        name,
                                        entity.name.toSmallerCase()
                                    )
                                }

                            }

                            EntityType.MusicVideo -> {
                                iTunesModelMusicVideo = async {
                                    iTunesApiService.getAlbumDetails(
                                        name,
                                        entity.name.toSmallerCase()
                                    )
                                }
                            }

                            EntityType.Audiobook -> {
                                iTunesModelAudiobook = async {
                                    iTunesApiService.getAlbumDetails(
                                        name,
                                        entity.name.toSmallerCase()
                                    )
                                }
                            }

                            EntityType.ShortFilm -> {
                                iTunesModelShortFilm = async {
                                    iTunesApiService.getAlbumDetails(
                                        name,
                                        entity.name.toSmallerCase()
                                    )
                                }
                            }

                            EntityType.TvShow -> {
                                iTunesModelTvShow = async {
                                    iTunesApiService.getAlbumDetails(
                                        name,
                                        entity.name.toSmallerCase()
                                    )
                                }
                            }

                            EntityType.Software -> {
                                iTunesModelSoftware = async {
                                    iTunesApiService.getAlbumDetails(
                                        name,
                                        entity.name.toSmallerCase()
                                    )

                                }
                            }
                        }
                        iTunesModelEbook?.await()?.let { responseModels.put(EntityType.Ebook, it) }
                        iTunesModelMovie?.await()?.let { responseModels.put(EntityType.Movie, it) }
                        iTunesModelPodcast?.await()
                            ?.let { responseModels.put(EntityType.Podcast, it) }
                        iTunesModelMusicVideo?.await()
                            ?.let { responseModels.put(EntityType.MusicVideo, it) }
                        iTunesModelAudiobook?.await()
                            ?.let { responseModels.put(EntityType.Audiobook, it) }
                        iTunesModelShortFilm?.await()
                            ?.let { responseModels.put(EntityType.ShortFilm, it) }
                        iTunesModelTvShow?.await()
                            ?.let { responseModels.put(EntityType.TvShow, it) }
                        iTunesModelSoftware?.await()
                            ?.let { responseModels.put(EntityType.Software, it) }

                    }
                    Log.i("Map size", responseModels.size.toString())
                    for (response in responseModels) {
                        Log.i("Values", response.value.toString())
                    }

                    _response.value = HomePageState.HomePageSuccess(
                        HomePageStatus.SUCCESS
                    )
                }

            } catch (e: Exception) {
                _response.value =
                    HomePageState.HomePageFailure(e.message.toString())
            }
        }
    }

}


sealed class HomePageState {


    class HomePageSuccess(
        val state: HomePageStatus?
    ) : HomePageState()

    data object HomePageLoading : HomePageState()
    class HomePageFailure(val msg: String) : HomePageState()

}

