package com.example.discountcalculate.ui.hitung

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.discountcalculate.db.DiskonDao

class HitungViewModelFactory (
    private val db: DiskonDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HitungViewModelFactory::class.java)) {
            return HitungViewModelFactory(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}