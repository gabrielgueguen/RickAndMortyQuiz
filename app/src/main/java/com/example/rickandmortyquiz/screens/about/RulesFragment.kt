package com.example.rickandmortyquiz.screens.about

/*
Author: Gabriel Gueguen
 Title: Rules Fragment class for Rick and Morty rules fragment
  Date: 2021-02-27
 */

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.rickandmortyquiz.R
import com.example.rickandmortyquiz.databinding.FragmentRulesBinding

class RulesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRulesBinding>(inflater, R.layout.fragment_rules, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }
}