package com.rlb.yaounde_taxi_price

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform