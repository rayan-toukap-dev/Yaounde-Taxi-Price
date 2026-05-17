package com.rlb.yaounde_taxi_price.android.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rlb.yaounde_taxi_price.android.TaxiViewModel
import com.rlb.yaounde_taxi_price.domain.model.Quartier

@Composable
fun TaxiScreen(viewModel: TaxiViewModel = hiltViewModel()) {
    val quartiers by viewModel.quartiers.collectAsState()
    val query by viewModel.searchQuery.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)){
        Text(
            text = "\uD83D\uDE96 Prix Taxi Yaoundé",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = query,
            onValueChange = viewModel::onSearch,
            label = {Text("Chercher un quartier...")},
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(quartiers){QuartierCard(it) }
        }
    }

}

@Composable
fun QuartierCard(quartier: Quartier){
    Card(modifier = Modifier.fillMaxWidth()){
        Column(modifier = Modifier.padding(12.dp)){
            Text(quartier.nom, style = MaterialTheme.typography.titleMedium)
            Text(
                "Zone : ${quartier.zone.name.lowercase().replaceFirstChar {it.uppercase() }}",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                "${quartier.prixMin} - ${quartier.prixMax} XAF",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }

}
