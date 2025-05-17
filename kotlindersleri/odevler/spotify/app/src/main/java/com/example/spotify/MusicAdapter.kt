package com.example.spotify

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MusicAdapter(
    private val context: Context,
    private val musicList: List<Music>

) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    inner class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.textViewTitle)
        val artist = itemView.findViewById<TextView>(R.id.textViewArtist)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                val music = musicList[position]

                val intent = Intent(context, MusicDetailActivity::class.java).apply {
                    putExtra("title", music.title)
                    putExtra("artist", music.artist)
                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_music, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val music = musicList[position]
        holder.title.text = music.title
        holder.artist.text = music.artist
    }

    override fun getItemCount() = musicList.size
}
