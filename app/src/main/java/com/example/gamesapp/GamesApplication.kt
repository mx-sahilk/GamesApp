package com.example.gamesapp

import android.app.Application
import com.example.gamesapp.dagger.ApplicationComponent
import com.example.gamesapp.dagger.ApplicationModule
import com.example.gamesapp.dagger.DaggerApplicationComponent

class GamesApplication :Application(){
    lateinit var appComponent: ApplicationComponent
    private set

    override fun onCreate() {
        appComponent= DaggerApplicationComponent.builder().appModule(ApplicationModule()).build()
        super.onCreate()
    }

}