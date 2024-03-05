package com.bignerdranch.android.photogallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import api.GalleryItem
import coil.load
import com.bignerdranch.android.photogallery.databinding.FragmentListItemDetailBinding
import kotlinx.coroutines.launch


class PhotoDetailFragment: Fragment() {
    private var _binding: FragmentListItemDetailBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

//    private val photoGalleryViewModel: PhotoGalleryViewModel by viewModels()
    private val args: PhotoDetailFragmentArgs by navArgs()
//    private val photoDetailViewModel: PhotoDetailViewModel by viewModels {
//        PhotoDetailViewModelFactory(args.itemTitle, args.itemAuthor, args.itemContent)
//    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentListItemDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        viewLifecycleOwner.lifecycleScope.launch {
//            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
//                photoDetailViewModel.galleryItems.collect { items ->
//                    items?.let { updateUi(it) }
//                }
//            }
//        }
        val title : TextView = view.findViewById(R.id.itemTitle)
        title.text = args.itemTitle
        val author : TextView = view.findViewById(R.id.itemAuthor)
        author.text = args.itemAuthor
        binding.itemUrlToImage.load(args.itemUrlToImage)
        val content : TextView = view.findViewById(R.id.itemContent)
        content.text = args.itemContent

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}