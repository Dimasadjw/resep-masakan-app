package com.example.resepmasakan.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
// Impor Model yang Benar: Kategori dan Resep
import com.example.resepmasakan.Models.Kategori
import com.example.resepmasakan.Models.Resep
import com.example.resepmasakan.R
import com.example.resepmasakan.adapters.KategoriAdapter
import com.example.resepmasakan.adapters.ResepAdapter
import com.example.resepmasakan.data.RecipeRepository

// HomeFragment adalah sebuah "layar" atau bagian dari layar utama.
class HomeFragment : Fragment() {

    // Kita akan gunakan dua RecyclerView: satu untuk kategori, satu untuk resep.
    private lateinit var rvKategori: RecyclerView
    private lateinit var rvResep: RecyclerView

    // onCreateView: Menyiapkan tampilan (kanvas) dari XML
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Mengubah XML (activity_home.xml) menjadi View nyata
        val tampilan = inflater.inflate(R.layout.activity_home, container, false)
        return tampilan
    }

    // onViewCreated: Mengisi data ke tampilan yang sudah siap
    override fun onViewCreated(tampilan: View, savedInstanceState: Bundle?) {
        super.onViewCreated(tampilan, savedInstanceState)

        // Langkah 1: Hubungkan dengan RecyclerView di XML
        rvKategori = tampilan.findViewById(R.id.recyclerViewHorizontal)
        rvResep = tampilan.findViewById(R.id.recyclerViewRekomendasi)

        // Langkah 2: Siapkan data dari Repository
        val dataUntukKategori = RecipeRepository.getCategoryData() // List<Kategori>
        val dataUntukResep = RecipeRepository.getRecommendationData() // List<Resep>

        // Langkah 3 & 4: Tampilkan data
        tampilkanKategori(dataUntukKategori)
        tampilkanResep(dataUntukResep)
    }

    // --- FUNGSI-FUNGSI BANTU ---

    // Fungsi untuk mengatur dan menampilkan daftar KATEGORI.
    // Menggunakan tipe List<Kategori>
    private fun tampilkanKategori(dataKategori: List<Kategori>) {

        // Buat Adapter Kategori dengan aksi klik
        val adapterUntukKategori = KategoriAdapter(dataKategori) { kategori ->
            // AKSI KLIK: Nanti diganti dengan kode navigasi ke CategoryDetailFragment
            Toast.makeText(requireContext(), "Menuju Kategori: ${kategori.nama}", Toast.LENGTH_SHORT).show()
            // TODO: Gunakan NavController untuk menavigasi dan mengirim kategori.id
        }

        // Atur RecyclerView agar menampilkan item secara mendatar (HORIZONTAL).
        rvKategori.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Pasang adapter ke RecyclerView
        rvKategori.adapter = adapterUntukKategori
    }

    // Fungsi untuk mengatur dan menampilkan daftar RESEP.
    // Menggunakan tipe List<Resep>
    private fun tampilkanResep(dataResep: List<Resep>) {

        // Buat Adapter Resep dengan aksi klik
        val adapterUntukResep = ResepAdapter(dataResep) { resep ->
            // AKSI KLIK: Nanti diganti dengan kode navigasi ke Detail Resep
            Toast.makeText(requireContext(), "Membuka Resep: ${resep.nama}", Toast.LENGTH_SHORT).show()
            // TODO: Gunakan NavController untuk menavigasi ke Detail Resep sambil mengirim resep.id
        }

        // Atur RecyclerView agar menampilkan item secara menurun (VERTIKAL).
        // NestedScrollingEnabled=false di XML, jadi kita gunakan LayoutManager standar.
        rvResep.layoutManager = LinearLayoutManager(requireContext())

        // Pasang adapter ke RecyclerView
        rvResep.adapter = adapterUntukResep
    }
}