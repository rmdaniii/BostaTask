package com.example.data.dataSource

import com.example.data.entity.Albums
import com.example.data.entity.Photos
import com.example.data.entity.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Network {

    @GET("/users/{userId}")
    fun getUser(@Path("userId") userId: Int): Call<User>

    @GET("/users/{userId}/albums")
    fun getAlbums(@Path("userId") userId: Int): Call<List<Albums>>

    @GET("/albums/{albumId}/photos")
    fun getPhotos(@Path("albumId") albumId: Int): Call<List<Photos>>

}