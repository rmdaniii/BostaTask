package com.example.domain.usecase
import com.example.data.dataSource.UserRemoteDataSource
import com.example.data.entity.User

class GetUserUseCase(private val userRemoteDataSource: UserRemoteDataSource) {
    suspend fun execute(userId: Int): User {
        return userRemoteDataSource.getUser(userId)
    }
}