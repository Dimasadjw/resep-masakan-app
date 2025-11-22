package com.example.resepmasakan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Mendapatkan referensi ke BottomNavigationView (ID: bottomNav)
        val navView: BottomNavigationView = findViewById(R.id.bottomNav)

        // 2. Mendapatkan NavController dari NavHostFragment (ID: nav_host_fragment)
        // Pastikan casting ke NavHostFragment benar.
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // 3. Menghubungkan BottomNavigationView dengan NavController
        navView.setupWithNavController(navController)
    }
}