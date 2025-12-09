package com.example.resepmasakan.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.resepmasakan.R

/**
 * ProfileFragment adalah layar yang tugasnya menampilkan info profil pengguna, termasuk deskripsi.
 */
class ProfileFragment : Fragment() {

    // Menggunakan navArgs untuk mendeklarasikan Argumen
    private val args: ProfileFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val tampilan = inflater.inflate(R.layout.activity_profile, container, false)
        return tampilan
    }

    override fun onViewCreated(tampilan: View, savedInstanceState: Bundle?) {
        super.onViewCreated(tampilan, savedInstanceState)

        val emailLengkap = args.emailPengguna
        val namaPengguna = emailLengkap.split("@").first()

        // ⭐ Data untuk Deskripsi (Contoh hardcoded)
        val deskripsiPengguna = "Saya seorang koki amatir yang bersemangat mencari resep masakan Indonesia dan Barat terbaik."

        // AKSES VIEWS
        val textViewUntukNama: TextView = tampilan.findViewById(R.id.textViewNamaPengguna)
        val textViewUntukEmail: TextView = tampilan.findViewById(R.id.textViewEmailPengguna)
        val imageViewFotoProfil: ImageView = tampilan.findViewById(R.id.profileImage)

        // ⭐ AKSES TextView Deskripsi yang Baru
        val textViewDeskripsi: TextView = tampilan.findViewById(R.id.textViewDeskripsi)

        // Tampilkan data ke TextViews
        textViewUntukNama.text = namaPengguna
        textViewUntukEmail.text = emailLengkap

        // ⭐ Tampilkan Deskripsi
        textViewDeskripsi.text = deskripsiPengguna

        // Set gambar profil
        imageViewFotoProfil.setImageResource(R.drawable.bahlil)
    }
}