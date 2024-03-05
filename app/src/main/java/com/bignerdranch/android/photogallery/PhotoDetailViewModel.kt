package com.bignerdranch.android.photogallery

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import api.GalleryItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PhotoDetailViewModel (itemTitle: String?, itemAuthor: String?, itemUrlToImage: String?, itemContent: String?) : ViewModel() {
    private val photoRepository = PhotoRepository()
    private val _galleryItems: MutableStateFlow<List<GalleryItem>> =
        MutableStateFlow(emptyList())
    val galleryItems: StateFlow<List<GalleryItem>>
        get() = _galleryItems.asStateFlow()
    init {
        viewModelScope.launch {
            try {
                val items = photoRepository.fetchPhotos()
                Log.d("Items received:", "T")
                _galleryItems.value = items
            } catch (ex: Exception) {
                Log.e("Failed to fetch gallery items", "E")
            }
        }
    }
}

class PhotoDetailViewModelFactory(
    private val itemTitle: String?,
    private val itemAuthor: String?,
    private val itemUrlToImage: String?,
    private val itemContent: String?
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PhotoDetailViewModel(itemTitle, itemAuthor, itemUrlToImage, itemContent) as T
    }
}
