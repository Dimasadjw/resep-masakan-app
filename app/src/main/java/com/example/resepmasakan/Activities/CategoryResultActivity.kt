package com.example.resepmasakan.Activities

import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.resepmasakan.R
import com.example.resepmasakan.Models.Kategori
import com.example.resepmasakan.adapters.ResepAdapter
import com.example.resepmasakan.data.RecipeRepository

class CategoryResultActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_CATEGORY_ID = "extra_category_id"
    }

    // 1. Deklarasi Views
    private lateinit var backButton: ImageButton
    private lateinit var categoryTitle: TextView
    private lateinit var categorySpinner: Spinner
    private lateinit var rvResep: RecyclerView

    // 2. Data dan Adapter
    private lateinit var allCategories: List<Kategori>
    private lateinit var resepAdapter: ResepAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Asumsi nama layout file Anda adalah activity_categories
        setContentView(R.layout.activity_categories)

        // 3. Inisialisasi Views dan Data Global
        initializeViews()
        allCategories = RecipeRepository.getCategoryData()

        // 4. Ambil ID Kategori Awal yang Dikirim dari HomeFragment
        val receivedCategoryId = intent.getIntExtra(EXTRA_CATEGORY_ID, -1)

        // 5. Setup RecyclerView dan Spinner
        setupRecyclerView()
        setupSpinner(receivedCategoryId)

        // 6. Setup Listener Tombol Kembali
        backButton.setOnClickListener { finish() }
    }

    private fun initializeViews() {
        // Mengaitkan ID dari Layout XML yang Anda berikan
        backButton = findViewById(R.id.back_button)
        categoryTitle = findViewById(R.id.detail_title)
        categorySpinner = findViewById(R.id.spinner_category_select)
        rvResep = findViewById(R.id.rv_food_horizontal)

        categoryTitle.text = "FILTER RESEP"
    }

    private fun setupRecyclerView() {
        // Inisialisasi Adapter Resep (menggunakan updateData dari ResepAdapter Anda)
        resepAdapter = ResepAdapter(emptyList()) { resep ->
            // Logika Intent untuk Detail Resep
            val intent = Intent(this, RecipeDetailActivity::class.java)
            intent.putExtra(RecipeDetailActivity.EXTRA_RECIPE_ID, resep.id)
            startActivity(intent)
        }
        rvResep.adapter = resepAdapter
        // LayoutManager sudah diset di XML, jadi tidak perlu diset di sini.
    }

    private fun setupSpinner(initialCategoryId: Int) {
        // 1. Siapkan data dan adapter untuk Spinner
        val categoryNames = allCategories.map { it.nama }

        val spinnerAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            categoryNames
        )
        categorySpinner.adapter = spinnerAdapter

        // 2. Tentukan Kategori Awal yang Diklik di HomeFragment
        val initialCategoryIndex = allCategories.indexOfFirst { it.id == initialCategoryId }

        if (initialCategoryIndex != -1) {
            categorySpinner.setSelection(initialCategoryIndex)
        } else {
            // Jika ID tidak valid, set ke item pertama ("Semua Resep")
            categorySpinner.setSelection(0)
        }

        // 3. Set Listener Spinner untuk memfilter data
        categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedCategory = allCategories[position]
                loadRecipesByCategory(selectedCategory.id) // Panggil fungsi filter
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Tidak ada aksi
            }
        }
    }

    /**
     * Memuat dan menampilkan resep berdasarkan ID kategori.
     */
    private fun loadRecipesByCategory(categoryId: Int) {
        // Menggunakan fungsi Repository yang sudah Anda sediakan (getRecipesByCategory)
        val filteredRecipes = RecipeRepository.getRecipesByCategory(categoryId)

        // Panggil fungsi updateData (submitList) dari ResepAdapter Anda
        resepAdapter.updateData(filteredRecipes)

        if (filteredRecipes.isEmpty() && categoryId != 0) {
            Toast.makeText(this, "Tidak ada resep ditemukan untuk kategori ini.", Toast.LENGTH_SHORT).show()
        }
    }
}