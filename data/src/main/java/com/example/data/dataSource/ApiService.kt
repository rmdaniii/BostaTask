package com.example.data.dataSource

import com.example.domain.entity.Albums
import com.example.domain.entity.Photos
import com.example.domain.entity.User



interface UserRemoteDataSource {
    suspend fun getUser(userId: Int): User
}

interface AlbumRemoteDataSource {
    suspend fun getAlbums(userId: Int): List<Albums>
}

interface PhotoRemoteDataSource {
    suspend fun getPhotos(albumId: Int): List<Photos>
}

