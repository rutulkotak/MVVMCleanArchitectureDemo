package com.rutulkotak.mvvmcleanarchidemo.presentation.di.movie

import com.rutulkotak.mvvmcleanarchidemo.presentation.MainActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(
    modules = [MovieModule::class]
)
interface MovieSubComponent {
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create() : MovieSubComponent
    }
}