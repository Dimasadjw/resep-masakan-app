package com.example.resepmasakan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    // Default email jika tidak ada data yang dikirim (untuk menghindari error)
    private var userEmail: String = "guest@resepmasakan.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // --- Langkah 1: Ambil Email dari LoginActivity via Intent ---
        val receivedEmail = intent.getStringExtra("user_email")
        if (receivedEmail != null) {
            userEmail = receivedEmail
        }

        // 1. Mendapatkan referensi ke BottomNavigationView (ID: bottom_navigation)
        val navView: BottomNavigationView = findViewById(R.id.bottomNav) // Pastikan ID ini ada di activity_main.xml

        // 2. Mendapatkan NavController dari NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // --- Langkah 3: Set Argumen Default ke NavController ---
        // Ini memastikan Argumen 'emailPengguna' selalu tersedia saat berpindah ke ProfileFragment
        val bundle = Bundle().apply {
            putString("emailPengguna", userEmail) // Kunci: emailPengguna (Sesuai nav_graph.xml)
        }
        navController.setGraph(navController.graph, bundle)


        // 4. Menghubungkan BottomNavigationView dengan NavController
        navView.setupWithNavController(navController)
    }
}