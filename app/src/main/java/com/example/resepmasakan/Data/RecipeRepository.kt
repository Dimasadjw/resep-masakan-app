package com.example.resepmasakan.data

import com.example.resepmasakan.R
import com.example.resepmasakan.Models.Category
import com.example.resepmasakan.Models.Recipe

object RecipeRepository {

    // FUNGSI 1: DATA KATEGORI
    fun getCategoryData(): List<Category> {
        return listOf(
            Category(id = 1, nama = "Daging Sapi", idIcon = R.drawable.ic_daging),
            Category(id = 2, nama = "Makanan Laut", idIcon = R.drawable.ic_seafood),
            Category(id = 3, nama = "Sayuran", idIcon = R.drawable.ic_sayur),
            Category(id = 4, nama = "Minuman", idIcon = R.drawable.ic_minum),
            Category(id = 5, nama = "Kue & Roti", idIcon = R.drawable.ic_kue)
        )
    }

    // FUNGSI 2: DATA REKOMENDASI RESEP
    fun getRecommendationData(): List<Recipe> {
        // PERHATIAN: Pastikan di data class 'Recipe', properti gambar diubah menjadi 'idGambar: Int'
        return listOf(
            Recipe(
                id = 101,
                nama = "Nasi Goreng Spesial",
                idGambar = R.drawable.img_resep_nasi_goreng, // DIUBAH MENJADI INT (ID DRAWABLE)
                infoDurasiPorsi = "30 Menit | 4 Porsi",
                alat = listOf("Wajan", "Spatula"),
                bahan = listOf("1 piring nasi", "1 butir telur"),
                caraMemasak = listOf("Panaskan minyak.", "Masukkan nasi."),
                rating = 4.7f
            ),
            Recipe(
                id = 102,
                nama = "Soto Ayam Kuah Kuning",
                idGambar = R.drawable.img_resep_soto, // DIUBAH MENJADI INT
                infoDurasiPorsi = "45 Menit | 6 Porsi",
                alat = listOf("Panci besar", "Blender"),
                bahan = listOf("1/2 kg ayam", "Bumbu instan"),
                caraMemasak = listOf("Rebus ayam.", "Masak bumbu."),
                rating = 4.5f
            ),
            Recipe(
                id = 103,
                nama = "Gulai Kambing Pedas",
                idGambar = R.drawable.img_resep_gulai, // DIUBAH MENJADI INT
                infoDurasiPorsi = "60 Menit | 5 Porsi",
                alat = listOf("Panci"),
                bahan = listOf("1 kg Daging", "Santan"),
                caraMemasak = listOf("Rebus daging.", "Masak bumbu."),
                rating = 4.2f
            ),
            Recipe(
                id = 104,
                nama = "Capcay Sayur Kuah",
                idGambar = R.drawable.img_resep_capcay, // DIUBAH MENJADI INT
                infoDurasiPorsi = "20 Menit | 3 Porsi",
                alat = listOf("Wajan"),
                bahan = listOf("Sayuran", "Bawang Putih"),
                caraMemasak = listOf("Tumis bumbu.", "Masukkan sayur."),
                rating = 3.9f
            ),
            Recipe(
                id = 105,
                nama = "Rendang Daging Sapi",
                idGambar = R.drawable.img_resep_rendang, // DIUBAH MENJADI INT
                infoDurasiPorsi = "180 Menit | 8 Porsi",
                alat = listOf("Wajan besar"),
                bahan = listOf("1 kg Daging", "Santan"),
                caraMemasak = listOf("Masak santan hingga berminyak.", "Masukkan daging."),
                rating = 4.9f
            ),
            Recipe(
                id = 106,
                nama = "Sate Ayam Madura",
                idGambar = R.drawable.img_resep_sate, // DIUBAH MENJADI INT
                infoDurasiPorsi = "40 Menit | 10 Tusuk",
                alat = listOf("Panggangan"),
                bahan = listOf("Daging ayam", "Kecap"),
                caraMemasak = listOf("Tusuk daging.", "Bakar dan olesi bumbu."),
                rating = 4.6f
            ),
            // (Lanjutkan untuk sisa resep lainnya dengan pola yang sama)
        )
    }

    // FUNGSI 3: DATA FAVORIT (ambil 5 item pertama dari data rekomendasi)
    fun getFavoriteResep(): List<Recipe> {
        return getRecommendationData().take(5)
    }

    // FUNGSI 4: MENCARI RESEP BERDASARKAN ID (Fungsi baru yang penting)
    fun findRecipeById(id: Int): Recipe? {
        // .find { } akan mencari item pertama yang cocok di dalam list, atau null jika tidak ada.
        return getRecommendationData().find { it.id == id }
    }
}
