package com.example.resepmasakan.Models

data class Resep(
    val id: Int,
    val nama: String,
    val idGambar: Int,
    val infoDurasiPorsi: String,
    val alat: List<String>,
    val bahan: List<String>,
    val caraMemasak: List<String>,
    val rating: Float,
    val categoryId: Int,
    var isBookmarked: Boolean = false
)
data class Kategori(
    val id: Int,
    val nama: String,
    val idIcon: Int
)