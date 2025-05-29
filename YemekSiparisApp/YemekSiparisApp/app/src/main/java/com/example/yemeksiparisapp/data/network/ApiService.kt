package com.example.yemeksiparisapp.data.network

import com.example.yemeksiparisapp.utils.Constants
import com.example.yemeksiparisapp.data.model.YemekCevap
import com.example.yemeksiparisapp.data.model.SepetCevap
import retrofit2.http.*

interface ApiService {

    // 1. Tüm yemekleri getir
    @GET("tumYemekleriGetir.php")
    suspend fun tumYemekleriGetir(): YemekCevap

    // 2. Sepete yemek ekle
    @FormUrlEncoded
    @POST("sepeteYemekEkle.php")
    suspend fun sepeteYemekEkle(
        @Field("yemek_adi") yemekAdi: String,
        @Field("yemek_resim_adi") yemekResimAdi: String,
        @Field("yemek_fiyat") yemekFiyat: String,
        @Field("yemek_siparis_adet") siparisAdet: Int,
        @Field("kullanici_adi") kullaniciAdi: String
    )

    // 3. Sepetteki yemekleri getir
    @FormUrlEncoded
    @POST("sepettekiYemekleriGetir.php")
    suspend fun sepettekiYemekleriGetir(
        @Field("kullanici_adi") kullaniciAdi: String
    ): SepetCevap

    // 4. Sepetten yemek sil
    @FormUrlEncoded
    @POST("sepettenYemekSil.php")
    suspend fun sepettenYemekSil(
        @Field("sepet_yemek_id") sepetYemekId: Int,
        @Field("kullanici_adi") kullaniciAdi: String
    )
}
