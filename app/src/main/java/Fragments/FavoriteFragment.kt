package com.example.resepmasakan.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController

// Pastikan semua impor ini sudah benar
import com.example.resepmasakan.R
import com.yourdomain.appname.adapters.ResepAdapter
import com.yourdomain.appname.data.ResepRepository
import com.yourdomain.appname.models.Resep

class FavoriteFragment : Fragment() {

    // Deklarasi Adapter
    private lateinit var favoritesAdapter: ResepAdapter

    // --- BAGIAN 1: MEMUAT TAMPILAN (LAYOUT) ---
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Menginflate layout activity_favorite.xml
        return inflater.inflate(R.layout.activity_favorite, container, false)
    }

    // --- BAGIAN 2: INISIALISASI KOMPONEN UI ---
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Setup Tombol Kembali (Menggunakan Lambda Standar)
        val backButton: ImageButton = view.findViewById(R.id.back_button)
        backButton.setOnClickListener {
            // Lambda: Kode sederhana untuk kembali ke layar sebelumnya
            findNavController().navigateUp()
        }

        // 2. Inisialisasi Adapter dengan Lambda Click Listener
        // Adapter dikirimkan sebuah fungsi Lambda yang akan dieksekusi saat item diklik.
        favoritesAdapter = ResepAdapter { resep: Resep ->
            // Aksi Lambda: Logika yang terjadi saat item Resep Favorit diklik.
            // Contoh: Navigasi ke detail resep atau menampilkan toast
            println("Navigasi ke Detail Resep ID: ${resep.id}")
            // findNavController().navigate(action_ke_detail)
        }

        // 3. Setup RecyclerView
        val rvFavorites: RecyclerView = view.findViewById(R.id.recycler_view_favorites)
        rvFavorites.apply {
            // LayoutManager yang mengatur tampilan item secara vertikal
            layoutManager = LinearLayoutManager(context)
            // Menghubungkan Adapter ke RecyclerView
            adapter = favoritesAdapter
        }

        // 4. Memuat Data Favorit (Logika Sederhana)
        val listFavorites = ResepRepository.getFavoriteResep()
        favoritesAdapter.submitList(listFavorites)
    }

    // --- Fungsi Helper yang Dihapus (setupFavoritesRecyclerView, loadFavoriteResep) ---
    // Logikanya sekarang langsung berada di onViewCreated.
}