package com.example.paiseswebservice.Service

import com.example.paiseswebservice.Modelo.PaisesResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("countries")//Aqui va el Endpoint que completa la URL del API
    fun listarPaises(): Call<PaisesResponse>
}