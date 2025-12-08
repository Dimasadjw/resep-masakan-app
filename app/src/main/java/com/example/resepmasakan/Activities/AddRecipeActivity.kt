package com.example.resepmasakan.Activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.resepmasakan.R

class AddRecipeActivity : AppCompatActivity() {

    // Deklarasi properti UI
    private lateinit var etNamaResep: EditText
    private lateinit var etAlatBahan: EditText
    private lateinit var etCaraMasak: EditText
    private lateinit var btnTambah: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Asumsi nama file layout adalah 'activity_add_recipe'
        setContentView(R.layout.activity_add_recipe)

        // 1. Inisialisasi View menggunakan findViewById
        initializeViews()

        // 2. Setup Listeners
        setupListeners()

        // Opsional: Sesuaikan judul
        (findViewById<TextView>(R.id.tvTitle)).text = "TAMBAH RESEP"
    }

    /**
     * Menginisialisasi semua View UI menggunakan findViewById.
     */
    private fun initializeViews() {
        // Inisialisasi EditText dan Button yang akan digunakan untuk logika
        etNamaResep = findViewById(R.id.etNamaResep)
        etAlatBahan = findViewById(R.id.etAlatBahan)
        etCaraMasak = findViewById(R.id.etCaraMasak)
        btnTambah = findViewById(R.id.btnTambah)

        // Catatan: btnBack dan tvTitle diakses langsung di setupListeners atau onCreate
    }

    /**
     * Menyiapkan listener untuk tombol Kembali dan Tambah.
     */
    private fun setupListeners() {
        // Setup Tombol Kembali (btnBack)
        findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            // Menutup Activity saat tombol kembali diklik
            finish()
        }

        // Setup Tombol Tambah (btnTambah)
        btnTambah.setOnClickListener {
            // Ambil data dari EditText fields
            val recipeName = etNamaResep.text.toString().trim()
            val ingredientsAndTools = etAlatBahan.text.toString().trim()
            val cookingInstructions = etCaraMasak.text.toString().trim()

            // Validasi input
            if (recipeName.isEmpty() || ingredientsAndTools.isEmpty() || cookingInstructions.isEmpty()) {
                Toast.makeText(this, "Mohon lengkapi semua bidang input resep.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // --- Logika Penyimpanan Resep ---
            // Di sini Anda akan mengintegrasikan kode untuk menyimpan data ke database.

            val message = "Resep '$recipeName' berhasil disimpan!"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()

            // Contoh aksi setelah menyimpan:
//             finish()
        }
    }
}