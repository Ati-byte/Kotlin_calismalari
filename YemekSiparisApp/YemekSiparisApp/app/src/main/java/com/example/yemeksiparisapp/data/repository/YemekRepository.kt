package com.example.yemeksiparisapp.data.repository

import com.example.yemeksiparisapp.data.model.SepetCevap
import com.example.yemeksiparisapp.data.model.YemekCevap
import com.example.yemeksiparisapp.data.network.RetrofitClient
import com.example.yemeksiparisapp.utils.Constants

class YemekRepository {

    private val api = RetrofitClient.apiService
    private val kullaniciAdi = Constants.KULLANICI_ADI

    suspend fun tumYemekleriGetir(): YemekCevap {
        return api.tumYemekleriGetir()
    }

    suspend fun sepeteYemekEkle(
        yemekAdi: String,
        yemekResimAdi: String,
        yemekFiyat: String,
        adet: Int
    ) {
        api.sepeteYemekEkle(
            yemekAdi,
            yemekResimAdi,
            yemekFiyat,
            adet,
            kullaniciAdi
        )
    }
    suspend fun sepeteYemekEkle(
        yemekAdi: String,
        yemekResimAdi: String,
        yemekFiyat: String,
        siparisAdet: Int,
        kullaniciAdi: String
    ) {
        RetrofitClient.apiService.sepeteYemekEkle(
            yemekAdi,
            yemekResimAdi,
            yemekFiyat,
            siparisAdet,
            kullaniciAdi
        )
    }


    suspend fun sepettekiYemekleriGetir(kullaniciAdi: String): SepetCevap {
        return api.sepettekiYemekleriGetir(Constants.KULLANICI_ADI)
    }

    suspend fun sepettenYemekSil(sepetYemekId: Int, kullaniciAdi: String) {
        api.sepettenYemekSil(sepetYemekId, Constants.KULLANICI_ADI)
    }
}
