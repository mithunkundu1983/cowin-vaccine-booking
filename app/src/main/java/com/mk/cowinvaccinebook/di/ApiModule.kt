package com.mk.cowinvaccinebook.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.mk.cowinvaccinebook.data.network.CowinApiService
import com.mk.cowinvaccinebook.repository.CowinAppRepository
import com.mk.cowinvaccinebook.repository.CowinRepositoryImpl
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    @Singleton
    @Provides
    fun provideCowinApiService(retrofit: Retrofit): CowinApiService =
        retrofit.create(CowinApiService::class.java)
}

@Module
@InstallIn(SingletonComponent::class)
abstract class ApiBindingModule {

    @Singleton
    @Binds
    abstract fun bindsCowinAppRepository(cowinRepositoryImpl: CowinRepositoryImpl): CowinAppRepository
}