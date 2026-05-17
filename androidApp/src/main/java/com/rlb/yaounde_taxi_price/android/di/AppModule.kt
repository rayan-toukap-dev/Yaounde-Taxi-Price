package com.rlb.yaounde_taxi_price.android.di

import com.rlb.yaounde_taxi_price.domain.usecase.GetPrixTaxiUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.koin.java.KoinJavaComponent.inject

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideGetPrixTaxiUseCase(): GetPrixTaxiUseCase{
        val useCase: GetPrixTaxiUseCase by inject(GetPrixTaxiUseCase::class.java)
        return useCase
    }

}