package com.example.gamesapp.retrofit

import com.example.gamesapp.home.models.Games
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import java.util.*

interface ApiService {
    @GET("/v3/970765dd-3a79-4f52-ac55-8b44397cb4c2")
    fun getAllGames():Observable<Games>
}