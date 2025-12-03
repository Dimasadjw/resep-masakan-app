package com.example.resepmasakan.Fragments

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
import com.example.resepmasakan.adapters.ResepAdapter
import com.example.resepmasakan.data.RecipeRepository

// FavoriteFragment adalah "layar" yang tugasnya menampilkan daftar resep favorit.
class FavoriteFragment : Fragment() {

    // Kita butuh satu RecyclerView untuk menampilkan daftar resep favorit.
    private lateinit var rvFavorites: RecyclerView

    // onCreateView adalah fungsi yang dipanggil untuk membuat tampilan (kanvas kosong).
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // "Inflater" adalah alat untuk mengubah file XML (activity_favorite.xml) menjadi tampilan nyata.
        val tampilan = inflater.inflate(R.layout.activity_favorite, container, false)
        // Kembalikan tampilan yang sudah jadi.
        return tampilan
    }

    // onViewCreated dipanggil SETELAH tampilan dari onCreateView selesai dibuat.
    // Sekarang kita siap untuk mengisi "kanvas" kita dengan data.
    override fun onViewCreated(tampilan: View, savedInstanceState: Bundle?) {
        super.onViewCreated(tampilan, savedInstanceState)

        // --- Langkah 1: Atur tombol kembali (Back Button) ---
        // Ini tidak berhubungan dengan RecyclerView, jadi kita kerjakan dulu.
        val tombolKembali: ImageButton = tampilan.findViewById(R.id.back_button)
        tombolKembali.setOnClickListener {
            // Perintah untuk kembali ke layar sebelumnya.
            findNavController().navigateUp()
        }

        // --- Langkah 2: Atur dan Tampilkan Daftar Resep Favorit ---

        // Pertama, kita kenalan dulu dengan RecyclerView yang ada di file XML.
        // Pastikan ID di XML adalah "recycler_view_favorites".
        rvFavorites = tampilan.findViewById(R.id.recycler_view_favorites)

        // Kedua, kita siapkan datanya. Minta data dari "gudang data" kita.
        // --- PERUBAHAN DI SINI ---
        // Kita ambil semua data resep, lalu kita potong dan ambil 7 item pertama saja.
        val dataResepFavorit = RecipeRepository.getRecommendationData().take(7)

        // Ketiga, kita buat Adapter untuk resep.
        // Beri tahu adapter, "Ini data yang mau kamu tampilkan", dan
        // "Kalau itemnya diklik, ini yang harus kamu lakukan".
        val adapterUntukFavorit = ResepAdapter(dataResepFavorit) { resep ->
            // Untuk sementara, kita tampilkan pesan singkat (Toast) saja saat item diklik.
            Toast.makeText(requireContext(), "Ini Resep Favorit: ${resep.nama}", Toast.LENGTH_SHORT).show()
            // Nanti, kode untuk pindah ke halaman detail akan ditaruh di sini.
        }

        // Keempat, atur RecyclerView agar menampilkan item secara menurun (VERTIKAL).
        rvFavorites.layoutManager = LinearLayoutManager(requireContext())

        // Terakhir, pasang adapter yang sudah siap ini ke RecyclerView favorit kita.
        rvFavorites.adapter = adapterUntukFavorit
    }
}
