package com.example.spinnerpaisesbanderas

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.spinnerpaisesbanderas.Adapter.ItemAdapter
import com.example.spinnerpaisesbanderas.Model.Pais
import com.example.spinnerpaisesbanderas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var listaPaises: MutableList<Pais>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        listaPaises= mutableListOf()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        listaPaises.add(Pais("Peru", R.drawable.peru))
        listaPaises.add(Pais("Francia", R.drawable._25972_flag_france_icon))
        listaPaises.add(Pais("Italia", R.drawable.italia))
        listaPaises.add(Pais("Ecuador", R.drawable._0233_ecuador_flag_icon))
        listaPaises.add(Pais("USA", R.drawable.usa))

        val adapter= ItemAdapter(this, listaPaises)

        binding.spPaises.adapter= adapter
    }
}