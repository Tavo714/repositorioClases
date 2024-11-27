package com.example.listaretrofitapi.Model

import com.google.gson.annotations.SerializedName

data class Pais(
    @SerializedName("Name") val Nombre: String,
    @SerializedName("Capital") val Capital: String,
    @SerializedName("Continent") val Continente: String,
    @SerializedName("Flag") val Bandera: String
)
