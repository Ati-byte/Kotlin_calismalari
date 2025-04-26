package com.example.kotlindersleri.standart_programlama

fun main() {
    //1,2,3
    for (i in 1 ..3){//swift 1..3, i= index(dizilerdeki indeks numara)
        println("Dongu $i")
    }
    println("****------------------****")
    //10 ile 20 arasında 5 er artsın

    for(x in 10..20 step 5){
        println("döngü 2 : $x")
    }
    println("***---------------------***")
    //20 ile 10 arasında 5 er azalsın

    for(i in 20 downTo  10 step 5){
        println("Döngü 3 : $i")

    }
    println("****-------------------****")
    //1,2,3
    var sayac = 1
    while (sayac < 4){
        println("Döngü 4 : $sayac")
        sayac += 1
    }
    println("****-------------------****")
    // 1,2,3,4,5
    for (i in 1..5){
        if (i == 3){
            break // döngüyü durdurur

        }
        println("Döngü 5 : $i")

    }
    println("****-------------------****")
    for (i in 1..5){
        if (i == 3){
            continue // bulunduğu iterasyonu pas geçer
        }
        println("Döngü 6 : $i")

    }

}