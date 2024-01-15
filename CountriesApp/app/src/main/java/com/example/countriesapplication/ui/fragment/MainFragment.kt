package com.example.countriesapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.countriesapplication.R
import com.example.countriesapplication.databinding.FragmentMainBinding

class MainFragment : Fragment(){
  private var parentBinding: FragmentMainBinding? = null
  private val binding get()= parentBinding!!

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    parentBinding = FragmentMainBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.buttonToAllCountriesFragment.setOnClickListener{
      findNavController().navigate(R.id.action_main_fragment_to_all_countries_fragment)
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    parentBinding = null
  }
}