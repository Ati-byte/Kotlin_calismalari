package com.example.kotlindersleri.nesne_tabanlı_programlama

fun main() {
    val f = Fonksiyonlar()

    //void = unit
    f.selamla1()

    //return
    val gelenSonuc = f.selamla2()
    println("Gelen Sonuc : $gelenSonuc")

    //parametre kullanım
    f.selamla3("Jane")


    //Overloading kullanımı

    f.topla(10,20,"Attila")


}