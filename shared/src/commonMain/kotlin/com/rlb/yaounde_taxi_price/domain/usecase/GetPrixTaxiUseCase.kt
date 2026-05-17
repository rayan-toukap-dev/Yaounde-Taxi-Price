package com.rlb.yaounde_taxi_price.domain.usecase

import com.rlb.yaounde_taxi_price.data.TaxiRepository
import com.rlb.yaounde_taxi_price.domain.model.Quartier

class GetPrixTaxiUseCase(private val repository: TaxiRepository) {
    fun execute(query: String): List<Quartier> {
        return if (query.isBlank()) {
            repository.getAllQuartiers()
        } else {
            repository.searchQuartier(query)
        }
    }
}