package com.example.spinnerdemo

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.spinnerdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var arrayPaises = arrayOf("")
    lateinit var arregloPaises: Array<String>
    lateinit var arrayListPaises: ArrayList<String>
    var listaPaises= listOf("")
    lateinit var listapaises: List<String>
    lateinit var paisesListaMutable: MutableList<String>
    lateinit var ListaEdades: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        arregloPaises = arrayOf("Francia", "Italia", "España", "Rusia")
        arrayListPaises= arrayListOf("Japon", "China", "Singapur", "EEUU")
        listaPaises= listOf("Mexico", "Canada", "Brasil", "Uruguay")
        arrayPaises = arrayOf("Selecciona un pais","Peru", "Ecuador", "Chile", "Argentina")
        paisesListaMutable= mutableListOf()
        paisesListaMutable.add("Venezuela")
        paisesListaMutable.add("Paraguay")
        ListaEdades= arrayListOf()
        ListaEdades.add("Seleccione una edad")
        ListaEdades.add("45")
        ListaEdades.add("26")
        ListaEdades.add("19")
        arregloPaises.set(3, "Afganistan")
        arregloPaises.plus("Asutralia")
        arregloPaises.sort()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arregloPaises)
        binding.spPaises.adapter = adapter
    }
}