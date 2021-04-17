package com.example.postcard.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.postcard.R
import com.example.postcard.databinding.FragmentMainBinding
import com.example.postcard.databinding.FragmentPostcardBinding

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentMainBinding = FragmentMainBinding
            .inflate(inflater, container, false)
        return binding.root
    }
}