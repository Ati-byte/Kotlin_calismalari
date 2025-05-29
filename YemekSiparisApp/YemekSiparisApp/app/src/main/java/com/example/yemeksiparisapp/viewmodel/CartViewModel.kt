package com.example.yemeksiparisapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yemeksiparisapp.data.model.SepetYemek
import com.example.yemeksiparisapp.data.repository.YemekRepository
import com.example.yemeksiparisapp.utils.Constants
import kotlinx.coroutines.launch

class CartViewModel : ViewModel() {

    private val _toplamFiyat = MutableLiveData<Int>()
    val toplamFiyat: LiveData<Int> get() = _toplamFiyat

    private fun toplamFiyatHesapla(sepetListesi: List<SepetYemek>) {
        val toplam = sepetListesi.sumOf { it.yemekFiyat * it.yemekSiparisAdet }
        _toplamFiyat.value = toplam
    }


    private val repository = YemekRepository()

    private val _sepetList = MutableLiveData<List<SepetYemek>>()
    val sepetList: LiveData<List<SepetYemek>> = _sepetList

    private fun setSepetList(list: List<SepetYemek>) {
        _sepetList.value = list
        toplamFiyatHesapla(list)
    }


    private val _hataMesaji = MutableLiveData<String>()
    val hataMesaji: LiveData<String> = _hataMesaji

    fun sepettekileriYukle() {
        viewModelScope.launch {
            try {
                val cevap = repository.sepettekiYemekleriGetir(Constants.KULLANICI_ADI)
                Log.d("Sepet", "Gelen cevap: $cevap")
                _sepetList.value = cevap.sepetYemekler
                setSepetList(cevap.sepetYemekler)

            } catch (e: Exception) {
                _hataMesaji.value = "Sepet yüklenemedi: ${e.localizedMessage}"
            }
        }
    }

    fun tumSepetiBosalt() {
        val liste = _sepetList.value ?: return

        viewModelScope.launch {
            try {
                for (yemek in liste) {
                    repository.sepettenYemekSil(yemek.sepetYemekId.toInt(), Constants.KULLANICI_ADI)
                }
                _sepetList.value = emptyList()
                _toplamFiyat.value = 0
            } catch (e: Exception) {
                _hataMesaji.value = "Sepet boşaltılamadı: ${e.localizedMessage}"
            }
        }
    }



    fun sepettenSil(sepetYemekId: Int) {
        viewModelScope.launch {
            try {
                repository.sepettenYemekSil(sepetYemekId, Constants.KULLANICI_ADI)
                sepettekileriYukle()
            } catch (e: Exception) {
                _hataMesaji.value = "Silinemedi: ${e.localizedMessage}"
            }
        }
    }


}
