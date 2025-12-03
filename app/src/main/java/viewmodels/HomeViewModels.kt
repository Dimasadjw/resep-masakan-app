// Lokasi: com.example.resepmasakan.viewmodels/HomeViewModel.kt

package com.example.resepmasakan.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.resepmasakan.Models.Resep // Mengimpor Resep dari folder Models

class HomeViewModel : ViewModel() {

    // LiveData yang akan menyediakan daftar resep ke Fragment
    private val _daftarResep = MutableLiveData<List<Resep>>()
    val daftarResep: LiveData<List<Resep>> = _daftarResep

    init {
        // Panggil fungsi untuk mengisi data dummy saat ViewModel dibuat
        loadResepAwal()
    }

    private fun loadResepAwal() {
        // Contoh Data Resep Dummy
        val dataContoh = listOf(
            Resep(
                id = 1,
                nama = "Nasi Goreng Sederhana",
                deskripsiSingkat = "Resep nasi goreng untuk pemula, cepat dan lezat.",
                waktuMemasak = "15 Menit",
                valImageUrl = "" // Isi dengan URL gambar jika Anda menggunakan internet
            ),
            Resep(
                id = 2,
                nama = "Telur Dadar Sayur",
                deskripsiSingkat = "Telur dadar dengan tambahan sayuran sehat.",
                waktuMemasak = "10 Menit",
                valImageUrl = ""
            )
        )
        // Set nilai LiveData
        _daftarResep.value = dataContoh
    }
}