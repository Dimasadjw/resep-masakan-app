package com.example.resepmasakan.Fragments

import android.content.Intent // Import untuk Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resepmasakan.Activities.CategoryResultActivity
import com.example.resepmasakan.Activities.RecipeDetailActivity // Import Activity Tujuan
import com.example.resepmasakan.Models.Kategori
import com.example.resepmasakan.Models.Resep
import com.example.resepmasakan.R
import com.example.resepmasakan.adapters.KategoriAdapter
import com.example.resepmasakan.adapters.ResepAdapter
import com.example.resepmasakan.data.RecipeRepository

class HomeFragment : Fragment() {

    private lateinit var rvKategori: RecyclerView
    private lateinit var rvResep: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val tampilan = inflater.inflate(R.layout.activity_home, container, false)
        return tampilan
    }

    override fun onViewCreated(tampilan: View, savedInstanceState: Bundle?) {
        super.onViewCreated(tampilan, savedInstanceState)

        rvKategori = tampilan.findViewById(R.id.recyclerViewHorizontal)
        rvResep = tampilan.findViewById(R.id.recyclerViewRekomendasi)

        val dataUntukKategori = RecipeRepository.getCategoryData()
        val dataUntukResep = RecipeRepository.getRecommendationData()

        tampilkanKategori(dataUntukKategori)
        tampilkanResep(dataUntukResep)
    }

    private fun tampilkanKategori(dataKategori: List<Kategori>) {

        // AKSI KLIK KATEGORI: Ganti Toast dengan Intent ke CategoryResultActivity
        val adapterUntukKategori = KategoriAdapter(dataKategori) { kategori ->

            // 🎯 Mulai CategoryResultActivity 🎯
            val intent = Intent(requireContext(), CategoryResultActivity::class.java)

            // Mengirim ID Kategori yang diklik
            intent.putExtra(CategoryResultActivity.EXTRA_CATEGORY_ID, kategori.id)

            startActivity(intent)
        }

        rvKategori.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        rvKategori.adapter = adapterUntukKategori
    }

    private fun tampilkanResep(dataResep: List<Resep>) {

        // AKSI KLIK RESEP: Mengarahkan ke Detail Activity
        val adapterUntukResep = ResepAdapter(dataResep) { resep ->

            // 🎯 Memulai RecipeDetailActivity 🎯
            val intent = Intent(requireContext(), RecipeDetailActivity::class.java)
            // Mengirim ID Resep yang diklik
            intent.putExtra(RecipeDetailActivity.EXTRA_RECIPE_ID, resep.id)
            startActivity(intent)
        }

        rvResep.layoutManager = LinearLayoutManager(requireContext())
        rvResep.adapter = adapterUntukResep
    }
}