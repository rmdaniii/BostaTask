import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.data.entity.Albums
import com.example.data.entity.Photos
import com.example.data.entity.User
import com.example.domain.usecase.GetAlbumsUseCase
import com.example.domain.usecase.GetPhotosUseCase
import com.example.domain.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel

private var userId: Int = 1
private var albumId:Int  = 1

@HiltViewModel
class AlbumsViewModel(private val getAlbumsUseCase: GetAlbumsUseCase) : ViewModel() {
    val albums: LiveData<List<Albums>> = liveData {
        val result = getAlbumsUseCase.execute(userId)
        emit(result)
    }
}

@HiltViewModel
class UserProfileViewModel(private val getUserUseCase: GetUserUseCase) : ViewModel() {
    val user: LiveData<User> = liveData {
        val result = getUserUseCase.execute(userId)
        emit(result)
    }
}
@HiltViewModel
class AlbumDetailsViewModel(private val getPhotosUseCase: GetPhotosUseCase) : ViewModel() {
    val photos: LiveData<List<Photos>> = liveData {
        val result = getPhotosUseCase.execute(albumId)
        emit(result)
    }
}