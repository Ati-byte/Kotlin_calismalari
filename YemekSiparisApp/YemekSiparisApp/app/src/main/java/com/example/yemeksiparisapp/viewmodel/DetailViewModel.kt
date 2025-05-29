package com.example.yemeksiparisapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.example.yemeksiparisapp.data.model.Yemek
import com.example.yemeksiparisapp.data.repository.YemekRepository
import com.example.yemeksiparisapp.utils.Constants
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val repository = YemekRepository()

    private val _eklendiMesaji = MutableLiveData<String>()
    val eklendiMesaji: LiveData<String> = _eklendiMesaji

    fun sepeteEkle(yemek: Yemek, adet: Int) {
        viewModelScope.launch {
            try {
                repository.sepeteYemekEkle(
                    yemek.yemek_adi,
                    yemek.yemek_resim_adi,
                    yemek.yemek_fiyat,
                    adet,
                    Constants.KULLANICI_ADI
                )
                _eklendiMesaji.value = "${yemek.yemek_adi} sepete eklendi!"
            } catch (e: Exception) {
                _eklendiMesaji.value = "Sepete eklenemedi: ${e.localizedMessage}"
            }
        }
    }
}
