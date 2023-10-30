package com.example.domain.repo

import com.example.domain.entity.UserResponse
import com.example.domain.entity.albumsResponse
import com.example.domain.entity.photosResponse
import com.example.domain.usecase.GetUserUseCase

interface ProfileRepo {

    suspend fun getUserUseCase() : UserResponse

    suspend fun getPhotosUseCase(): photosResponse

    suspend fun getAlbumsUseCase(): albumsResponse

}