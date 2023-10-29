package com.example.domain.repo

import com.example.domain.entity.AlbumsResponse
import com.example.domain.entity.PhotosResponse
import com.example.domain.entity.UsersResponse

interface ProfileRepo {

    suspend fun  getUsersFromRemote() : UsersResponse

    suspend fun  getAlbumsFromRemote() : AlbumsResponse

    suspend fun  getPhotosFromRemote() : PhotosResponse

}