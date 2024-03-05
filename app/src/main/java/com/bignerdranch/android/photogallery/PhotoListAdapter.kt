package com.bignerdranch.android.photogallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import api.GalleryItem
import coil.load
import com.bignerdranch.android.photogallery.databinding.ListItemGalleryBinding

class PhotoViewHolder(
    private val binding: ListItemGalleryBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(galleryItem: GalleryItem, onItemClicked: (itemTitle: String?, itemAuthor: String?, itemUrlToImage: String?, itemContent: String?) -> Unit) {
        if (galleryItem.urlToImage == null) {
            binding.itemImageView.load(R.drawable.ic_launcher_foreground) {
            }
        } else {
            binding.itemImageView.load(galleryItem.urlToImage) {
                placeholder(R.drawable.ic_launcher_foreground)
            }
        }
        binding.root.setOnClickListener {
            onItemClicked(galleryItem.title, galleryItem.author, galleryItem.urlToImage, galleryItem.content)
        }

    }
}

class PhotoListAdapter(
    private val galleryItems: List<GalleryItem>,
    private val onItemClicked: (itemTitle: String?, itemAuthor: String?, itemUrlToImage: String?, itemContent: String?) -> Unit
) : RecyclerView.Adapter<PhotoViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = galleryItems[position]

//        holder.itemView.setOnClickListener {
//            val clickedItem = galleryItems[position]
//        }

        holder.bind(item, onItemClicked)
    }
    override fun getItemCount() = galleryItems.size
}
