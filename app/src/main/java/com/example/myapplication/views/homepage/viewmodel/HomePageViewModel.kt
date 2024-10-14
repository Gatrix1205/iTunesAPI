package com.example.myapplication.views.homepage.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.common.services.RetrofitBuilder
import com.example.myapplication.views.homepage.data.`interface`.ITunesApiService
import com.example.myapplication.views.homepage.data.models.ItunesModel
import kotlinx.coroutines.flow.MutableStateFlow

import kotlinx.coroutines.launch

enum class HomePageStatus{
    SUCCESS, FAILURE
}

class HomePageViewModel : ViewModel(){
    private val apiService = RetrofitBuilder.retrofit
     private var _response  : MutableStateFlow<HomePageState>  = MutableStateFlow(
       HomePageState.HomePageSuccess(null, null)
    )
    var stateVal = _response
    private val iTunesApiService : ITunesApiService = apiService.create(ITunesApiService::class.java)



     fun getAlbumDetails(){
        viewModelScope.launch {
            try{
                val iTunesModel  = iTunesApiService.getAlbumDetails("yuvan")
                _response.value = HomePageState.HomePageLoading
                _response.value = HomePageState.HomePageSuccess(HomePageStatus.SUCCESS, iTunesModel)
            }catch (e: Exception){
                _response.value = HomePageState.HomePageFailure(e.message.toString(), HomePageStatus.FAILURE)
            }
        }
    }
}

sealed class HomePageState{
    class HomePageSuccess(val state: HomePageStatus?, val iTunesModel : ItunesModel?) : HomePageState()
    data object HomePageLoading : HomePageState()
    class HomePageFailure(val msg : String, val state: HomePageStatus) : HomePageState()

}

