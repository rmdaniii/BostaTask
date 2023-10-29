package com.example.data.repository

import com.example.data.dataSource.ApiService
import com.example.domain.entity.AlbumsResponse
import com.example.domain.entity.PhotosResponse
import com.example.domain.entity.UsersResponse
import com.example.domain.repo.ProfileRepo

class ProfilesRepoImpl (private val apiService: ApiService) : ProfileRepo {

    override suspend fun getUsersFromRemote(): UsersResponse = apiService.getUsers()

    override suspend fun getAlbumsFromRemote(): AlbumsResponse = apiService.getAlbums()

    override suspend fun getPhotosFromRemote(): PhotosResponse = apiService.getPhotos()


}