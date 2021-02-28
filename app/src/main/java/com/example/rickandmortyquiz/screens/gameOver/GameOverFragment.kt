package com.example.rickandmortyquiz.screens.gameOver

/*
Author: Gabriel Gueguen
 Title: Game Over Fragment class for Rick and Morty quiz game over fragment
  Date: 2021-02-27
 */

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.rickandmortyquiz.R
import com.example.rickandmortyquiz.databinding.FragmentGameBinding
import com.example.rickandmortyquiz.databinding.FragmentGameOverBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ScoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameOverFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentGameOverBinding>(
            inflater,
            R.layout.fragment_game_over,
            container,
            false
        )
        //set game over text
        binding.gameoverTextview.text = GameOverFragmentArgs.fromBundle(requireArguments()).gameOverMessage
        // Inflate the layout for this fragment
        return binding.root
    }
}