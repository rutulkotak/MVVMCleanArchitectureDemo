package com.rutulkotak.mvvmcleanarchidemo.presentation.di.core

import com.rutulkotak.mvvmcleanarchidemo.data.api.RemoteDataService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideRemoteDataService(retrofit: Retrofit) : RemoteDataService {
        return retrofit.create(RemoteDataService::class.java)
    }
}