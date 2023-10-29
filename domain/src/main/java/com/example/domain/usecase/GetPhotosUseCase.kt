package com.example.domain.usecase

import com.example.data.dataSource.PhotoRemoteDataSource
import com.example.domain.entity.Photos

class GetPhotosUseCase(private val photoRemoteDataSource: PhotoRemoteDataSource) {
    suspend fun execute(albumId: Int): List<Photos> {
        return photoRemoteDataSource.getPhotos(albumId)
    }
}