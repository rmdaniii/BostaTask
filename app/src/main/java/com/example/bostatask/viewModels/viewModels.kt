import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.Albums
import com.example.domain.entity.Photos
import com.example.domain.entity.User
import com.example.domain.entity.UserResponse
import com.example.domain.entity.albumsResponse
import com.example.domain.entity.photosResponse
import com.example.domain.usecase.GetAlbumsUseCase
import com.example.domain.usecase.GetPhotosUseCase
import com.example.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

private var userId: Int = 1
private var albumId:Int  = 1

@HiltViewModel
class AlbumsViewModel @Inject constructor(

    private val getAlbumsUseCase: GetAlbumsUseCase)
    : ViewModel() {

    private val _albums: MutableStateFlow<albumsResponse?> = MutableStateFlow(null)
    val albums: StateFlow<albumsResponse?> = _albums

    fun getAlbums(){
        viewModelScope.launch {
            try {
                _albums.value = getAlbumsUseCase()
            }catch (e: Exception){
                Log.e("AlbumsViewModels", e.message.toString())
            }
        }
    }
}

@HiltViewModel
class UsersViewModel @Inject constructor(

    private val getUserUseCase: GetUserUseCase)
    : ViewModel() {

    private val _users: MutableStateFlow<UserResponse?> = MutableStateFlow(null)
    val users: StateFlow<UserResponse?> = _users

    fun getUsers(){
        viewModelScope.launch {
            try {
                _users.value = getUserUseCase()
            }catch (e: Exception){
                Log.e("AlbumsViewModels", e.message.toString())
            }
        }
    }
}

@HiltViewModel
class PhotosViewModel @Inject constructor(

    private val getPhotosUseCase: GetPhotosUseCase)
    : ViewModel() {

    private val _photos: MutableStateFlow<photosResponse?> = MutableStateFlow(null)
    val photos: StateFlow<photosResponse?> = _photos

    fun getUsers(){
        viewModelScope.launch {
            try {
                _photos.value = getPhotosUseCase()
            }catch (e: Exception){
                Log.e("AlbumsViewModels", e.message.toString())
            }
        }
    }
}