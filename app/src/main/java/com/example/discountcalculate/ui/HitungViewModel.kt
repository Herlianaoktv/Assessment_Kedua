package com.example.discountcalculate.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.discountcalculate.db.DiskonDao
import com.example.discountcalculate.db.DiskonEntity
import com.example.discountcalculate.model.HasilDiskon
import com.example.discountcalculate.model.hitungDiskon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HitungViewModel (private val db: DiskonDao) : ViewModel() {
    private val hasilDiskon = MutableLiveData<HasilDiskon?>()

    fun hitungDiskon(harga:Float, diskon: Float) {
        val dataDiskon = DiskonEntity(
            harga = harga,
            diskon = diskon
        )
        hasilDiskon.value = dataDiskon.hitungDiskon()

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataDiskon)
            }
        }
    }
    fun getHasilDiskon(): LiveData<HasilDiskon?> = hasilDiskon
}