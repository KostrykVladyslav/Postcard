package com.example.postcard.ui.menu_fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.postcard.R
import com.example.postcard.data.Cards
import com.example.postcard.data.Icons
import com.example.postcard.databinding.FragmentMenuBinding
import com.example.postcard.ui.menu_fragment.adapters.CardViewPagerAdapter
import com.example.postcard.ui.menu_fragment.adapters.IconsViewPagerAdapter

@Suppress("SameParameterValue")
class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    private val viewModel: MenuViewModel by viewModels { MenuViewModelFactory(activity) }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding
            .inflate(inflater, container, false)
        binding.imageView.setImageResource(R.drawable.background_snow)


        if (isSecondFragmentLaunch()) {
            findNavController().navigate(R.id.action_mainFragment_to_postcardFragment)
        }

        binding.iconViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                saveIconPositionPreferences(position)
                super.onPageSelected(position)
            }
        })

        binding.iconViewPager.adapter = IconsViewPagerAdapter(Icons().getList())
        binding.cardViewPager.adapter = CardViewPagerAdapter(Cards().getList())

        binding.arrowForward.setOnClickListener {
            if (binding.iconViewPager.currentItem + 1 >= Icons().getList().size) {
                binding.iconViewPager.currentItem = 0
            } else {
                binding.iconViewPager.currentItem = binding.iconViewPager.currentItem + 1
            }
        }

        binding.arrowBack.setOnClickListener {
            if (binding.iconViewPager.currentItem - 1 < 0) {
                binding.iconViewPager.currentItem = Icons().getList().size
            } else {
                binding.iconViewPager.currentItem = binding.iconViewPager.currentItem - 1
            }
        }

        binding.baselineArrowForward.setOnClickListener {
            binding.cardViewPager.currentItem = binding.cardViewPager.currentItem + 1
        }

        binding.baselineArrowBack.setOnClickListener {
            binding.cardViewPager.currentItem = binding.cardViewPager.currentItem - 1
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        viewModel.navigationLiveEvent.observe(viewLifecycleOwner, ::navigate)
    }

    private fun navigate(direction: NavDirections) {
        findNavController().navigate(direction)
    }

    private fun isSecondFragmentLaunch(): Boolean {
        val preferences = activity?.getPreferences(Context.MODE_PRIVATE)
        return preferences?.getBoolean("second_fragment_launch", false)!!
    }

    private fun saveIconPositionPreferences(position: Int) {
        val preferences = activity?.getPreferences(Context.MODE_PRIVATE)
        val editor = preferences?.edit()
        editor?.putInt("position", position)
        editor?.apply()
    }
}