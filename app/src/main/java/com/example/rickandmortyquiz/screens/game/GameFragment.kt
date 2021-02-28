package com.example.rickandmortyquiz.screens.game

/*
Author: Gabriel Gueguen
 Title: Game Fragment class for Rick and Morty quiz game fragment
  Date: 2021-02-27
 */

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.rickandmortyquiz.R
import com.example.rickandmortyquiz.databinding.FragmentGameBinding

/**
 * A simple [Fragment] subclass.
 * Use the [GameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameFragment : Fragment() {
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater,
            R.layout.fragment_game,
            container,
            false
        )

        //instantiate view model
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        //observer for game over event
        viewModel.eventGameOver.observe(viewLifecycleOwner, Observer<Boolean> { hasEnded ->
            if (hasEnded) gameEnd()
        })

        binding.gameViewModel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

        // Inflate the layout for this fragment
        return binding.root
    }

    /**
     * End the game by navigating to the game over screen (with a toast)
     */
    private fun gameEnd() {
        Toast.makeText(activity, "Game is over", Toast.LENGTH_SHORT).show()
        NavHostFragment.findNavController(this).navigate(
            GameFragmentDirections.actionGameDestinationToGameOverDestination(
                viewModel.scoreText.value ?: "ERROR, SCORE TEXT MISSING"
            )
        )
        viewModel.onGameEndCompleted()
    }
}