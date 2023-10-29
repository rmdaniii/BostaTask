package com.example.data.dataSource

import com.example.data.entity.Albums
import com.example.data.entity.Photos
import com.example.data.entity.User



interface UserRemoteDataSource {
    suspend fun getUser(userId: Int): User
}

interface AlbumRemoteDataSource {
    suspend fun getAlbums(userId: Int): List<Albums>
}

interface PhotoRemoteDataSource {
    suspend fun getPhotos(albumId: Int): List<Photos>
}

