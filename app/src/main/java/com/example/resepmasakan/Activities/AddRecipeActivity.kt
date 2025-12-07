package com.yourpackage.app // Ganti dengan package aplikasi Anda yang sebenarnya

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.resepmasakan.databinding.ActivityAddRecipeBinding
import com.yourpackage.app.databinding.ActivityAddRecipeBinding // Sesuaikan dengan nama file layout Anda (misalnya: activity_add_recipe)

class AddRecipeActivity : AppCompatActivity() {

    // Deklarasi View Binding
    private lateinit var binding: ActivityAddRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi View Binding dan atur layout
        // Pastikan nama kelas ini sesuai dengan nama file layout XML Anda
        binding = ActivityAddRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Setup Tombol Kembali (Back Button)
        setupBackButton()

        // 2. Setup Tombol Tambah (Save Button)
        setupAddButton()

        // Opsional: Ganti Judul jika Anda ingin menyesuaikannya secara dinamis
        // Berdasarkan XML, TextView yang memiliki ID 'tvTitle' memiliki teks "RESEP".
        // Karena desain Anda menggunakan "TAMBAH RESEP" di atas input fields,
        // kita bisa menggantinya di sini, atau langsung di XML.
        binding.tvTitle.text = "TAMBAH RESEP"
    }

    /**
     * Menyiapkan listener untuk tombol kembali.
     */
    private fun setupBackButton() {
        binding.btnBack.setOnClickListener {
            // Aksi saat tombol kembali diklik, biasanya menutup Activity saat ini
            finish()
        }
    }

    /**
     * Menyiapkan listener untuk tombol Tambah/Simpan Resep.
     */
    private fun setupAddButton() {
        binding.btnTambah.setOnClickListener {
            // Ambil data dari EditText fields
            val recipeName = binding.etNamaResep.text.toString().trim()
            val ingredientsAndTools = binding.etAlatBahan.text.toString().trim()
            val cookingInstructions = binding.etCaraMasak.text.toString().trim()

            // Lakukan validasi sederhana
            if (recipeName.isEmpty() || ingredientsAndTools.isEmpty() || cookingInstructions.isEmpty()) {
                Toast.makeText(this, "Semua kolom harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // --- Logika untuk menyimpan resep ---

            // Di sini Anda akan menambahkan logika untuk:
            // 1. Membuat objek/model Resep baru.
            // 2. Menyimpan objek tersebut ke database (misalnya Room, Firebase, dll.).

            // Contoh: Tampilkan Toast bahwa resep telah disimpan
            val message = "Resep '$recipeName' berhasil ditambahkan!"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()

            // Setelah disimpan, Anda dapat menutup Activity:
            // finish()
        }
    }
}