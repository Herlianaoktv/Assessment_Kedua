package com.example.discountcalculate

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.discountcalculate.model.HasilDiskon

class MainViewModel : ViewModel() {
    private val hasilDiskon = MutableLiveData<HasilDiskon?>()

    fun hitungDiskon(harga:Float, diskon: Float) {
        val hitungDiskon = harga.toFloat() * (diskon.toFloat() /100)
        val totalDiskon = harga.toFloat() - hitungDiskon
        hasilDiskon.value = HasilDiskon(hitungDiskon, totalDiskon)
    }
    fun getHasilDiskon(): LiveData<HasilDiskon?> = hasilDiskon
}