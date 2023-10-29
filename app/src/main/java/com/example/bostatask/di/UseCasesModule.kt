import com.example.domain.repo.ProfileRepo
import com.example.domain.usecase.GetAlbumsUseCase
import com.example.domain.usecase.GetPhotosUseCase
import com.example.domain.usecase.GetUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    fun provideUserUseCase(profileRepo: ProfileRepo): GetUserUseCase {
        return GetUserUseCase(profileRepo)
    }

    @Provides
    fun provideAlbumsUseCase(profileRepo: ProfileRepo): GetAlbumsUseCase {
        return GetAlbumsUseCase(profileRepo)
    }

    @Provides
    fun providePhotosUseCase(profileRepo: ProfileRepo): GetPhotosUseCase {
        return GetPhotosUseCase(profileRepo)
    }

}