package com.example.yemeksiparisapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.yemeksiparisapp.databinding.FragmentDetailBinding
import com.example.yemeksiparisapp.viewmodel.DetailViewModel

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val _eklendiMesaji = MutableLiveData<String>()
    val eklendiMesaji: LiveData<String> = _eklendiMesaji


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val yemek = args.secilenYemek

        binding.textYemekAdi.text = yemek.yemek_adi
        binding.textYemekFiyat.text = "₺${yemek.yemek_fiyat}"

        val resimUrl = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}"
        Glide.with(requireContext()).load(resimUrl).into(binding.imageYemek)

        binding.buttonSepeteEkle.setOnClickListener {
            val adetStr = binding.editTextAdet.text.toString()
            val adet = adetStr.toIntOrNull()

            if (adet != null && adet > 0) {
                viewModel.sepeteEkle(yemek, adet)
                Toast.makeText(requireContext(), "${adet} adet eklendi", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Geçerli bir adet girin", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.eklendiMesaji.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
