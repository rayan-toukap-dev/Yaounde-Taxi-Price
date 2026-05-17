package com.rlb.yaounde_taxi_price.android

import androidx.lifecycle.ViewModel
import com.rlb.yaounde_taxi_price.domain.model.Quartier
import com.rlb.yaounde_taxi_price.domain.usecase.GetPrixTaxiUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class TaxiViewModel @Inject constructor(
    private val getPrixTaxiUseCase: GetPrixTaxiUseCase
): ViewModel() {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _quartiers = MutableStateFlow<List<Quartier>>(emptyList())
    val quartiers: StateFlow<List<Quartier>> = _quartiers

    init {
        _quartiers.value = getPrixTaxiUseCase.execute("")
    }
    fun onSearch(query: String){
        _searchQuery.value = query
        _quartiers.value = getPrixTaxiUseCase.execute(query)
    }
}

