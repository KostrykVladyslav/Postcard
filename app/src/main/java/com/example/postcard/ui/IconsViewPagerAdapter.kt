package com.example.postcard.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.postcard.R
import com.example.postcard.databinding.IconFramentBinding

class IconsViewPagerAdapter(private val list: ArrayList<Int>) : RecyclerView.Adapter<ViewPagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder =
        ViewPagerViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.icon_frament, parent, false))

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.binding.pagerImageView.setImageResource(list[position])
    }

    override fun getItemCount(): Int = list.size
}

class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding = IconFramentBinding.bind(itemView)
}