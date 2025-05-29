package com.example.yemeksiparisapp.ui.components

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.yemeksiparisapp.databinding.ItemSepetYemekBinding
import com.example.yemeksiparisapp.data.model.SepetYemek

class SepetAdapter(
    private val sepetList: MutableList<SepetYemek>,
    private val onSilClick: (SepetYemek) -> Unit
) : RecyclerView.Adapter<SepetAdapter.SepetViewHolder>() {

    inner class SepetViewHolder(val binding: ItemSepetYemekBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(sepetYemek: SepetYemek) {
            binding.textSepetYemekAdi.text = sepetYemek.yemekAdi
            binding.textSepetFiyat.text = "₺${sepetYemek.yemekFiyat} x ${sepetYemek.yemekSiparisAdet}"

            val imageUrl = "http://kasimadalan.pe.hu/yemekler/resimler/${sepetYemek.yemekResimAdi}"
            Glide.with(binding.root.context).load(imageUrl).into(binding.imageSepetResim)

            binding.buttonSil.setOnClickListener {
                onSilClick(sepetYemek)
            }
        }
    }

    fun updateData(yeniListe: List<SepetYemek>) {
        sepetList.clear()
        sepetList.addAll(yeniListe)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetViewHolder {
        val binding = ItemSepetYemekBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SepetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SepetViewHolder, position: Int) {
        holder.bind(sepetList[position])
    }

    override fun getItemCount(): Int = sepetList.size
}
