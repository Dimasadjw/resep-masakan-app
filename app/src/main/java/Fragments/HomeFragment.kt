package com.example.resepmasakan.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.resepmasakan.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /* * TITIK KONEKSI UTAMA
         * Fungsi ini mengambil layout XML (activity_home.xml)
         * dan mengembalikannya sebagai View yang akan diletakkan di dalam FrameLayout
         * di MainActivity.
         */

        // CATATAN: Menggunakan R.layout.activity_home sesuai permintaan,
        // meskipun R.layout.fragment_home lebih disarankan.
        return inflater.inflate(R.layout.activity_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Di sini Anda bisa menambahkan kode findViewById() atau logika UI lainnya.
        // val judul: TextView = view.findViewById(R.id.textViewJudul)
        // ...
    }
}