package com.rlb.yaounde_taxi_price.di

import com.rlb.yaounde_taxi_price.data.TaxiRepository
import com.rlb.yaounde_taxi_price.data.TaxiRepositoryImpl
import com.rlb.yaounde_taxi_price.domain.usecase.GetPrixTaxiUseCase
import org.koin.dsl.module

val sharedModule = module {
    single<TaxiRepository>{ TaxiRepositoryImpl() }
    factory { GetPrixTaxiUseCase(get()) }
}