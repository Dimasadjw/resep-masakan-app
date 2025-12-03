package com.example.resepmasakan.Models

data class Recipe(
    val id: Int,
    val nama: String,
    val idGambar: int,
    val infoDurasiPorsi: String,
    val alat: List<String>,
    val bahan: List<String>,
    val caraMemasak: List<String>,
    val rating: Float
)

data class Category(
    val id: Int,
    val nama: String,
    val idIcon: Int
)