package com.example.domain.usecase
import com.example.data.dataSource.AlbumRemoteDataSource
import com.example.data.entity.Albums

class GetAlbumsUseCase (private val albumRemoteDataSource: AlbumRemoteDataSource ) {
    suspend fun execute(userId: Int): List<Albums> {
        return albumRemoteDataSource.getAlbums(userId)
    }
}