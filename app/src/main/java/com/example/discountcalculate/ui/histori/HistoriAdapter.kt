package com.example.discountcalculate.ui.histori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.discountcalculate.R
import com.example.discountcalculate.databinding.ItemHistoriBinding
import com.example.discountcalculate.db.DiskonEntity
import com.example.discountcalculate.model.hitungDiskon
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HistoriAdapter :
    ListAdapter<DiskonEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<DiskonEntity>() {
                override fun areItemsTheSame(
                    oldData: DiskonEntity, newData: DiskonEntity
                ): Boolean {
                    return oldData.id == newData.id
                }

                override fun areContentsTheSame(
                    oldData: DiskonEntity, newData: DiskonEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat(
            "dd MMMM yyyy",
            Locale("id", "ID")
        )

        fun bind(item: DiskonEntity) = with(binding) {
            val hasilDiskon = item.hitungDiskon()
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            diskonTextView.text = root.context.getString(R.string.hasil_x,item.harga, item.diskon )
            dataTextView.text = root.context.getString(R.string.data_x, hasilDiskon.hitungDiskon1, hasilDiskon.totalDiskon)
        }
    }
}