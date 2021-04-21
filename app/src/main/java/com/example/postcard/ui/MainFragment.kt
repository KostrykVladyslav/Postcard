package com.example.postcard.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.postcard.MainActivity
import com.example.postcard.R
import com.example.postcard.data.Cards
import com.example.postcard.data.Icons
import com.example.postcard.databinding.FragmentMainBinding

@Suppress("SameParameterValue")
class MainFragment : Fragment() {

    private lateinit var viewModel: PostcardViewModel

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentMainBinding = FragmentMainBinding
            .inflate(inflater, container, false)
        binding.imageView.setImageResource(R.drawable.background_snow)
        viewModel = ViewModelProvider(this).get(PostcardViewModel::class.java)

        if (isEditTextNull(binding.editName) &&
            isEditTextNull(binding.editTitle) &&
            isEditTextNull(binding.editDescription)
        ) {
            binding.editTitle.setText(viewModel.getTitle())
            binding.editName.setText(viewModel.getName())
            binding.editDescription.setText(viewModel.getDescription())
        }

        if (isSecondFragmentLaunch()) {
            findNavController().navigate(R.id.action_mainFragment_to_postcardFragment)
        }

        binding.testButton.setOnClickListener {
            if (!isEditTextNull(binding.editName) &&
                !isEditTextNull(binding.editTitle) &&
                !isEditTextNull(binding.editDescription)
            ) {
                savePreferences(
                    binding.editName.text.toString(),
                    binding.editTitle.text.toString(),
                    binding.editDescription.text.toString()
                )

                viewModel.setValues(
                    binding.editName.text.toString(),
                    binding.editTitle.text.toString(),
                    binding.editDescription.text.toString()
                )
                findNavController().navigate(R.id.action_mainFragment_to_postcardFragment)
            } else
                Toast.makeText(this.context, "Edit text is empty!", Toast.LENGTH_SHORT).show()
        }

        binding.launchButton.setOnClickListener {
            if (!isEditTextNull(binding.editName) &&
                !isEditTextNull(binding.editTitle) &&
                !isEditTextNull(binding.editDescription)
            ) {

                savePreferences(
                    binding.editName.text.toString(),
                    binding.editTitle.text.toString(),
                    binding.editDescription.text.toString()
                )

                savePreferences(true)

                viewModel.setValues(
                    binding.editName.text.toString(),
                    binding.editTitle.text.toString(),
                    binding.editDescription.text.toString()
                )

                (activity as? MainActivity)?.finish()

            }
        }


        binding.cardViewPager.adapter = CardViewPagerAdapter(Cards().getList())

        binding.iconViewPager.adapter = IconsViewPagerAdapter(Icons().getList())
        binding.iconViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                savePreferences(position)
                super.onPageSelected(position)
            }
        })



        binding.arrowForward.setOnClickListener {
            binding.iconViewPager.currentItem = binding.iconViewPager.currentItem + 1
        }

        binding.arrowBack.setOnClickListener {
            binding.iconViewPager.currentItem = binding.iconViewPager.currentItem - 1
        }

        binding.baselineArrowForward.setOnClickListener {
            binding.cardViewPager.currentItem = binding.cardViewPager.currentItem + 1
        }

        binding.baselineArrowBack.setOnClickListener {
            binding.cardViewPager.currentItem = binding.cardViewPager.currentItem - 1
        }

        return binding.root
    }

    private fun isSecondFragmentLaunch(): Boolean {
        val preferences = activity?.getPreferences(Context.MODE_PRIVATE)
        return preferences?.getBoolean("second_fragment_launch", false)!!
    }

    private fun isEditTextNull(editText: EditText): Boolean {
        return editText.text.toString() == ""
    }

    private fun savePreferences(name: String, title: String, description: String) {
        val preferences = activity?.getPreferences(Context.MODE_PRIVATE)
        val editor = preferences?.edit()
        editor?.putString("name", name)
        editor?.putString("title", title)
        editor?.putString("description", description)
        editor?.apply()
    }

    private fun savePreferences(position: Int) {
        val preferences = activity?.getPreferences(Context.MODE_PRIVATE)
        val editor = preferences?.edit()
        editor?.putInt("position", position)
        editor?.apply()
    }

    private fun savePreferences(secondFragmentNextLaunch: Boolean) {
        val preferences = activity?.getPreferences(Context.MODE_PRIVATE)
        val editor = preferences?.edit()
        editor?.putBoolean("second_fragment_launch", secondFragmentNextLaunch)
        editor?.apply()
    }
}