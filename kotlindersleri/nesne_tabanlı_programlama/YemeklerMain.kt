package com.example.kotlindersleri.nesne_tabanlı_programlama

fun main() {
    //Nesne oluşturma
//    val y1 = Yemekler(100,"kofte",249)
//    //değer okuma
//    println("Id    : ${y1.id}")
//    println("Ad    : ${y1.ad}")
//    println("fiyat : ${y1.fiyat}")
//
//    println("*******---------------*********")
//    //değer atama/değiştirmek
//    y1.fiyat = 350
//    println("Id    : ${y1.id}")
//    println("Ad    : ${y1.ad}")
//    println("fiyat : ${y1.fiyat}")
//
//    println("*******---------------*********")
//
//    val y2 = Yemekler(200,"Baklava",300)
//    //değer okuma
//    println("Id    : ${y2.id}")
//    println("Ad    : ${y2.ad}")
//    println("fiyat : ${y2.fiyat}")
//
//    println("*******---------------*********")
//
//    y2.ad = "Soğuk Baklava"
//    println("Id    : ${y2.id}")
//    println("Ad    : ${y2.ad}")
//    println("fiyat : ${y2.fiyat}")

    //yeni yöntemle
    val y1 = Yemekler(100,"kofte",249)
    y1.bilgiAl()
    val y2 = Yemekler(111,"baklava",450)
    y2.bilgiAl()




}