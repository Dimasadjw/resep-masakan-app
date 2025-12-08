package com.example.resepmasakan.Activities

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.example.resepmasakan.Models.Resep
import com.example.resepmasakan.data.RecipeRepository
import com.example.resepmasakan.R

class RecipeDetailActivity : AppCompatActivity() {

    // Deklarasi View yang sesuai dengan ID XML yang baru
    private lateinit var backButton: ImageButton
    private lateinit var favoriteTitle: TextView
    private lateinit var btnShare: ImageButton
    private lateinit var imgFood: ImageView
    private lateinit var txtNamaMakanan: TextView // ID BARU
    private lateinit var txtDurasi: TextView      // ID BARU
    private lateinit var txtRating: TextView      // ID BARU
    private lateinit var icBookmark: ImageButton
    private lateinit var txtAlatBahan: TextView   // ID BARU
    private lateinit var txtLangkahMemasak: TextView // ID BARU

    companion object {
        const val EXTRA_RECIPE_ID = "extra_recipe_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Ganti R.layout.nama_file_xml_detail_resep Anda di sini
        setContentView(R.layout.activity_description)

        // 1. Inisialisasi semua View menggunakan findViewById

        // Header Views
        backButton = findViewById(R.id.back_button)
        favoriteTitle = findViewById(R.id.favorite_title)
        btnShare = findViewById(R.id.btnShare)

        // Summary Views
        imgFood = findViewById(R.id.imgFood)
        txtNamaMakanan = findViewById(R.id.txtNamaMakanan) // Mengambil ID baru
        txtDurasi = findViewById(R.id.txtDurasi)           // Mengambil ID baru
        txtRating = findViewById(R.id.txtRating)           // Mengambil ID baru
        icBookmark = findViewById(R.id.ic_bookmark)

        // ScrollView Content Views
        txtAlatBahan = findViewById(R.id.txtAlatBahan)       // Mengambil ID baru
        txtLangkahMemasak = findViewById(R.id.txtLangkahMemasak) // Mengambil ID baru


        // 2. Ambil ID resep dari Intent
        val recipeId = intent.getIntExtra(EXTRA_RECIPE_ID, -1)

        if (recipeId != -1) {
            val recipe = RecipeRepository.findRecipeById(recipeId)
            recipe?.let {
                displayRecipeDetails(it)
            }
        }

        // 3. Set Listener
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        btnShare.setOnClickListener {
            // TODO: Logika Share
        }

        icBookmark.setOnClickListener {
            // TODO: Logika Bookmark
        }
    }

    /**
     * Fungsi untuk menampilkan detail resep ke UI.
     * Menggunakan properti Resep dan ID View yang baru.
     */
    private fun displayRecipeDetails(recipe: Resep) {

        txtNamaMakanan.text = recipe.nama
        favoriteTitle.text = recipe.nama

        val parts = recipe.infoDurasiPorsi.split("|")
        txtDurasi.text = "🕒 Durasi: ${parts.getOrNull(0)?.trim() ?: recipe.infoDurasiPorsi}"

        txtRating.text = "⭐ Rating: ${recipe.rating}"
        imgFood.setImageResource(recipe.idGambar)

        // 4. Mengisi Alat dan Bahan (txtAlatBahan)
        val htmlAlat = recipe.alat
            .joinToString(separator = "") { "<li>${it.trim()}</li>" }

        val htmlBahan = recipe.bahan
            .joinToString(separator = "") { "<li>${it.trim()}</li>" }

        val alatBahanHtml = """
            <b>ALAT:</b>
            <ul>$htmlAlat</ul>
            <br>
            <b>BAHAN:</b>
            <ul>$htmlBahan</ul>
        """.trimIndent()

        // Menggunakan HtmlCompat untuk menampilkan HTML di TextView
        txtAlatBahan.text = HtmlCompat.fromHtml(alatBahanHtml, HtmlCompat.FROM_HTML_MODE_LEGACY)

        val langkahHtml = recipe.caraMemasak
            .joinToString(separator = "") { "<li>${it.trim()}</li>" }

        val langkahMemasakHtml = """
            <ol>$langkahHtml</ol>
        """.trimIndent()

        txtLangkahMemasak.text = HtmlCompat.fromHtml(langkahMemasakHtml, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}