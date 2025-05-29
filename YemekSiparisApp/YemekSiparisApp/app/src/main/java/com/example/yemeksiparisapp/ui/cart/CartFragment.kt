package com.example.yemeksiparisapp.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yemeksiparisapp.databinding.FragmentCartBinding
import com.example.yemeksiparisapp.ui.components.SepetAdapter
import com.example.yemeksiparisapp.utils.Constants
import com.example.yemeksiparisapp.viewmodel.CartViewModel



class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CartViewModel by viewModels()
    private lateinit var adapter: SepetAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.sepettekileriYukle()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = SepetAdapter(mutableListOf()) { silinecekYemek ->
            viewModel.sepettenSil(silinecekYemek.sepetYemekId.toInt())
            Toast.makeText(requireContext(), "${silinecekYemek.yemekAdi} silindi", Toast.LENGTH_SHORT).show()
        }

        binding.recyclerViewSepet.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewSepet.adapter = adapter

        viewModel.sepetList.observe(viewLifecycleOwner) { sepetYemekler ->
            adapter.updateData(sepetYemekler)
            val toplamFiyat = sepetYemekler.sumOf { it.yemekFiyat * it.yemekSiparisAdet }
            binding.textToplamFiyat.text = "Toplam: ₺$toplamFiyat"
        }

        viewModel.hataMesaji.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
        }

        binding.buttonSiparisVer.setOnClickListener {
            Toast.makeText(requireContext(), "Sipariş verildi 🎉", Toast.LENGTH_SHORT).show()
            viewModel.tumSepetiBosalt()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
