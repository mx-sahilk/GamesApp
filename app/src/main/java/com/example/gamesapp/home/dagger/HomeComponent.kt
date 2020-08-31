package com.example.gamesapp.home.dagger

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.gamesapp.home.GameRepository
import com.example.gamesapp.home.HomeActivity
import com.example.gamesapp.home.HomeViewModel
import com.example.gamesapp.retrofit.ApiService
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass


@Subcomponent(modules = [HomeModule::class ])
interface HomeComponent {
    fun inject(homeActivity: HomeActivity)
}

@Module
class HomeModule {
    @Provides
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun getHomeViewModel(application: Application,gameRepository: GameRepository):ViewModel {
        return HomeViewModel(application, gameRepository)
    }

    @Provides
    fun getGameRepo(apiService: ApiService):GameRepository{
        return GameRepository(apiService)
    }
}

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

