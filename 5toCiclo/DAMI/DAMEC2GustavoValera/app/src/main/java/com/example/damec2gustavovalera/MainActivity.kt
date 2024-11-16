package com.example.damec2gustavovalera

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.damec2gustavovalera.Adapter.ItemAdapter
import com.example.damec2gustavovalera.Model.Empleado
import com.example.damec2gustavovalera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var puestos: List<String>
    private lateinit var listaEmpleados: List<Empleado>
    private var empleadosFiltrados: MutableList<Empleado> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        puestos = listOf("Seleccione un puesto", "Gerente", "Secretaria", "Asistente", "Supervisor", "Contador", "Programador", "Analista")
        listaEmpleados = listOf(
            Empleado("Gustavo", "Valera", "77777777", "25/05/1986", "Gerente"),
            Empleado("Sofia", "Goicochea", "11111111", "03/07/2001", "Analista"),
            Empleado("Laura", "Fernandez", "44444444", "26/04/2000", "Analista"),
            Empleado("Jose", "Leandro", "55555555", "01/12/1995", "Analista"),
            Empleado("Luis", "Martinez", "22222222", "15/09/1998", "Programador"),
            Empleado("Pedro", "Leon", "66666666", "15/08/2004", "Programador"),
            Empleado("Felipe", "Hurtado", "88888888", "21/11/1991", "Programador"),
            Empleado("Luis", "Martinez", "22222222", "15/09/1998", "Programador"),
            Empleado("Luisa", "Zavala", "99999999", "02/02/1981", "Secretaria"),
            Empleado("Jessica", "Clavijo", "11112222", "24/06/2002", "Secretaria"),
            Empleado("Gabriela", "Jimenez", "11113333", "15/10/2000", "Asistente"),
            Empleado("Juan", "Quispe", "11114444", "13/10/2002", "Asistente"),
            Empleado("Jessica", "Clavijo", "11112222", "24/06/2004", "Asistente"),
            Empleado("Andres", "Velasco", "11115555", "03/03/1995", "Supervisor"),
            Empleado("Roberto", "Aguila", "11116666", "17/09/1991", "Supervisor"),
            Empleado("Ana", "Perez", "33333333", "21/12/1990", "Contador")
        )

        val adapterPuestos = ArrayAdapter(this, android.R.layout.simple_spinner_item, puestos)
        binding.spPuestos.adapter = adapterPuestos

        binding.spPuestos.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position > 0) {
                    val nombrePuesto = puestos[position]
                    filtrarEmpleadosPorPuesto(nombrePuesto)
                } else {
                    empleadosFiltrados.clear()
                }
                empleadosFiltrados.add(0, Empleado("Seleccione un empleado", "", "", "", ""))
                actualizarSpinnerEmpleados()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.spEmpleados.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (empleadosFiltrados.isNotEmpty() && position > 0) {
                    mostrarDatosEmpleado(empleadosFiltrados[position])
                } else {
                    limpiarDatosEmpleado()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun filtrarEmpleadosPorPuesto(puesto: String) {
        empleadosFiltrados = listaEmpleados.filter { it.puesto == puesto }.toMutableList()
    }

    private fun actualizarSpinnerEmpleados() {
        val adapterEmpleados = ItemAdapter(this, empleadosFiltrados)
        binding.spEmpleados.adapter = adapterEmpleados
    }

    private fun mostrarDatosEmpleado(empleado: Empleado) {
        binding.tvNombres.text = "Nombres: ${empleado.nombre}"
        binding.tvApellidos.text = "Apellidos: ${empleado.apellido}"
        binding.tvDni.text = "DNI: ${empleado.dni}"
        binding.tvNacimiento.text = "Nacimiento: ${empleado.nacimiento}"
        binding.tvPuesto.text = "Puesto: ${empleado.puesto}"
    }

    private fun limpiarDatosEmpleado() {
        binding.tvNombres.text = "Nombres:"
        binding.tvApellidos.text = "Apellidos:"
        binding.tvDni.text = "DNI:"
        binding.tvNacimiento.text = "Nacimiento:"
        binding.tvPuesto.text = "Puesto:"
    }
}
