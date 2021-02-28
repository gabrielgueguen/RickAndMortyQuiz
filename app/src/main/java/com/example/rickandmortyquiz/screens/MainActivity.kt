package com.example.rickandmortyquiz.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.rickandmortyquiz.R
import com.example.rickandmortyquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main
        )
        drawerLayout = binding.drawerLayout

        //setup menus for about and rules fragments
        val navController = this.findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        //change navigate up to open the nav drawer
        val navController = this.findNavController(R.id.nav_host_fragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }
}