package com.example.discountcalculate.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diskon1")
data class DiskonEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var harga: Float,
    var diskon: Float )