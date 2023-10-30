package com.desafio.apiphotos.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.desafio.apiphotos.databinding.PhotosListItemBinding
import com.desafio.apiphotos.model.dto.PhotosDTO
import com.squareup.picasso.Picasso

class PhotosAdapter:RecyclerView.Adapter<PhotosAdapter.PhotosItemViewHolder>() {

    var photosList:List<PhotosDTO> = mutableListOf()

    class PhotosItemViewHolder(val binding: PhotosListItemBinding): RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotosAdapter.PhotosItemViewHolder {
        val binding = PhotosListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return PhotosItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotosAdapter.PhotosItemViewHolder, position: Int) {
        val photos = photosList[position]
        Picasso.get()
            .load(photos.url)
            .into(holder.binding.photoImageView)

        holder.binding.titleTextView.text= photos.title
    }

    override fun getItemCount(): Int {
        return photosList.size
    }

    fun updateList(list: List<PhotosDTO>){
        photosList = list
        notifyDataSetChanged()
    }
}