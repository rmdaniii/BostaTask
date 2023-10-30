package com.example.data.dataSource

import com.example.domain.entity.Albums
import com.example.domain.entity.Photos
import com.example.domain.entity.User



interface UserRemoteDataSource {
    suspend fun getUser(userId: Int): com.example.domain.entity.User
}

interface AlbumRemoteDataSource {
    suspend fun getAlbums(userId: Int): List<com.example.domain.entity.Albums>
}

interface PhotoRemoteDataSource {
    suspend fun getPhotos(albumId: Int): List<com.example.domain.entity.Photos>
}

