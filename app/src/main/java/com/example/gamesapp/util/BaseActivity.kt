package com.example.gamesapp.util

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

/**
 * <p>
 *     All activity should extend this class
 * </p>
 *
 *
 *  @author Sahil Kansal
 * @since 28/Aug/2020
 */
abstract class BaseActivity :AppCompatActivity(){
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        initDagger()
        super.onCreate(savedInstanceState, persistentState)
    }

    abstract fun initDagger()
}