package com.example.bostatask.di

import com.example.data.dataSource.Network
import com.example.data.repository.profileRepoImpl
import com.example.domain.repo.ProfileRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideRepo(network: Network): ProfileRepo {
        return profileRepoImpl(network)
    }

}