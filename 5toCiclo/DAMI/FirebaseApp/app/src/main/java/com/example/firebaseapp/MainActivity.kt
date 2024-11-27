package com.example.firebaseapp

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firebaseapp.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var listaNombres: MutableList<String>
    val db= Firebase.firestore
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
        listaNombres = mutableListOf()
        binding.btnInsertar.setOnClickListener{

            val nombres = binding.etNombres.text.toString()
            val apellidos = binding.etApellidos.text.toString()
            val dni = binding.etDNI.text.toString()
            //Falta validar que no esten vacios
            InsertarData(nombres, apellidos, dni)
            MostrarData()
        }
    }

    private fun InsertarData(pNombres: String, pApellidos: String, pDNI: String){

        // Create a new user with a first and last name
        val user = hashMapOf(
            "Apellidos" to pApellidos,
            "DNI" to pDNI,
            "Nombres" to pNombres
        )

// Add a new document with a generated ID
        db.collection("Empleado")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(baseContext, "Agregado correctamente", Toast.LENGTH_LONG).show()
            }
            .addOnFailureListener { e ->
                Toast.makeText(baseContext, "No se pudo agregar. Intente luego.", Toast.LENGTH_LONG).show()
            }
    }

    private fun MostrarData(){

        db.collection("Empleado")
            .get()
            .addOnSuccessListener { result ->
                binding.pbCarga.visibility = View.VISIBLE
                for (document in result){
                    var apellidos = document.data.get("Apellidos").toString()
                    var nombres = document.data.get("Nombres").toString()
                    var nomape = nombres + " " + apellidos
                    listaNombres.add(nomape)
                }
                val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaNombres)
                binding.spEmpleados.adapter = adapter
                binding.pbCarga.visibility = View.GONE

            }
            .addOnFailureListener { e ->
                //Log.w(TAG, "Error adding document", e)
            }
    }
}