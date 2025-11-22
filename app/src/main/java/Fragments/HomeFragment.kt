package com.example.resepmasakan.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resepmasakan.R

// Pastikan semua impor ini sudah benar
import com.yourdomain.appname.adapters.ResepAdapter
import com.yourdomain.appname.adapters.KategoriAdapter
import com.yourdomain.appname.data.ResepRepository
import com.yourdomain.appname.data.KategoriRepository

class HomeFragment : Fragment() {

    // Deklarasi Adapter
    private lateinit var kategoriAdapter: KategoriAdapter
    private lateinit var rekomendasiAdapter: ResepAdapter

    // --- BAGIAN 1: MEMUAT TAMPILAN (LAYOUT) ---
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Mengambil file layout XML (activity_home.xml) dan mengubahnya menjadi View
        return inflater.inflate(R.layout.activity_home, container, false)
    }

    // --- BAGIAN 2: INISIALISASI KOMPONEN UI DAN DATA ---
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Inisialisasi Adapter
        initAdapters()

        // 2. Setup RecyclerView Kategori (Horizontal)
        setupKategoriRecyclerView(view)

        // 3. Setup RecyclerView Rekomendasi (Vertikal)
        setupRekomendasiRecyclerView(view)

        // 4. Memuat Data
        loadKategoriData()
        loadRekomendasiData()
    }

    // ===================================================
    // FUNGSIONALITAS HELPER (Lebih mudah dipahami)
    // ===================================================

    // Fungsi 1: Membuat instance Adapter
    private fun initAdapters() {
        // Membuat Adapter. Jika Adapter Anda memerlukan Lambda, masukkan di sini.
        // Contoh:
        kategoriAdapter = KategoriAdapter { kategori ->
            // Aksi yang terjadi saat kategori diklik
            println("Kategori ${kategori.nama} diklik!")
        }
        rekomendasiAdapter = ResepAdapter { resep ->
            // Aksi yang terjadi saat resep direkomendasikan diklik
            println("Resep ${resep.nama} diklik!")
        }
    }

    // Fungsi 2: Mengatur Tampilan RecyclerView Kategori
    private fun setupKategoriRecyclerView(view: View) {
        val rvHorizontal: RecyclerView = view.findViewById(R.id.recyclerViewHorizontal)
        rvHorizontal.apply {
            // Mengatur tata letak horizontal
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            // Menghubungkan Adapter ke RecyclerView
            adapter = kategoriAdapter
        }
    }

    // Fungsi 3: Mengatur Tampilan RecyclerView Rekomendasi
    private fun setupRekomendasiRecyclerView(view: View) {
        val rvRekomendasi: RecyclerView = view.findViewById(R.id.recyclerViewRekomendasi)
        rvRekomendasi.apply {
            // Mengatur tata letak vertikal
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            // Penting: nestedScrollingEnabled=false karena sudah di dalam ScrollView
            adapter = rekomendasiAdapter
        }
    }

    // Fungsi 4: Memuat Data Kategori (dipisahkan dari setup tampilan)
    private fun loadKategoriData() {
        // Mendapatkan data dari Repository (sumber data)
        val listKategori = KategoriRepository.getAllKategori()
        // Mengirimkan data ke Adapter untuk ditampilkan
        kategoriAdapter.submitList(listKategori)
    }

    // Fungsi 5: Memuat Data Rekomendasi Resep (dipisahkan dari setup tampilan)
    private fun loadRekomendasiData() {
        // Mendapatkan data dari Repository (sumber data)
        val listRekomendasi = ResepRepository.getAllResep()
        // Mengirimkan data ke Adapter untuk ditampilkan
        rekomendasiAdapter.submitList(listRekomendasi)
    }
}