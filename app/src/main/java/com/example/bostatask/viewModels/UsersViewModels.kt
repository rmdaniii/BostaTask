package com.example.bostatask.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.UsersResponse
import com.example.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModels @Inject constructor(
    private val  getUserUseCase: GetUserUseCase
) : ViewModel(){

    private val _users: MutableStateFlow<UsersResponse?> = MutableStateFlow(null)
    val users: StateFlow<UsersResponse?> = _users

    fun getUsers(){
        viewModelScope.launch {
            try {
                _users.value = getUserUseCase()
            } catch (e: Exception){
                Log.e("UsersViewModels",e.message.toString())
            }
        }
    }

}