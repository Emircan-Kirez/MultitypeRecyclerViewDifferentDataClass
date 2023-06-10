package com.emircankirez.multityperecyclerviewdifferentdataclass.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emircankirez.multityperecyclerviewdifferentdataclass.model.Model
import com.emircankirez.multityperecyclerviewdifferentdataclass.model.ItemType
import com.emircankirez.multityperecyclerviewdifferentdataclass.databinding.AdRowBinding
import com.emircankirez.multityperecyclerviewdifferentdataclass.databinding.FilmRowBinding

class ItemAdapter(private val itemList : ArrayList<Model>, private val listener : OnItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    class FilmHolder(private val binding : FilmRowBinding, private val listener: OnItemClickListener) : RecyclerView.ViewHolder(binding.root){
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION)
                    listener.onItemClick(position)
            }
        }

        fun bind(item : Model.Film){
            binding.apply {
                tvTitle.text = item.title
                tvContent.text = item.content
                ratingBar.rating = item.rate
            }
        }
    }

    class AdHolder(private val binding: AdRowBinding, private val listener: OnItemClickListener) : RecyclerView.ViewHolder(binding.root){
        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION)
                    listener.onItemClick(position)
            }
        }

        fun bind(item : Model.Ad){
            binding.ivAd.setImageResource(item.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            ItemType.FILM.ordinal -> {
                val binding = FilmRowBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                FilmHolder(binding, listener)
            }

            ItemType.AD.ordinal -> {
                val binding = AdRowBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                AdHolder(binding, listener)
            }
            else -> throw IllegalArgumentException("invalid viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(itemList[position]){
            is Model.Film -> {
                ItemType.FILM.ordinal
            }

            is Model.Ad -> {
                ItemType.AD.ordinal
            }
        }
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = itemList[position]
        when(item){
            is Model.Film -> {
                (holder as FilmHolder).bind(item as Model.Film)
            }

            is Model.Ad -> {
                (holder as AdHolder).bind(item as Model.Ad)
            }
        }
    }
}