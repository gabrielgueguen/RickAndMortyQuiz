package com.example.rickandmortyquiz.screens.title

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.rickandmortyquiz.R
import com.example.rickandmortyquiz.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(
            inflater,
            R.layout.fragment_title,
            container,
            false
        )

        //add play button event
        binding.titlePlayButton.setOnClickListener{
            findNavController().navigate(TitleFragmentDirections.actionTitleDestinationToGameDestination())
        }

        //add options menu
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return binding.root
    }

    //override onCreateOptionsMenu to set menu options
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.navdrawer_menu, menu)
    }

    //override onOptionsItemSelected to set navigation destinations for nav menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}