package com.example.spotify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var musicAdapter: MusicAdapter
    private lateinit var musicList: List<Music>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewMusic)
        recyclerView.layoutManager = LinearLayoutManager(this)


        musicList = listOf(
            Music("Gitsen de", "Aytekin Ataş", R.drawable.music1),
            Music("Yolcu", "Neşet Ertaş", R.drawable.music2),
            Music("Mavi Liman", "Cem Karaca", R.drawable.music3),
            Music("Islak Islak", "Barış Akarsu", R.drawable.music4),
            Music("Olsun", "Pilli Bebek", R.drawable.music5)
        )

        musicAdapter = MusicAdapter(this,musicList)
        recyclerView.adapter = musicAdapter
    }
}
