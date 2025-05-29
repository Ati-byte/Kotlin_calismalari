package com.example.yemeksiparisapp.ui.components

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yemeksiparisapp.databinding.ItemYemekBinding
import com.example.yemeksiparisapp.data.model.Yemek


class YemekAdapter(
    private val yemekList: List<Yemek>,
    private val onItemClick: (Yemek) -> Unit
) : RecyclerView.Adapter<YemekAdapter.YemekViewHolder>() {

    class YemekViewHolder(val binding: ItemYemekBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(yemek: Yemek, onItemClick: (Yemek) -> Unit) {
            binding.textYemekAdi.text = yemek.yemek_adi
            binding.textYemekFiyat.text = "₺${yemek.yemek_fiyat}"

            val resimUrl = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}"
            Glide.with(binding.root.context)
                .load(resimUrl)
                .into(binding.imageYemek)

            binding.root.setOnClickListener {
                onItemClick(yemek)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YemekViewHolder {
        val binding = ItemYemekBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return YemekViewHolder(binding)
    }

    override fun onBindViewHolder(holder: YemekViewHolder, position: Int) {
        holder.bind(yemekList[position], onItemClick)
    }

    override fun getItemCount(): Int = yemekList.size
}
