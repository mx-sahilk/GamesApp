package com.example.gamesapp.home

import android.app.Application
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.gamesapp.GamesApplication
import com.example.gamesapp.R
import com.example.gamesapp.dagger.ApplicationComponent
import com.example.gamesapp.databinding.ActivityMainBinding
import com.example.gamesapp.home.dagger.HomeModule
import com.example.gamesapp.util.BaseActivity


/**
 * <p>
 *     Launcher screen of App
 *     Show all games in grid View
 * </p>
 *
 * @author Sahil Kansal
 * @since 28/Aug/2020
 */
class HomeActivity : BaseActivity() {

    lateinit var viewModel:HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:ActivityMainBinding  = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel = ViewModelProvider(this,viewModelFactory).get(HomeViewModel::class.java)
        viewModel.init()
    }

    override fun initDagger() {
        (this as? GamesApplication)?.appComponent?.getHomeSubComponent(HomeModule())?.inject(this)
    }
}