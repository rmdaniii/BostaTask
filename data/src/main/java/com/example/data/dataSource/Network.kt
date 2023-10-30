package com.example.data.dataSource

import com.example.domain.entity.UserResponse
import com.example.domain.entity.albumsResponse
import com.example.domain.entity.photosResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface Network {

    @GET("/users/{userId}")
    fun getUser(): UserResponse

    @GET("/users/{userId}/albums")
    fun getAlbums(): albumsResponse

    @GET("/albums/{albumId}/photos")
    fun getPhotos(): photosResponse

}