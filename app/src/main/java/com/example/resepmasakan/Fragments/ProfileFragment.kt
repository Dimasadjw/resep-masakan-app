package com.example.resepmasakan.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.resepmasakan.R

/**
 * ProfileFragment untuk menampilkan layar profil dan menangani navigasi
 * dari tombol-tombol yang ada di dalamnya.
 */
class ProfileFragment : Fragment() {

    /**
     * Metode ini dipanggil untuk membuat dan menampilkan tampilan (View) dari Fragment.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Mengubah (inflate) file layout fragment_profile.xml menjadi sebuah View.
        return inflater.inflate(R.layout.activity_profile, container, false)
    }

    /**
     * Metode ini dipanggil setelah tampilan (View) selesai dibuat.
     * Ini adalah tempat yang tepat untuk menambahkan listener pada komponen UI.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}