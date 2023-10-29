package com.example.data.dataSource

import com.example.domain.entity.AlbumsResponse
import com.example.domain.entity.PhotosResponse
import com.example.domain.entity.UsersResponse
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): UsersResponse

    @GET("albums")
    suspend fun getAlbums(): AlbumsResponse

    @GET("photos")
    suspend fun getPhotos(): PhotosResponse


}