package com.example.resepmasakan.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resepmasakan.R
import com.example.resepmasakan.adapters.KategoriAdapter
import com.example.resepmasakan.adapters.ResepAdapter
import com.example.resepmasakan.data.RecipeRepository

// HomeFragment adalah sebuah "layar" atau bagian dari layar utama.
// Tugasnya adalah menampilkan daftar kategori dan daftar rekomendasi resep.
class HomeFragment : Fragment() {

    // Kita akan gunakan dua RecyclerView: satu untuk kategori, satu untuk resep.
    // Kita deklarasikan di sini agar bisa diakses di seluruh bagian class ini.
    private lateinit var rvKategori: RecyclerView
    private lateinit var rvResep: RecyclerView

    // onCreateView adalah fungsi yang pertama kali dipanggil untuk membuat tampilan.
    // Bayangkan ini seperti menyiapkan kanvas kosong.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // "inflater" adalah alat untuk mengubah file layout XML (activity_home.xml)
        // menjadi sebuah "View" atau tampilan nyata yang bisa dilihat.
        val tampilan = inflater.inflate(R.layout.activity_home, container, false)

        // Kita kembalikan tampilan yang sudah jadi ini agar bisa ditampilkan di layar.
        return tampilan
    }

    // onViewCreated dipanggil SETELAH tampilan dari onCreateView selesai dibuat.
    // Sekarang kita punya "kanvas" yang sudah siap untuk kita "lukis" atau isi.
    override fun onViewCreated(tampilan: View, savedInstanceState: Bundle?) {
        super.onViewCreated(tampilan, savedInstanceState)

        // Langkah 1: Kenalan dulu sama RecyclerView yang ada di file XML.
        // Kita cari mereka berdasarkan ID yang sudah kita buat di layout.
        rvKategori = tampilan.findViewById(R.id.recyclerViewHorizontal)
        rvResep = tampilan.findViewById(R.id.recyclerViewRekomendasi)

        // Langkah 2: Siapkan data yang mau ditampilkan.
        // Kita minta data dari "gudang data" kita, yaitu RecipeRepository.
        val dataUntukKategori = RecipeRepository.getCategoryData()
        val dataUntukResep = RecipeRepository.getRecommendationData()

        // Langkah 3: Tampilkan data kategori ke RecyclerView horizontal.
        tampilkanKategori(dataUntukKategori)

        // Langkah 4: Tampilkan data resep ke RecyclerView vertikal.
        tampilkanResep(dataUntukResep)
    }

    // --- FUNGSI-FUNGSI BANTU AGAR KODE LEBIH RAPI ---

    // Fungsi ini khusus untuk mengatur dan menampilkan daftar KATEGORI.
    private fun tampilkanKategori(dataKategori: List<com.example.resepmasakan.Models.Category>) {
        // Buat Adapter untuk kategori.
        // Beri tahu adapter data mana yang harus dipakai, dan apa yang harus dilakukan saat item diklik.
        val adapterUntukKategori = KategoriAdapter(dataKategori) { kategori ->
            // Untuk sementara, kita tampilkan pesan singkat (Toast) saja saat kategori diklik.
            Toast.makeText(requireContext(), "Ini Kategori: ${kategori.nama}", Toast.LENGTH_SHORT).show()
        }

        // Atur RecyclerView agar menampilkan item secara mendatar (HORIZONTAL).
        rvKategori.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Terakhir, pasang adapter yang sudah siap ini ke RecyclerView kategori.
        rvKategori.adapter = adapterUntukKategori
    }

    // Fungsi ini khusus untuk mengatur dan menampilkan daftar RESEP.
    private fun tampilkanResep(dataResep: List<com.example.resepmasakan.Models.Recipe>) {
        // Buat Adapter untuk resep.
        // Beri tahu adapter data mana yang harus dipakai, dan apa yang harus dilakukan saat item diklik.
        val adapterUntukResep = ResepAdapter(dataResep) { resep ->
            // Untuk sementara, kita tampilkan pesan singkat (Toast) saja saat resep diklik.
            Toast.makeText(requireContext(), "Ini Resep: ${resep.nama}", Toast.LENGTH_SHORT).show()
            // Nanti, kode untuk pindah halaman (navigasi) akan ditaruh di sini.
        }

        // Atur RecyclerView agar menampilkan item secara menurun (VERTIKAL).
        rvResep.layoutManager = LinearLayoutManager(requireContext())

        // Terakhir, pasang adapter yang sudah siap ini ke RecyclerView resep.
        rvResep.adapter = adapterUntukResep
    }
}
