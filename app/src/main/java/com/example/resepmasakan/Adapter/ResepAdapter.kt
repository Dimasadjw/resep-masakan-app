package com.example.resepmasakan.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resepmasakan.Models.Recipe
import com.example.resepmasakan.R

// Ini adalah adapter versi dasar, lebih mudah dipahami untuk pemula.
// Dia menerima 2 hal:
// 1. dataList: Daftar resep yang mau ditampilkan.
// 2. onItemClick: Perintah yang harus dijalankan kalau salah satu resep diklik.
class ResepAdapter(
    private var dataList: List<Recipe>,
    private val onItemClick: (Recipe) -> Unit
) : RecyclerView.Adapter<ResepAdapter.RecipeViewHolder>() {

    // 1. FUNGSI onCREATEViewHolder
    // Tugasnya cuma satu: Membuat tampilan (layout) untuk SATU item resep.
    // Fungsi ini dipanggil di awal-awal untuk menyiapkan beberapa "kerangka" item.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        // "Inflater" adalah alat untuk mengubah file XML (R.layout.item_food) menjadi tampilan nyata.
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food, parent, false)

        // Setelah tampilan jadi, kita masukkan ke dalam "kotak" ViewHolder.
        return RecipeViewHolder(view)
    }

    // 2. FUNGSI GETItemCOUNT
    // Tugasnya sangat sederhana: Memberi tahu RecyclerView ada berapa total resep yang mau ditampilkan.
    override fun getItemCount(): Int {
        return dataList.size // Kembalikan ukuran dari daftar resep kita.
    }

    // 3. FUNGSI onBINDViewHolder
    // Tugasnya adalah mengisi data resep ke dalam tampilan item yang sudah disiapkan.
    // "position" adalah urutan resep (resep ke-0, ke-1, ke-2, dst.).
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        // Ambil satu resep dari daftar kita berdasarkan urutannya.
        val resep = dataList[position]

        // Suruh "kotak" ViewHolder untuk menampilkan data resep ini.
        holder.tampilkanData(resep)
    }

    // Ini adalah "KOTAK" atau "WADAH" untuk setiap item di daftar.
    // Tugasnya memegang referensi ke setiap komponen UI (TextView, ImageView) di dalam satu item.
    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Kenalan dulu sama semua komponen di dalam file item_food.xml
        private val namaMakanan: TextView = itemView.findViewById(R.id.textViewNamaMakanan)
        private val detailMetadata: TextView = itemView.findViewById(R.id.textViewDetail)
        private val gambarMakanan: ImageView = itemView.findViewById(R.id.imgMakanan)
        private val ratingTextView: TextView = itemView.findViewById(R.id.textViewRating)

        // Ini fungsi untuk MENAMPILKAN DATA ke komponen-komponen di atas.
        // Saya ganti nama dari "bind" menjadi "tampilkanData" biar lebih jelas.
        fun tampilkanData(resep: Recipe) {
            // Isi nama makanan
            namaMakanan.text = resep.nama
            // Isi info durasi & porsi
            detailMetadata.text = resep.infoDurasiPorsi
            // Isi gambar dari drawable (pastikan idGambar adalah Int di model Recipe)
            gambarMakanan.setImageResource(resep.idGambar)
            // Isi rating
            ratingTextView.text = "★ ${resep.rating}"

            // Beri perintah "kalau diklik, lakukan ini" ke seluruh tampilan item.
            itemView.setOnClickListener {
                onItemClick(resep) // Jalankan perintah yang sudah diberikan dari luar.
            }
        }
    }
}
