package com.example.globalnews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.globalnews.data.remote.ApiClient
import com.example.globalnews.model.ArticlesItem
import com.example.globalnews.model.USANews
import com.example.globalnews.repository.ForYouRepository
import com.example.globalnews.utils.UiStateObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForYouViewModel(private val repository:ForYouRepository):ViewModel() {

//    private val _newsfou= MutableStateFlow<UiStateObject<USANews>>(UiStateObject.EMPTY)
//    val newsfou = _newsfou
//
//
//    fun getMyForYou()=viewModelScope.launch {
//        _newsfou.value=UiStateObject.LOADING
//        try {
//            val response=repository.getHeadlinesNews()
//            if (response.code()>=400){
//                _newsfou.value=UiStateObject.ERROR(response.message())
//            }else{
//                _newsfou.value=UiStateObject.SUCCESS(response.body()!!)
//            }
//
//        } catch (e: Exception){
//            _newsfou.value=UiStateObject.ERROR("No Internet")
        }










//    val allNews=MutableLiveData<ArrayList<ArticlesItem>>()
//    val deleteNews=MutableLiveData<ArticlesItem>()
//    fun apiGetAllNews():LiveData<ArrayList<ArticlesItem>>{
//        ApiClient.apiService.getHeadlinesNews().enqueue(object :Callback<Headlines>{
//            override fun onResponse(
//                call: Call<Headlines>,
//                response: Response<Headlines>
//            ) {
//                if (response.isSuccessful){
//                    allNews.value=response.body(
//                }
//            }
//
//            override fun onFailure(call: Call<Headlines>, t: Throwable) {
//                allNews.value= ArrayList()
//            }
//
//        })
//        return allNews
//    }

