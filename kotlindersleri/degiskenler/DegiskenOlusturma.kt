package com.example.kotlindersleri.degiskenler

fun main() {
    // Değişkenler - Variables
    println("Merhaba Dünya!")
    var id = 1
    var ad = "Mont"
    var resim = "mont.png"
    var puan = 4.7
    var fiyat = 4500
    var stokDurum= true

    println("Id : $id")
    println("ad : $ad")
    println("Resim : $resim")
    println("Puan : $puan")
    println("fiyat : $fiyat")
    println("Stok Durum : $stokDurum")

    //Sabitler - Constant
    var sayi = 30
    sayi = 100
    println(sayi)

    val numara = 50
    println(numara)

    // neden val kullanırız, hafızadaki boyutunu düşünün var daha fazla güç harcar. val ne olacağı belli
    // daha az güç harcar

    // Tür Dönüşümü - Type casting

    //1 - sayısaldan sayısala dönüşüm

    val d = 89.56
    val i = 34
    val sonuc1 = d.toInt()
    val sonuc2 = i.toDouble()
    println(sonuc1)
    println(sonuc2)

    //2 - Sayısaldan metine dönüşüm
    var x = 85
    val sonuc3 = x.toString()
    println(sonuc3) //"85"

    //3 - Metinden sayısala dönüşüm

    val yazi = "48"
    val sonuc4 = yazi.toIntOrNull()
    if (sonuc4 != null){
        println(sonuc4)
    }
    else{
        println("Sayı girin")
    }











}