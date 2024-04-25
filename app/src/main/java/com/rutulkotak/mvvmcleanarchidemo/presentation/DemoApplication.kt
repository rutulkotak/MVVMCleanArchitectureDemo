package com.rutulkotak.mvvmcleanarchidemo.presentation

import android.app.Application
import com.rutulkotak.mvvmcleanarchidemo.presentation.di.Injector
import com.rutulkotak.mvvmcleanarchidemo.presentation.di.core.AppComponent
import com.rutulkotak.mvvmcleanarchidemo.presentation.di.core.AppModule
import com.rutulkotak.mvvmcleanarchidemo.presentation.di.core.DaggerAppComponent
import com.rutulkotak.mvvmcleanarchidemo.presentation.di.core.NetModule
import com.rutulkotak.mvvmcleanarchidemo.presentation.di.core.RemoteDataModule
import com.rutulkotak.mvvmcleanarchidemo.presentation.di.movie.MovieSubComponent

class DemoApplication: Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule("https://api.github.com"))
            .remoteDataModule(RemoteDataModule())
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }
}