package com.example.kotlindersleri.odevler

//1. Parametre olarak girilen kenar sayısına göre iç açılar toplamını hesaplayıp sonucu geri gönderen metod

fun icAcilarToplami(kenarSayisi: Int): Int{
    if (kenarSayisi < 3){//üçgenden az kenarı olan bir çokgen olamaz
        return 0
    }
    return (kenarSayisi - 2) * 180
}

//2. Parametre olarak girilen gün sayısına göre maaş hesabı yapan ve elde edilen değeri döndüren metod

fun maasHesabi(gunSayisi: Int): Int{
    val calismaSaati = 8
    val mesaiSiniri = 160
    val normalUcret= 10
    val mesaiUcreti = 20

    val toplamCalismaSaati = calismaSaati * gunSayisi
    var maas = toplamCalismaSaati * normalUcret
    if (toplamCalismaSaati > mesaiSiniri){
        val mesaiSaati = toplamCalismaSaati - mesaiSiniri
        maas += mesaiSaati * mesaiUcreti
    }
    return maas
}

//3. parametre olarak girilen kota miktarına göre ücreti hesaplayarak geri döndüren metod
// kota 50 gb = 100 tl, kota aşımında her 1 GB için 4 tl
fun kullanimUcreti(kullanılanGb: Int): Int{
    val paketFiyati = 100
    val kotaAsim = 4
    var ucret = paketFiyati
    if(kullanılanGb >50){
        val ekUcret = (kullanılanGb - 50) * 4
        ucret += ekUcret
        return ucret
    }
    return ucret
}

//4. parametre olarak girilen dereceyi fahrenhiet'a dönüştürdükten sonra geri döndüren metod (F=C*1.8+32)

fun fahrenietCeviri(derece: Double): Double{
    return (derece * 1.8) + 32
}
//5. kenarları parametre olarak girilen ve dikdörgenin çevresini hesaplayan metod

fun cevreHesapla(a: Int,b: Int): Int{//Dikdörtgen, karşılıklı kenarları birbirine eşit dörtgen
    return (a+b) * 2 // kısa ve uzun kenarı alıp 2 ile çarparsak sonuç çıkar
}

//6. parametre olarak girilen sayının faktoriyel değerini hesaplayan metod

fun faktoriyel(sayi: Int): Any{
    var temp = 1
    if(sayi == 0){// 0 faktoriyel 1 olma kuralı
        return 1
    }
    else if(sayi< 0){ // faktoriyel negatif olamama kuralı
        //val msg = println("Sayı Negatif değer almamalı")      //(String döndürebilmesi için Any yazdım ama işe yaramadı)
        return 0                                                // string döndürmeyi başaramadığım için 0 döndürmeyi tercih ettim
    }
    for (i in 1..sayi) {// faktoriyel hesaplama
        temp *= i

    }
    return temp
}

//7. parametre olarak girilen kelime içinde kaç adet a harfi olduğunu gösteren metod

fun sayici(kelime: String): Int{
    var sayac = 0
    // her harfi döngüyle kontrol ettik
    for(char in kelime){
        if(char.toLowerCase() == 'a'){//harfin a veya A olup olmadığına baktık. a bulduğumuzda sayacı arttırdık
            sayac++
        }
    }
    return sayac
}

fun main() {
    //1. metod test
    val kenar = 6
    val toplamAci = icAcilarToplami(kenar)
    println("$kenar kenarlı bir çokgen'in iç açıları toplamı : $toplamAci")

    //2. metod test
    var gun = 20
    var toplamMaas = maasHesabi(gun)
    println("$gun Günlük maaş : $toplamMaas")
    gun = 25
    toplamMaas = maasHesabi(gun)
    println("$gun Günlük ek mesaili maaş : $toplamMaas")

    //3. metod test
    var kullanim = 50
    var toplamUcret = kullanimUcreti(kullanim)
    println("$kullanim Gb için fatura tutarı : $toplamUcret")
    kullanim = 60
    toplamUcret = kullanimUcreti(kullanim)
    println("$kullanim Gb için fatura tutarı : $toplamUcret")

    //4. metod test
    var derece = 24.7
    var sonuc = fahrenietCeviri(derece)
    println("$derece santigrat derece : ${"%.2f".format(sonuc)} fahreniet'dır")
    derece = 37.toDouble()
    sonuc = fahrenietCeviri(derece)
    println("$derece santigrat derece : ${"%.2f".format(sonuc)} fahreniet'dır")

    //5. metod test
    var dikdortgenCevre = cevreHesapla(5,6)
    println("Dikdörtgenin çevresi : $dikdortgenCevre")

    //6. metod test
    var girilenSayi = -2
    var faktoriyelHesaplama = faktoriyel(girilenSayi)
    println("$girilenSayi faktoriyel : $faktoriyelHesaplama")

    //7. metod test

    val kelime1 = "Merhaba Dünya"
    val kelime2 = "Android Geliştirme Bootcamp"

    println("'$kelime1' kelimesindeki 'a' sayısı : ${sayici(kelime1)}")
    println("'$kelime2' kelimesindeki 'a' sayısı : ${sayici(kelime2)}")


}