package com.example.kotlindersleri.nesne_tabanlı_programlama

data class Yemekler(var id: Int, var ad: String,var fiyat: Int) {//Constructor
    //Constructor - init fonksiyonu(metodu)
    //Bu sınıftan nesne oluştuğunda çalışsın.
    init {
        println("******* Nesne oluştu *******")
    }
    fun bilgiAl(){
        println("*******---------------*********")
        println("Id    : ${id}")
        println("Ad    : ${ad}")
        println("fiyat : ${fiyat}")

    }
    //this : bulunduğu sınıfı temsil eder. Swift dilinde self olarak kullanılır
    //super : Kalıtım ile bir üst sınıfı temsil eder.
}