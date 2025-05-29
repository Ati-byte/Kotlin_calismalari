package com.example.yemeksiparisapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.example.yemeksiparisapp.data.model.Yemek
import com.example.yemeksiparisapp.data.repository.YemekRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = YemekRepository()

    private val _yemekListesi = MutableLiveData<List<Yemek>>()
    val yemekListesi: LiveData<List<Yemek>> = _yemekListesi

    private val _hataMesaji = MutableLiveData<String>()
    val hataMesaji: LiveData<String> = _hataMesaji

    init {
        yemekleriYukle()
    }

    private fun yemekleriYukle() {
        viewModelScope.launch {
            try {
                val cevap = repository.tumYemekleriGetir()
                _yemekListesi.value = cevap.yemekler
            } catch (e: Exception) {
                _hataMesaji.value = "Yemekler yüklenemedi: ${e.localizedMessage}"
            }
        }
    }
}
