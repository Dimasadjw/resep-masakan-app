package com.example.resepmasakan.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.resepmasakan.R

/**
 * ProfileFragment adalah layar yang tugasnya menampilkan info profil pengguna.
 */
class ProfileFragment : Fragment() {

    // Menggunakan navArgs untuk mendeklarasikan bahwa Fragment ini menerima Argumen.
    // Tipe ini dibuat otomatis (ProfileFragmentArgs).
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

        // --- Langkah 1: Ambil data email dari Argumen Navigasi ---
        val emailLengkap = args.emailPengguna // Mengambil Argumen yang dikirim dari MainActivity

        // --- Langkah 2: Proses email menjadi nama pengguna ---
        // Mencari tanda '@' dan mengambil bagian pertamanya
        val namaPengguna = emailLengkap.split("@").first()

        // --- Langkah 3: Hubungkan dengan TextView di layout (activity_profile.xml) ---
        // ID disesuaikan agar cocok dengan layout baru:
        val textViewUntukNama: TextView = tampilan.findViewById(R.id.textViewNamaPengguna)
        val textViewUntukEmail: TextView = tampilan.findViewById(R.id.textViewEmailPengguna)

        // --- Langkah 4: Tampilkan data ---
        textViewUntukNama.text = namaPengguna
        textViewUntukEmail.text = emailLengkap
    }
}