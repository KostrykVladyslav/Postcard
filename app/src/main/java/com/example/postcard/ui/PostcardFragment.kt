package com.example.postcard.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.postcard.R
import com.example.postcard.databinding.FragmentPostcardBinding

class PostcardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentPostcardBinding = FragmentPostcardBinding
            .inflate(inflater, container, false)
        return binding.root
    }
}