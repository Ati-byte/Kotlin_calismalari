package com.example.spotify

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MusicDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_detail)

        val musicTitle = intent.getStringExtra("title")
        val artistName = intent.getStringExtra("artist")

        findViewById<TextView>(R.id.txtTitle).text = musicTitle
        findViewById<TextView>(R.id.txtArtist).text = artistName
    }
}
