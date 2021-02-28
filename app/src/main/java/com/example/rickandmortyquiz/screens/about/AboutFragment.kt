package com.example.rickandmortyquiz.screens.about

/*
Author: Gabriel Gueguen
 Title: About Fragment class for Rick and Morty quiz about fragment
  Date: 2021-02-27
 */

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.rickandmortyquiz.R
import com.example.rickandmortyquiz.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAboutBinding>(inflater, R.layout.fragment_about, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
}