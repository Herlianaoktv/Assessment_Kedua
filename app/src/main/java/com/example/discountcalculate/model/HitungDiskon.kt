package com.example.discountcalculate.model

import com.example.discountcalculate.db.DiskonEntity

fun DiskonEntity.hitungDiskon():HasilDiskon{
    val hitungDiskon1 = harga * (diskon/100)
    val totalDiskon = harga - hitungDiskon1
    return HasilDiskon(hitungDiskon1, totalDiskon)
}