package com.example.countriesapplication.resource

import com.example.countriesapplication.model.Country
import retrofit2.http.GET

interface CountryResource {
  @GET("https://restcountries.com/v3.1/all")suspend fun getAllCountries() : MutableList<Country>
}