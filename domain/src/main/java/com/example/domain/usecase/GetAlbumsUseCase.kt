package com.example.domain.usecase
import com.example.domain.repo.ProfileRepo

class GetAlbumsUseCase (private val profileRepo: ProfileRepo ) {
   suspend operator fun invoke() = profileRepo.getAlbumsUseCase()
}