package com.example.paiseswebservice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.paiseswebservice.Modelo.Pais
import com.example.paiseswebservice.Modelo.PaisesResponse
import com.example.paiseswebservice.Retrofit.RetrofitHelper
import com.example.paiseswebservice.Service.ApiService
import com.example.paiseswebservice.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val apiServicio: ApiService = RetrofitHelper.retrofit.create<ApiService>(ApiService::class.java)

        val call: Call<PaisesResponse> = apiServicio.listarPaises()
        call.enqueue(object: Callback<PaisesResponse>{
            //ctrl + o para agregar los siguientes servicios:
            override fun onResponse(p0: Call<PaisesResponse>, p1: Response<PaisesResponse>) {
            
            }
            //ctrl + o
            override fun onFailure(p0: Call<PaisesResponse>, p1: Throwable) {

            }
        })
    }
}