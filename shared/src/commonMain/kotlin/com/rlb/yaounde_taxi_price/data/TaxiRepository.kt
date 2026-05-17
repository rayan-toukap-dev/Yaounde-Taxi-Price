package com.rlb.yaounde_taxi_price.data

import com.rlb.yaounde_taxi_price.domain.model.Quartier
import com.rlb.yaounde_taxi_price.domain.model.Zone

interface TaxiRepository {
    fun getAllQuartiers():List<Quartier>
    fun getQuartiersByZone(zone: Zone): List<Quartier>
    fun searchQuartier(query: String): List<Quartier>

}

class TaxiRepositoryImpl : TaxiRepository {

    //Donnees statique pour l'instant -pas besoin de reseau
    private val quartiers = listOf(
        Quartier("Plateau / Centre Admin", Zone.CENTRE, 200, 300),
        Quartier("Nlongkak",Zone.PROCHE,300,400),
        Quartier("Bastos",Zone.PROCHE,300,500),
        Quartier("Melen",Zone.PROCHE,300,400),
        Quartier("Ekounou",Zone.PROCHE,300,400),
        Quartier("Biyem-Assi",Zone.INTERMEDIAIRE,400,500),
        Quartier("Mvan",Zone.INTERMEDIAIRE,400,500),
        Quartier("Nkol-Eton", Zone.INTERMEDIAIRE,400,600),
        Quartier("Essos",Zone.INTERMEDIAIRE,400,500),
        Quartier("Mendong",Zone.INTERMEDIAIRE,500,600),
        Quartier("Nkolbisson", Zone.LOINTAIN, 600,800),
        Quartier("Odza",Zone.LOINTAIN,600,800),
        Quartier("Nkol-Afeme",Zone.LOINTAIN,700,1000),
        Quartier("Soa", Zone.LOINTAIN, 1000,1500),
        Quartier("Mbankomo",Zone.LOINTAIN,1500,2000),
    )

    override fun getAllQuartiers() = quartiers

    override fun getQuartiersByZone(zone: Zone) = quartiers.filter{it.zone == zone}

    override fun searchQuartier(query: String) =
        quartiers.filter{
            it.nom.contains(query, ignoreCase = true )
        }

}
