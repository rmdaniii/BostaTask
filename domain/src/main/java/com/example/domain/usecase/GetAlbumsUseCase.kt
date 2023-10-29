package com.example.domain.usecase
import com.example.data.dataSource.AlbumRemoteDataSource
import com.example.domain.entity.Albums
import com.example.domain.repo.ProfileRepo

class GetAlbumsUseCase (private val albumRemoteDataSource: AlbumRemoteDataSource ) {
    suspend fun execute(userId: Int): List<Albums> {
        return albumRemoteDataSource.getAlbums(userId)
    }
}