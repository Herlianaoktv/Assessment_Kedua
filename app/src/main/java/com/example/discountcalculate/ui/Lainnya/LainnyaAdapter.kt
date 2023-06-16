package com.example.discountcalculate.ui.Lainnya

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.discountcalculate.R
import com.example.discountcalculate.databinding.ListItemBinding
import com.example.discountcalculate.model.Diskon
import com.example.discountcalculate.network.DiskonApi


class LainnyaAdapter : RecyclerView.Adapter<LainnyaAdapter.ViewHolder>() {

    private val data = mutableListOf<Diskon>()
    fun updateData(newData: List<Diskon>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(diskon: Diskon) = with(binding) {
            namaTextView.text = diskon.nama
            informasiTextView.text = diskon.informasi
            Glide.with(imageView.context)
                .load(DiskonApi.getDiskonUrl(diskon.imageId))
                .error(R.drawable.ic_baseline_broken_image_24)
                .into(imageView)

            root.setOnClickListener {
                val message = root.context.getString(R.string.message, diskon.nama)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
    override fun getItemCount(): Int {
        return data.size
    }
}