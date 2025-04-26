package com.example.kotlindersleri.nesne_tabanlı_programlama

class Fonksiyonlar {
    //void - sadece işlem yapan
    fun selamla1(){//swift dilinde func olarak yazılır
        val sonuc = "Greetings sir!"
        println(sonuc)
    }

    //return - hem işlem yapan hem veri transferi yapan
    fun selamla2(): String{
        val sonuc = "Selamlar beyim!"
        return sonuc
    }

    //parametre -Dışarıdan değer alıp işlem yaptırma
    fun selamla3(isim: String){
        val sonuc = "Greetings $isim!"
        println(sonuc)
    }

    //Overloading
    //Bir sınıf içerisinde aynı isimde fonksiyonları tekrar kullanmak

    fun topla(sayi1: Int,sayi2: Int){
        println("Toplama : ${sayi1+sayi2}")
    }
    fun topla(sayi1: Double,sayi2: Double){
        println("Toplama : ${sayi1+sayi2}")
    }
    fun topla(sayi1: Int,sayi2: Int,isim: String){
        println("Toplama : ${sayi1+sayi2} işlem yapan : $isim")
    }
}