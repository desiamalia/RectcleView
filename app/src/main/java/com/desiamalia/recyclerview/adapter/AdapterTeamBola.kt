package com.desiamalia.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.desiamalia.recyclerview.databinding.ListItemPemainBinding
import com.desiamalia.recyclerview.model.Pemain

class AdapterTeamBola(private val context : Context,
                      private val data : List<Pemain>?,
                      private val itemclick : OneClickListener)
                : RecyclerView.Adapter<AdapterTeamBola.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListItemPemainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?: 0)
        holder.nama.text = item?.nama
        holder.itemView.setOnClickListener {
            itemclick.detailData(item)
        }
    }

    override fun getItemCount(): Int = data?.size ?: 0

    inner class ViewHolder(val binding: ListItemPemainBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val foto = binding.image
        val nama = binding.txtnama
    }
    interface OneClickListener {
        fun detailData(item : Pemain)
    }
}