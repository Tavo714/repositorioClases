package com.example.demorecyclerview

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demorecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    //lateinit var empleados: MutableList<String>
    lateinit var empleados: MutableList<Empleado>
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
        /*
        empleados= mutableListOf("Juan Perez",
                                 "Marcos Paredes",
                                 "Elena Rojas",
                                 "Luis Valverde",
                                 "Pedro Fuentes",
                                 "Carlos Contreras",
                                 "Hugo Rodriguez",
                                 "Karla Mendez",
                                 "Saul Torres")
         */
        val emp1=Empleado("Juan Perez", "jperez44@gmail.com", "+51968685987", R.drawable.emp1)
        val emp2=Empleado("Ana Torres", "atorres123@gmail.com", "+51968520987", R.drawable.emp2)
        val emp3=Empleado("Luis Paredes", "lparedes125@gmail.com", "+51969515987", R.drawable.emp4)
        val emp4=Empleado("Lucia Lopez", "llopez789@gmail.com", "+51964565987", R.drawable.emp3)
        val emp5=Empleado("Lucia Lopez", "llopez789@gmail.com", "+51964565987", R.drawable.emp3)
        val emp6=Empleado("Lucia Lopez", "llopez789@gmail.com", "+51964565987", R.drawable.emp3)
        val emp7=Empleado("Lucia Lopez", "llopez789@gmail.com", "+51964565987", R.drawable.emp3)
        val emp8=Empleado("Lucia Lopez", "llopez789@gmail.com", "+51964565987", R.drawable.emp3)
        val emp9=Empleado("Lucia Lopez", "llopez789@gmail.com", "+51964565987", R.drawable.emp3)
        val emp10=Empleado("Juan Perez", "jperez44@gmail.com", "+51968685987", R.drawable.emp1)
        empleados= mutableListOf(emp1, emp2, emp3, emp4, emp5, emp6, emp7, emp8, emp9, emp10)
        val adapter= AdapterRvEmpleados(this, empleados)
        binding.rvEmpleados.layoutManager= LinearLayoutManager(this)
        binding.rvEmpleados.adapter= adapter
    }
}