package com.example.gamesapp.util

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.gamesapp.home.GameRepository
import javax.inject.Inject

/**
 * <p>
 *     All viewmodels should extend with base viewmodel
 * </p>
 *
 * @author Sahil Kansal
 * @since 28/Aug/2020
 */
abstract class BaseViewModel constructor(
    val mAppContext:Application):AndroidViewModel(mAppContext)