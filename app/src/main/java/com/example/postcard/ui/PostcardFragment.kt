package com.example.postcard.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.postcard.data.Icons
import com.example.postcard.databinding.FragmentPostcardBinding

class PostcardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentPostcardBinding = FragmentPostcardBinding
            .inflate(inflater, container, false)
        val list = Icons().getList()

        val preferences = activity?.getPreferences(Context.MODE_PRIVATE)
        binding.name.text = preferences?.getString("name", "")
        binding.title.text = preferences?.getString("title", "")
        binding.description.text = preferences?.getString("description","")

        binding.iconImageView.setImageResource(list[preferences?.getInt("position", 0)!!])
        onSecondFragmentIsStarted(preferences)

        return binding.root
    }

    private fun onSecondFragmentIsStarted(preferences: SharedPreferences){
        val editor = preferences.edit()
        editor.putBoolean("second_fragment_launch", false)
        editor.apply()
    }
}