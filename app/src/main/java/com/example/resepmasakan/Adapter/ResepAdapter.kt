package com.example.resepmasakan.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resepmasakan.Models.Resep // Menggunakan model Resep
import com.example.resepmasakan.R

// Adapter Dasar: Menggunakan RecyclerView.Adapter dan menerima dataList di konstruktor.
class ResepAdapter(
    private var dataList: List<Resep>, // List yang akan ditampilkan
    private val onItemClick: (Resep) -> Unit // Fungsi klik item
) : RecyclerView.Adapter<ResepAdapter.ResepViewHolder>() {

    // 1. FUNGSI onCREATEViewHolder
    // Membuat tampilan item dari layout XML
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResepViewHolder {
        // Mengubah XML (R.layout.item_food) menjadi View nyata
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_food, parent, false)

        return ResepViewHolder(view)
    }

    // 2. FUNGSI GETItemCOUNT
    // Memberi tahu RecyclerView berapa banyak item yang harus ditampilkan
    override fun getItemCount(): Int {
        return dataList.size
    }

    // 3. FUNGSI onBINDViewHolder
    // Mengisi data ke dalam tampilan yang sudah dibuat
    override fun onBindViewHolder(holder: ResepViewHolder, position: Int) {
        val resep = dataList[position]
        holder.tampilkanData(resep)
    }

    // --- 4. Fungsi untuk memperbarui data ---
    // Dipanggil dari Fragment jika data perlu diubah/difilter
    fun updateData(newList: List<Resep>) {
        dataList = newList
        notifyDataSetChanged() // Memberitahu RecyclerView untuk menggambar ulang semua item
    }


    // --- ViewHolder Class: Menggunakan findViewById() ---
    inner class ResepViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Mendeklarasikan View (dideklarasikan di sini karena findViewById lambat)
        private val namaMakanan: TextView
        private val detailMetadata: TextView
        private val gambarMakanan: ImageView
        private val ratingTextView: TextView

        init {
            // Menghubungkan variabel dengan ID di item_food.xml menggunakan findViewById
            namaMakanan = itemView.findViewById(R.id.textViewNamaMakanan)
            detailMetadata = itemView.findViewById(R.id.textViewDetail)
            gambarMakanan = itemView.findViewById(R.id.imgMakanan)
            ratingTextView = itemView.findViewById(R.id.textViewRating)
        }

        fun tampilkanData(resep: Resep) {
            // Isi data ke View
            namaMakanan.text = resep.nama
            detailMetadata.text = resep.infoDurasiPorsi

            // Menampilkan Gambar
            gambarMakanan.setImageResource(resep.idGambar)

            ratingTextView.text = "★ ${resep.rating}"

            // Beri perintah klik
            itemView.setOnClickListener {
                onItemClick(resep)
            }
        }
    }
}