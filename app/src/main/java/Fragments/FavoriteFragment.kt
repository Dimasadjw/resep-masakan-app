package com.example.resepmasakan.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.resepmasakan.R

/**
 * FavoriteFragment bertanggung jawab untuk menampilkan layar favorit.
 * Versi ini hanya menampilkan layout dan menangani tombol kembali.
 */
class FavoriteFragment : Fragment() {

    /**
     * Metode ini dipanggil untuk membuat dan menampilkan tampilan (View) dari Fragment.
     * Ini adalah titik di mana file layout XML Anda dihubungkan ke Fragment.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Mengubah (inflate) file layout activity_favorite.xml menjadi sebuah View
        // yang dapat ditampilkan di layar.
        return inflater.inflate(R.layout.activity_favorite, container, false)
    }

    /**
     * Metode ini dipanggil setelah tampilan (View) selesai dibuat.
     * Tempat yang ideal untuk menambahkan listener pada tombol atau komponen UI lainnya.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Menemukan tombol kembali berdasarkan ID-nya di layout.
        val backButton: ImageButton = view.findViewById(R.id.back_button)

        // Menambahkan OnClickListener ke tombol. Saat tombol diklik,
        // kode di dalam blok lambda ini akan dieksekusi.
        backButton.setOnClickListener {
            // Menggunakan NavController untuk kembali ke layar sebelumnya dalam tumpukan navigasi.
            findNavController().navigateUp()
        }

        // Semua logika RecyclerView dan Adapter telah dihapus sesuai permintaan.
    }
}
