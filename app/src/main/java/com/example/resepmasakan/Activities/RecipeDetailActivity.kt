package com.example.resepmasakan.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.resepmasakan.Models.Resep
import com.example.resepmasakan.data.RecipeRepository
import com.example.resepmasakan.R
import com.example.resepmasakan.databinding.ActivityDescriptionBinding

class RecipeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDescriptionBinding

    companion object {
        const val EXTRA_RECIPE_ID = "extra_recipe_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi dan Set ContentView
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil ID resep dari Intent
        val recipeId = intent.getIntExtra(EXTRA_RECIPE_ID, -1)

        if (recipeId != -1) {
            // Menggunakan fungsi findRecipeById dari Repository Anda
            val recipe = RecipeRepository.findRecipeById(recipeId)
            recipe?.let {
                displayRecipeDetails(it)
            }
        }

        // Set listener untuk tombol kembali
        binding.headerLayout.backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // Set listener untuk tombol Share
        binding.btnShare.setOnClickListener {
            // TODO: Tambahkan Intent.ACTION_SEND
        }

        // Set listener untuk tombol Bookmark
        binding.icBookmark.setOnClickListener {
            // TODO: Tambahkan logika favorit
        }
    }

    /**
     * Fungsi untuk menampilkan detail resep ke UI.
     * Menggunakan properti Resep yang baru (alat, bahan, caraMemasak).
     */
    private fun displayRecipeDetails(recipe: Resep) {

        // Tampilkan nama makanan
        binding.txtFoodName.text = recipe.nama

        // 2. Menyesuaikan teks deskripsi dengan properti yang tersedia di model Resep.
        // Properti 'deskripsi' tidak ada di model Resep Anda, jadi kita gabungkan 'alat', 'bahan', dan 'caraMemasak'
        val descriptionText = """
            🕒 Durasi: ${recipe.infoDurasiPorsi}
            ⭐ Rating: ${recipe.rating}

            ## 🔪 Alat dan Bahan
            ${recipe.alat.joinToString(separator = "\n* ", prefix = "* ")}

            ---

            ## 👨‍🍳 Cara Memasak
            ${recipe.caraMemasak.mapIndexed { index, step -> "${index + 1}. $step" }.joinToString(separator = "\n")}
        """.trimIndent()

        binding.scrollDesc.txtDescription.text = descriptionText

        // Perbarui Judul Header
        binding.headerLayout.favoriteTitle.text = recipe.nama

        // TODO: Atur image (Gunakan library seperti Glide/Coil untuk memuat R.drawable.idGambar)
        binding.imgFood.setImageResource(recipe.idGambar)
    }
}