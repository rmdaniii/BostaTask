package com.example.bostatask.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.AlbumsResponse
import com.example.domain.entity.PhotosResponse
import com.example.domain.entity.UsersResponse
import com.example.domain.usecase.GetAlbumsUseCase
import com.example.domain.usecase.GetPhotosUseCase
import com.example.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModels @Inject constructor(
    private val  getPhotosUseCase: GetPhotosUseCase
) : ViewModel(){

    private val _photos: MutableStateFlow<PhotosResponse?> = MutableStateFlow(null)
    val photos: StateFlow<PhotosResponse?> = _photos

    fun getPhotos(){
        viewModelScope.launch {
            try {
                _photos.value = getPhotosUseCase()
            } catch (e: Exception){
                Log.e("PhotosViewModels",e.message.toString())
            }
        }
    }

}