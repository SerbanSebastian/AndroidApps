package com.example.countriesapplication.model

import kotlinx.serialization.Serializable

@Serializable
data class Country(
  val name: Name,
  val unMember: Boolean,
  val region: String,
  val latlng: List<Double>,
  val landlocked: Boolean,
  val area: Double,
  val flag: String,
  val population: Int,
  val timezones: List<String>,
  val continents: List<String>,
  val flags: Flags
)

@Serializable
data class Name(
  val common: String,
  val official: String
)

@Serializable
data class Flags(
  val png: String,
  val svg: String
)