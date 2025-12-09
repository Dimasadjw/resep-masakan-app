package com.example.resepmasakan.Fragments

import android.content.Intent // Wajib diimpor untuk navigasi ke Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resepmasakan.R
import com.example.resepmasakan.Models.Resep
import com.example.resepmasakan.Activities.RecipeDetailActivity // Wajib diimpor
import com.example.resepmasakan.adapters.ResepAdapter
import com.example.resepmasakan.data.RecipeRepository

// FavoriteFragment menampilkan 5 Resep Pilihan Statis dari Repository.
class FavoriteFragment : Fragment() {

    private lateinit var rvFavorites: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val tampilan = inflater.inflate(R.layout.activity_favorite, container, false)
        return tampilan
    }

    // Fungsi utama untuk mengatur View dan Data
    override fun onViewCreated(tampilan: View, savedInstanceState: Bundle?) {
        super.onViewCreated(tampilan, savedInstanceState)

        // --- Langkah 1: Atur tombol kembali ---
        val tombolKembali: ImageButton = tampilan.findViewById(R.id.back_button)
        tombolKembali.setOnClickListener {
            // Perintah untuk kembali ke layar sebelumnya.
            findNavController().navigateUp()
        }

        // --- Langkah 2 & 3: Ambil Data Favorit dan Inisialisasi RecyclerView ---
        val dataResepFavorit: List<Resep> = RecipeRepository.getFavoriteResep()
        rvFavorites = tampilan.findViewById(R.id.recycler_view_favorites)

        if (dataResepFavorit.isEmpty()) {
            Toast.makeText(requireContext(), "Daftar Resep Pilihan Kosong.", Toast.LENGTH_LONG).show()
        }

        // --- Langkah 4: Atur Adapter dan Navigasi Intent ---
        val adapterUntukFavorit = ResepAdapter(dataResepFavorit) { resep ->
            // 🎯 KOREKSI: Ganti Toast dengan Intent ke Detail Activity 🎯

            val intent = Intent(requireContext(), RecipeDetailActivity::class.java)
            // Kirim ID Resep menggunakan kunci yang didefinisikan di RecipeDetailActivity
            intent.putExtra(RecipeDetailActivity.EXTRA_RECIPE_ID, resep.id)
            startActivity(intent)
        }

        // Atur LayoutManager (Vertikal)
        rvFavorites.layoutManager = LinearLayoutManager(requireContext())

        // Pasang adapter ke RecyclerView
        rvFavorites.adapter = adapterUntukFavorit
    }
}