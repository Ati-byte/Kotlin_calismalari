package com.example.yemeksiparisapp.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yemeksiparisapp.databinding.FragmentHomeBinding
import com.example.yemeksiparisapp.ui.components.YemekAdapter
import com.example.yemeksiparisapp.R



class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("Test", "HomeFragment açıldı")

        binding.recyclerViewYemekler.layoutManager = LinearLayoutManager(requireContext())

        viewModel.yemekListesi.observe(viewLifecycleOwner, Observer { yemekler ->
            val adapter = YemekAdapter(yemekler) { secilenYemek ->
                val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(secilenYemek)
                findNavController().navigate(action)
            }
            binding.recyclerViewYemekler.adapter = adapter
        })
        binding.fabSepet.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_cartFragment)
        }


        viewModel.hataMesaji.observe(viewLifecycleOwner, Observer { hata ->
            Toast.makeText(requireContext(), hata, Toast.LENGTH_LONG).show()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
