package com.rutulkotak.mvvmcleanarchidemo.presentation.di.movie

import com.rutulkotak.mvvmcleanarchidemo.presentation.MainActivity
import com.rutulkotak.mvvmcleanarchidemo.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(
    modules = [MovieModule::class]
)
interface MovieSubComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create() : MovieSubComponent
    }
}