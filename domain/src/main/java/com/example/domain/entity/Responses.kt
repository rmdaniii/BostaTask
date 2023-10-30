package com.example.domain.entity

data class UserResponse(
    val users: List<User>
)

data class albumsResponse(
    val albums: List<Albums>
)


data class photosResponse(
    val photos: List<Photos>
)