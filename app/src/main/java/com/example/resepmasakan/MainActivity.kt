package com.example.resepmasakan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton // Import yang dibutuhkan

class MainActivity : AppCompatActivity() {

    private var userEmail: String = "guest@resepmasakan.com"
    // 🎯 Deklarasi FAB
    private lateinit var fabAddResep: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // --- Langkah 0: Inisialisasi FAB ---
        fabAddResep = findViewById(R.id.fab_add_resep) // Pastikan ID ini ada di activity_main.xml

        // --- Langkah 1: Ambil Email dari Intent ---
        val receivedEmail = intent.getStringExtra("user_email")
        if (receivedEmail != null) {
            userEmail = receivedEmail
        }

        // 2. Mendapatkan BottomNavigationView
        val navView: BottomNavigationView = findViewById(R.id.bottomNav)

        // 3. Mendapatkan NavController
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // --- Langkah 4: Set Argumen Default ke NavController ---
        val bundle = Bundle().apply {
            putString("emailPengguna", userEmail) // Kunci: emailPengguna (Sesuai nav_graph.xml)
        }
        navController.setGraph(navController.graph, bundle)


        // 5. Menghubungkan BottomNavigationView dengan NavController
        navView.setupWithNavController(navController)

//        Kontrol Visibilitas FAB
        navController.addOnDestinationChangedListener { _, destination, _ ->
            // Periksa apakah ID Fragment saat ini adalah ID HomeFragment
            if (destination.id == R.id.nav_home) {
                fabAddResep.show() // Tampilkan FAB
            } else {
                fabAddResep.hide() // Sembunyikan FAB di Fragment lain
            }
        }
    }
}