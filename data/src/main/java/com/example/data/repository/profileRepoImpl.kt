package com.example.data.repository

import com.example.data.dataSource.Network
import com.example.domain.entity.UserResponse
import com.example.domain.entity.albumsResponse
import com.example.domain.entity.photosResponse
import com.example.domain.repo.ProfileRepo

class profileRepoImpl (private val network: Network): ProfileRepo {
    override suspend fun getUserUseCase(): UserResponse = network.getUser()

    override suspend fun getPhotosUseCase(): photosResponse = network.getPhotos()

    override suspend fun getAlbumsUseCase(): albumsResponse = network.getAlbums()
}