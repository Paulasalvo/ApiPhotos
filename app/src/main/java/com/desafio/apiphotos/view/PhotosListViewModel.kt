package com.desafio.apiphotos.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desafio.apiphotos.model.dto.PhotosDTO
import com.desafio.apiphotos.model.dto.api.PhotoApi
import com.desafio.apiphotos.model.dto.api.getPhotosListService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PhotosListViewModel : ViewModel() {

    private val photosApi: PhotoApi = getPhotosListService()
    val photosListLiveData: MutableLiveData<List<PhotosDTO>> = MutableLiveData()


    fun fetchPhotosList() {
        viewModelScope.launch(Dispatchers.IO) {
                val photosList = photosApi.getPhotosList()
            photosListLiveData.postValue(photosList)
        }
    }



}
