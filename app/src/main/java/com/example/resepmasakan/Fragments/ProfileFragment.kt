package com.example.resepmasakan.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView // Import TextView yang dibutuhkan
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.resepmasakan.R // Import R class untuk ID resource

/**
 * ProfileFragment adalah layar yang tugasnya menampilkan info profil pengguna.
 */
class ProfileFragment : Fragment() {

    // 1. Hapus semua deklarasi View Binding

    // Menggunakan navArgs untuk mendeklarasikan Argumen
    private val args: ProfileFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { // Kembalikan ke View? karena ini adalah cara tradisional

        // 2. INFLATE LAYOUT MENGGUNAKAN CARA TRADISIONAL
        val tampilan = inflater.inflate(R.layout.activity_profile, container, false)
        return tampilan
    }

    override fun onViewCreated(tampilan: View, savedInstanceState: Bundle?) {
        super.onViewCreated(tampilan, savedInstanceState)

        val emailLengkap = args.emailPengguna
        val namaPengguna = emailLengkap.split("@").first()

        // 3. AKSES VIEW MENGGUNAKAN findViewById()
        // Pastikan Anda menggunakan ID View yang benar dari activity_profile.xml
        val textViewUntukNama: TextView = tampilan.findViewById(R.id.textViewNamaPengguna)
        val textViewUntukEmail: TextView = tampilan.findViewById(R.id.textViewEmailPengguna)

        // 4. Tampilkan data
        textViewUntukNama.text = namaPengguna
        textViewUntukEmail.text = emailLengkap
    }

    // 5. Hapus onDestroyView karena tidak ada binding yang perlu dibersihkan
    // Kode ini sudah bersih tanpa menggunakan View Binding
}