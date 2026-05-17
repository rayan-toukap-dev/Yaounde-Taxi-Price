package com.rlb.yaounde_taxi_price.domain.model

data class Quartier(
    val nom: String,
    val zone: Zone,
    val prixMin: Int,
    val prixMax: Int
)

enum class Zone {
    CENTRE,  //Plateau, Centre Admin
    PROCHE,  //Bastos, Nlongkak, Melen
    INTERMEDIAIRE, //Mvan, Biyem-Assi, Nkol-Eton
    LOINTAIN       //Nkolbisson, Soa, Mfou
}
