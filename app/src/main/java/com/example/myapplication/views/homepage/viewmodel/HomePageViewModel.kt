package com.example.myapplication.views.homepage.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.services.RetrofitBuilder
import com.example.myapplication.views.homepage.data.`interface`.ITunesApiService
import com.example.myapplication.views.homepage.data.models.EntityItemModel
import com.example.myapplication.views.homepage.data.models.ItunesModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

enum class HomePageStatus{
    SUCCESS, FAILURE
}

enum class EntityType{
    Movie , Podcast,MusicVideo, Audiobook, ShortFilm,TvShow, Software, Ebook
}

class HomePageViewModel : ViewModel(){
    private val apiService = RetrofitBuilder.retrofit
     private var _response  : MutableStateFlow<HomePageState>  = MutableStateFlow(
       HomePageState.HomePageSuccess(null, null)
    )
    var stateVal = _response.asStateFlow()
    private val iTunesApiService : ITunesApiService = apiService.create(ITunesApiService::class.java)
    val entityList : List<EntityItemModel> = (listOf(
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
            id =3,
            isSelected = false,
            name = EntityType.MusicVideo
        ),
        EntityItemModel(
            id =4,
            isSelected = false,
            name =EntityType.Audiobook
        ),
        EntityItemModel(
            id =5,
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



     fun getAlbumDetails(name: String, entityList : List<String>){
        viewModelScope.launch {
            try{
                val iTunesModel  = iTunesApiService.getAlbumDetails(name, entityList[0])
                _response.value = HomePageState.HomePageLoading
                _response.emit(HomePageState.HomePageLoading)
                _response.value = HomePageState.HomePageSuccess(HomePageStatus.SUCCESS, iTunesModel)
                _response.emit(HomePageState.HomePageSuccess(HomePageStatus.SUCCESS, iTunesModel))

            }catch (e: Exception){
                _response.value = HomePageState.HomePageFailure(e.message.toString(), HomePageStatus.FAILURE)
                _response.emit(HomePageState.HomePageFailure(e.message.toString(), HomePageStatus.FAILURE))
            }
        }
    }

}



sealed class HomePageState{
    class HomePageSuccess(val state: HomePageStatus?, val iTunesModel : ItunesModel?) : HomePageState()
    data object HomePageLoading : HomePageState()
    class HomePageFailure(val msg : String, val state: HomePageStatus) : HomePageState()

}

