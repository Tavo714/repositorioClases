package com.example.listaretrofitapi.Servicios

import com.example.listaretrofitapi.Model.Pais
import retrofit2.Response
import retrofit2.http.GET

interface ApiCliente {

    @GET("countries")
    suspend fun listarPaises(): Response<MutableList<Pais>>
}