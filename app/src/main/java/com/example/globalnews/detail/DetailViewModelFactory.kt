package com.example.globalnews.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.globalnews.repository.AddRepository

class DetailViewModelFactory(private val repository: AddRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddViewModel::class.java)) {
            return AddViewModel(repository) as T
        }
        throw RuntimeException("Unknown Model Class")
    }
}