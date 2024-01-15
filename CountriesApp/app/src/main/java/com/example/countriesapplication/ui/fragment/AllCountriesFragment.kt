package com.example.countriesapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.countriesapplication.adapter.BasicAdapter
import com.example.countriesapplication.databinding.FragmentAllCountriesBinding
import com.example.countriesapplication.databinding.FragmentMainBinding
import com.example.countriesapplication.model.Country
import com.example.countriesapplication.resource.CountryResource
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class AllCountriesFragment : Fragment() {
  private var parentBinding: FragmentAllCountriesBinding? = null
  private val binding get() = parentBinding!!
  lateinit var countries: List<Country>

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstance: Bundle?
  ): View {
    parentBinding = FragmentAllCountriesBinding.inflate(inflater, container, false)
    return binding.root
  }

  private fun setupCountries(){
    val contentType = "application/json".toMediaType()
    val json = Json{
      ignoreUnknownKeys = true
      isLenient = true
      coerceInputValues = true
    }
    val retrofit: Retrofit = Retrofit.Builder()
      .baseUrl("https://restcountries.com/v3.1/all/")
      .addConverterFactory(json.asConverterFactory(contentType))
      .build()
    val countryApi = retrofit.create(CountryResource::class.java)
    lifecycleScope.launch(Dispatchers.IO){
      countries = countryApi.getAllCountries()
      withContext(Dispatchers.Main){
        binding.recyclerView.adapter = BasicAdapter(countries as MutableList<Country>)
        binding.recyclerView.layoutManager = GridLayoutManager(binding.recyclerView.context, 1)
        binding.recyclerView.setHasFixedSize(true)
      }
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    setupCountries()
  }
  override fun onDestroyView() {
    super.onDestroyView()
    parentBinding = null
  }
}