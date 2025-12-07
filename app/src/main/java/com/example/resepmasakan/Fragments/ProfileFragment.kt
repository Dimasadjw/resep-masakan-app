package com.example.resepmasakan.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs // Alat untuk menerima "paket"
import com.example.resepmasakan.R

/**
 * ProfileFragment adalah layar yang tugasnya menampilkan info profil pengguna.
 */
class ProfileFragment : Fragment() {

    // Siapkan "kunci" untuk membuka "paket" data yang datang ke sini.
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

        // --- Langkah 1: Buka "paket" dan ambil data email ---
        val emailLengkap = args.emailPengguna

        // --- Langkah 2: Ambil nama dari email ---
        // Mencari tanda '@' dan mengambil bagian pertama sebagai nama pengguna
        val namaPengguna = emailLengkap.split("@").first()

        // --- Langkah 3: Tampilkan nama dan email ke layar ---
        val textViewUntukNama: TextView = tampilan.findViewById(R.id.text_view_nama_pengguna)
        val textViewUntukEmail: TextView = tampilan.findViewById(R.id.text_view_email_pengguna)

        textViewUntukNama.text = namaPengguna
        textViewUntukEmail.text = emailLengkap
    }
}