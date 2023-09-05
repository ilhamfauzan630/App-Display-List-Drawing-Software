package com.zanacademy.drawingsoftware

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zanacademy.drawingsoftware.databinding.ItemRowDrawingSoftwareBinding

class ListDrawingSoftwareAdapter(private val listSoftware: ArrayList<DrawingSoftware>) : RecyclerView.Adapter<ListDrawingSoftwareAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(var binding: ItemRowDrawingSoftwareBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowDrawingSoftwareBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listSoftware.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listSoftware[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listSoftware[holder.adapterPosition]) }

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailSoftware::class.java)
            intentDetail.putExtra("key_drawing_software", listSoftware[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DrawingSoftware)
    }
}