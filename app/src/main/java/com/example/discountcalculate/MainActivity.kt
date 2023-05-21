package com.example.discountcalculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.discountcalculate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener { hitungDiskon()}
        binding.button2.setOnClickListener { reset()}
        binding.button3.setOnClickListener { keluar()}
    }
    private fun hitungDiskon(){
        val harga = binding.editHarga.text.toString()
        if (TextUtils.isEmpty(harga)) {
            Toast.makeText(this, R.string.harga_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val diskon = binding.editDiskon.text.toString()
        if (TextUtils.isEmpty(diskon)) {
            Toast.makeText(this, R.string.diskon_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val hitungDiskon = harga.toFloat() * (diskon.toFloat() /100)
        val hasilDiskon = harga.toFloat() - hitungDiskon

        binding.editHasil.setText("Rp."+ hitungDiskon.toInt())
        binding.editTotal.setText("Rp."+ hasilDiskon.toInt())
    }
    private fun reset(){

        binding.editHarga.setText("")
        binding.editDiskon.setText("")
        binding.editHasil.setText("")
        binding.editTotal.setText("")

    }
    private fun keluar(){
        moveTaskToBack(true)
        android.os.Process.killProcess(android.os.Process.myPid())
        System.exit(1);
    }
}