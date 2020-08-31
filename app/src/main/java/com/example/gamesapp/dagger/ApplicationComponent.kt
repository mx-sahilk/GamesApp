package com.example.gamesapp.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gamesapp.home.dagger.HomeComponent
import com.example.gamesapp.home.dagger.HomeModule
import com.example.gamesapp.retrofit.ApiService
import com.example.gamesapp.util.BASE_URL
import com.example.gamesapp.util.ViewModelFactory
import com.google.gson.Gson
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Provider
import javax.inject.Singleton

/**
 *
 * Definition of the Application graph
 *
 *
 * @author Sahil Kansal
 * * @since 28/Aug/2020
 */
@Component(modules = [ApplicationModule::class])
@Singleton
interface ApplicationComponent {
    fun getHomeSubComponent(homeModule: HomeModule): HomeComponent
}


@Module
class ApplicationModule{

    @Provides
    fun getViewModelFactory(map:Map<Class<out ViewModel>, Provider<ViewModel>>):ViewModelProvider.Factory{
        return ViewModelFactory(map)
    }

    @Provides
    fun provideGSONConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }


    @Provides
    fun initRetrofit(gsonConverterFactory: GsonConverterFactory):Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .baseUrl(BASE_URL).build()
    }

    @Provides
    fun getApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}