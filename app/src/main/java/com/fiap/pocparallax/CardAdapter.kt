package com.fiap.pocparallax

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CardAdapter(private val items: List<String>) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.card_image)
        private val textView: TextView = itemView.findViewById(R.id.card_text)

        fun bind(text: String) {
            textView.text = text
            // Configure the image if needed
        }
    }
}