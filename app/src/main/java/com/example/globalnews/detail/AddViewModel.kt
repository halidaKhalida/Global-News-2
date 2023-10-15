package com.example.globalnews.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.globalnews.model.ArticlesItem
import com.example.globalnews.model.USANews
import com.example.globalnews.repository.AddRepository
import com.example.globalnews.repository.DetailRepository
import com.example.globalnews.utils.UiStateObject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class AddViewModel(private val repository: AddRepository) : ViewModel() {


//    private val _detailNote = MutableStateFlow<UiStateObject<USANews>>(UiStateObject.EMPTY)
//    val detailNote = _detailNote
//
//    fun getDetail(note: ArticlesItem) = viewModelScope.launch {
//        _detailNote.value = UiStateObject.LOADING
//        try {
//            val response = repository.addNote(note)
//            if (response.code() >= 400) {
//                _detailNote.value = UiStateObject.ERROR(response.errorBody().toString())
//            } else {
//                _detailNote.value = UiStateObject.SUCCESS(response.body()!!)
//            }
//
//
//        } catch (e: Exception) {
//            _detailNote.value = UiStateObject.ERROR("У вас плохое соединение с Интернетом")
//        }
//    }
//
//
//    val detailNote = MutableLiveData<Note>()
//
//
//    fun apiGetNoteById(id: String): LiveData<Note> {
//        ApiClient.apiService.getNoteById(id).enqueue(object : Callback<Note> {
//            override fun onResponse(call: Call<Note>, response: Response<Note>) {
//                if (response.isSuccessful) {
//                    detailNote.value = response.body()!!
//                }
//            }
//
//            override fun onFailure(call: Call<Note>, t: Throwable) {
//
//            }
//        })
//        return detailNote
//    }

}