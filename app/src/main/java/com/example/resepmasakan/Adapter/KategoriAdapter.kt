package com.example.resepmasakan.adapters

// Import yang dibutuhkan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.resepmasakan.R
import com.example.resepmasakan.Models.Category

class KategoriAdapter(
    private var dataList: List<Category>,
    private val onItemClick: (Category) -> Unit
) : RecyclerView.Adapter<KategoriAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryIcon: ImageView = itemView.findViewById(R.id.imageViewKategori)
        val categoryName: TextView = itemView.findViewById(R.id.textViewKategori)

        fun bind(category: Category) {
            categoryName.text = category.nama
            categoryIcon.setImageResource(category.idIcon)

            itemView.setOnClickListener {
                onItemClick(category)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_category_food, parent, false
        )
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun submitList(newList: List<Category>) {
        dataList = newList
        notifyDataSetChanged()
    }
}