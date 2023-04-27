package com.dayvatas.artbookkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dayvatas.artbookkotlin.databinding.ActivityArtDetailBinding

class ArtDetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityArtDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun selectImage(){

    }

    fun saveClicked(){

    }
}