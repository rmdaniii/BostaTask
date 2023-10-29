package com.example.bostatask.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.AlbumsResponse
import com.example.domain.entity.UsersResponse
import com.example.domain.usecase.GetAlbumsUseCase
import com.example.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModels @Inject constructor(
    private val  getAlbumsUseCase: GetAlbumsUseCase
) : ViewModel(){

    private val _albums: MutableStateFlow<AlbumsResponse?> = MutableStateFlow(null)
    val albums: StateFlow<AlbumsResponse?> = _albums

    fun getAlbums(){
        viewModelScope.launch {
            try {
                _albums.value = getAlbumsUseCase()
            } catch (e: Exception){
                Log.e("AlbumsViewModels",e.message.toString())
            }
        }
    }

}