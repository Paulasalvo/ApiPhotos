package com.desafio.apiphotos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.desafio.apiphotos.databinding.ActivityMainBinding
import com.desafio.apiphotos.model.dto.PhotosDTO
import com.desafio.apiphotos.view.PhotosAdapter
import com.desafio.apiphotos.view.PhotosListViewModel

class MainActivity : AppCompatActivity() {

    val photosListViewModel: PhotosListViewModel = PhotosListViewModel()
    lateinit var binding: ActivityMainBinding
    private val adapter = PhotosAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        photosListViewModel.fetchPhotosList()

        photosListViewModel.photosListLiveData.observe(this){
            adapter.photosList = it
            adapter.notifyDataSetChanged()
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }

}