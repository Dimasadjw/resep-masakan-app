package com.example.resepmasakan.Activities

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
// Import model dan repository yang diperlukan
import com.example.resepmasakan.Models.Resep
import com.example.resepmasakan.data.RecipeRepository
import com.example.resepmasakan.R

class RecipeDetailActivity : AppCompatActivity() {

    // Deklarasi View yang sesuai dengan ID XML yang baru
    private lateinit var backButton: ImageButton
    private lateinit var favoriteTitle: TextView
    private lateinit var btnShare: ImageButton
    private lateinit var imgFood: ImageView
    private lateinit var txtNamaMakanan: TextView
    private lateinit var txtDurasi: TextView
    private lateinit var txtRating: TextView
    private lateinit var icBookmark: ImageButton // Icon Bookmark
    private lateinit var txtAlatBahan: TextView
    private lateinit var txtLangkahMemasak: TextView

    // Variabel untuk menyimpan objek Resep yang sedang ditampilkan
    private var currentRecipe: Resep? = null

    companion object {
        const val EXTRA_RECIPE_ID = "extra_recipe_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        initializeViews()

        val recipeId = intent.getIntExtra(EXTRA_RECIPE_ID, -1)
        loadRecipeData(recipeId)

        setupListeners()
    }

    private fun initializeViews() {
        // Inisialisasi semua View menggunakan findViewById
        backButton = findViewById(R.id.back_button)
        favoriteTitle = findViewById(R.id.favorite_title)
        btnShare = findViewById(R.id.btnShare)
        imgFood = findViewById(R.id.imgFood)
        txtNamaMakanan = findViewById(R.id.txtNamaMakanan)
        txtDurasi = findViewById(R.id.txtDurasi)
        txtRating = findViewById(R.id.txtRating)
        icBookmark = findViewById(R.id.ic_bookmark)
        txtAlatBahan = findViewById(R.id.txtAlatBahan)
        txtLangkahMemasak = findViewById(R.id.txtLangkahMemasak)
    }

    private fun loadRecipeData(recipeId: Int) {
        if (recipeId != -1) {
            val recipe = RecipeRepository.findRecipeById(recipeId)
            recipe?.let {
                currentRecipe = it // Simpan resep ke variabel global
                displayRecipeDetails(it)
                // Panggil fungsi untuk mengatur ikon awal berdasarkan status yang dimuat
                updateBookmarkIcon(it.isBookmarked)
            }
        } else {
            Toast.makeText(this, "ID Resep tidak valid.", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    private fun setupListeners() {
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        btnShare.setOnClickListener {
            Toast.makeText(this, "Fungsi Share...", Toast.LENGTH_SHORT).show()
        }

        // --- IMPLEMENTASI LOGIKA TOMBOL BOOKMARK ---
        icBookmark.setOnClickListener {
            currentRecipe?.let { recipe ->
                // 1. Balikkan status bookmark
                val newStatus = !recipe.isBookmarked
                recipe.isBookmarked = newStatus // Update status di objek Resep

                // 2. Update status di Repository/Database secara permanen
                // FUNGSI INI HARUS ADA DI RecipeRepository.kt
                RecipeRepository.updateRecipeBookmarkStatus(recipe.id, newStatus)

                // 3. Perbarui tampilan ikon
                updateBookmarkIcon(newStatus) // Panggilan fungsi yang benar

                // 4. Beri Feedback ke pengguna
                val message = if (newStatus) "Resep berhasil ditandai!" else "Tanda resep dihapus."
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Memperbarui ikon bookmark (terisi atau garis luar)
     * berdasarkan status Boolean.
     */
    private fun updateBookmarkIcon(isBookmarked: Boolean) {
        if (isBookmarked) {
            // Menggunakan ikon terisi (misalnya warna merah)
            icBookmark.setImageResource(R.drawable.ic_bookmark_click)
        } else {
            // Menggunakan ikon garis luar (kosong)
            icBookmark.setImageResource(R.drawable.ic_bookmark)
        }
    }

    /**
     * Fungsi untuk menampilkan detail resep ke UI.
     */
    private fun displayRecipeDetails(recipe: Resep) {

        txtNamaMakanan.text = recipe.nama
        favoriteTitle.text = recipe.nama
        txtDurasi.text = "Durasi: ${recipe.infoDurasiPorsi.split("|")[0].trim()}"
        txtRating.text = "⭐ Rating: ${recipe.rating}"
        imgFood.setImageResource(recipe.idGambar)

        // Mengisi Alat dan Bahan
        val alatBahanText = "ALAT:\n* ${recipe.alat.joinToString(separator = "\n* ")}\n\n" +
                "BAHAN:\n* ${recipe.bahan.joinToString(separator = "\n* ")}"
        txtAlatBahan.text = alatBahanText

        // Mengisi Langkah Memasak
        val langkahMemasakText = recipe.caraMemasak
            .mapIndexed { index, step -> "${index + 1}. $step" }
            .joinToString(separator = "\n")
        txtLangkahMemasak.text = langkahMemasakText
    }
}