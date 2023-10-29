package com.example.domain.usecase

import com.example.domain.repo.ProfileRepo

class GetPhotosUseCase(private val profileRepo: ProfileRepo) {

    suspend operator fun invoke() = profileRepo.getPhotosFromRemote()

}