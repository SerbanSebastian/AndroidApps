package com.example.countriesapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.countriesapplication.databinding.RecyclerViewBinding
import com.example.countriesapplication.model.Country

class BasicAdapter(
  private val countries: MutableList<Country>,
) : RecyclerView.Adapter<BasicAdapter.NewViewHolder>() {


  inner class NewViewHolder(val binding: RecyclerViewBinding) :
    RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    init {
      binding.imageViewThis.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
      return
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
    val binding =
      RecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    return NewViewHolder(binding)
  }

  override fun getItemCount(): Int {
    return countries.size
  }

  override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
    Glide.with(holder.binding.imageViewThis.context)
      .load(countries[position].flags.png)
      .into(holder.binding.imageViewThis)
    holder.binding.textViewThis.text = "Country:${countries[position].name.official}\n Region:${countries[position].region}"
  }
}