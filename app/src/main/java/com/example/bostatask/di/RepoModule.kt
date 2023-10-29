
import com.example.data.dataSource.ApiService
import com.example.data.repository.ProfilesRepoImpl
import com.example.domain.repo.ProfileRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    fun provideRepo(apiService: ApiService): ProfileRepo {
        return ProfilesRepoImpl(apiService)
    }

}