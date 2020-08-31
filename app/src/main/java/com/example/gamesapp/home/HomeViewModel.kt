package com.example.gamesapp.home

import android.app.Application
import android.util.Log
import com.example.gamesapp.home.models.Games
import com.example.gamesapp.util.BaseViewModel
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject


/**
 * <p>
 *     VM for Home page screen
 *     It required repo instance and application context
 * </p>
 *
 * @author Sahil Kansal
 * @since 28/Aug/2020
 */
class HomeViewModel @Inject constructor(application: Application, val mGameRepo: GameRepository) : BaseViewModel(application) {
    private val TAG = "HomeViewModel"

    fun init() {
        mGameRepo.fetchAllGames().subscribe(object:Observer<Games>{
            override fun onComplete() {
                Log.d(TAG,"OnComplete fetching games")
            }

            override fun onSubscribe(d: Disposable?) {

            }

            override fun onNext(t: Games?) {
                Log.d(TAG,"Ongetting fetching games: "+t)

            }

            override fun onError(e: Throwable?) {
                //error handling
            }

        })
    }

    override fun onCleared() {
        super.onCleared()
    }


}
