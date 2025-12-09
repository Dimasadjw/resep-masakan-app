package com.example.resepmasakan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    // Memberikan nilai default yang aman jika Intent gagal
    private var userEmail: String = "guest@resepmasakan.com"
    private lateinit var fabAddResep: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabAddResep = findViewById(R.id.addResep)

        // --- Langkah 1: Ambil Email dari Intent ---
        val receivedEmail = intent.getStringExtra("user_email")
        if (receivedEmail != null) {
            userEmail = receivedEmail
        }

        val navView: BottomNavigationView = findViewById(R.id.bottomNav)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // --- KOREKSI 1: Hapus Pengaturan Bundle yang tidak efektif ---
        // Hapus: navController.setGraph(navController.graph, bundle)


        // --- KOREKSI 2: Handle navigasi secara manual untuk ProfileFragment ---
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_profile -> {
                    // Ciptakan Safe Args Action dengan email yang sudah diambil
                    val action = NavGraphDirections.actionGlobalNavProfile(
                        emailPengguna = userEmail // Mengirim data email!
                    )
                    navController.navigate(action)
                    true // Menandakan event dikonsumsi
                }
                else -> {
                    // Gunakan navigasi otomatis untuk Fragment lainnya (Home, Bookmark)
                    navController.navigate(item.itemId)
                    true
                }
            }
        }
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.nav_home) {
                fabAddResep.show()
            } else {
                fabAddResep.hide()
            }
        }
    }
}