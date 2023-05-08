package com.dayvatas.artbookkotlin

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dayvatas.artbookkotlin.databinding.RecyclerRowBinding

class ArtAdapter(val artList : ArrayList<Art>) : RecyclerView.Adapter<ArtAdapter.ArtHolder>() {
    class ArtHolder(val binding : RecyclerRowBinding): RecyclerView.ViewHolder(binding.root){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return artList.size
    }

    override fun onBindViewHolder(holder: ArtHolder, position: Int) {
        TODO("Not yet implemented")
    }
}