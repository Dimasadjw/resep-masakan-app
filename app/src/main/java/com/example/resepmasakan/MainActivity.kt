package com.example.resepmasakan

import android.content.Intent // Wajib diimpor
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.resepmasakan.Activities.AddRecipeActivity // Wajib diimpor

class MainActivity : AppCompatActivity() {

    private var userEmail: String = "guest@resepmasakan.com"
    private lateinit var fabAddResep: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // --- Langkah 0: Inisialisasi FAB ---
        fabAddResep = findViewById(R.id.addResep)

        // 🎯 KOREKSI: Tambahkan Click Listener untuk FAB 🎯
        fabAddResep.setOnClickListener {
            // Membuat Intent untuk membuka AddRecipeActivity
            val intent = Intent(this, AddRecipeActivity::class.java)
            startActivity(intent)
        }

        // --- Langkah 1 & 2: Ambil Email dan Inisialisasi Nav Host ---
        val receivedEmail = intent.getStringExtra("user_email")
        if (receivedEmail != null) {
            userEmail = receivedEmail
        }

        val navView: BottomNavigationView = findViewById(R.id.bottomNav)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // --- Langkah 3: Handle navigasi secara manual untuk ProfileFragment (seperti yang dikoreksi sebelumnya) ---
        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_profile -> {
                    // Ciptakan Safe Args Action dengan email yang sudah diambil
                    val action = NavGraphDirections.actionGlobalNavProfile(
                        emailPengguna = userEmail
                    )
                    navController.navigate(action)
                    true
                }
                else -> {
                    // Navigasi otomatis untuk Fragment lainnya
                    navController.navigate(item.itemId)
                    true
                }
            }
        }

        // --- Langkah 4: Kontrol Visibilitas FAB (Dibiarkan sama) ---
        navController.addOnDestinationChangedListener { _, destination, _ ->
            // FAB hanya ditampilkan di HomeFragment
            if (destination.id == R.id.nav_home) {
                fabAddResep.show()
            } else {
                fabAddResep.hide()
            }
        }
    }
}