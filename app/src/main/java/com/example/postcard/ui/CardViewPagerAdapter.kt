package com.example.postcard.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.postcard.R
import com.example.postcard.data.CardsImagesData
import com.example.postcard.databinding.CardItemBinding

class CardViewPagerAdapter(private val list: ArrayList<CardsImagesData>): RecyclerView.Adapter<CardViewHolderAdapter>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolderAdapter =
        CardViewHolderAdapter(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.card_item, parent ,false))

    override fun onBindViewHolder(holder: CardViewHolderAdapter, position: Int) {
        holder.set(list[position])
    }

    override fun getItemCount(): Int = list.size
}

class CardViewHolderAdapter(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val binding = CardItemBinding.bind(itemView)

    @SuppressLint("CheckResult")
    fun set(backgroundData: CardsImagesData){

        Glide
            .with(binding.imageView)
            .asBitmap()
            .load(backgroundData.url)
            .into(binding.imageView)
        binding.titleTextView.text = backgroundData.day
        binding.descriptionTextView.text = backgroundData.type
    }
}
