package com.example.gamesapp.home

import com.example.gamesapp.home.models.Games
import com.example.gamesapp.retrofit.ApiService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject


/**
 *  <p>
 *      Repository for Games data from network.
 *  </p>
 *
 *  @author Sahil Kansal
 * @since 28/Aug/2020
 */
class GameRepository @Inject constructor(private val apiService: ApiService){

    fun fetchAllGames(): Observable<Games> {
        return apiService.getAllGames().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}