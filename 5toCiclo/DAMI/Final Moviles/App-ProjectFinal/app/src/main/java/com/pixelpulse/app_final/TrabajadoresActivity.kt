package com.pixelpulse.app_final

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.pixelpulse.app_final.Model.Empleados
import com.pixelpulse.app_final.adapter.EmpleadoAdapter
import com.pixelpulse.app_final.databinding.ActivityTrabajadoresBinding

class TrabajadoresActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTrabajadoresBinding
    private lateinit var firestore: FirebaseFirestore
    private lateinit var adapter: EmpleadoAdapter
    private val listaEmpleados = mutableListOf<Empleados>()
    private val listaCompleta = mutableListOf<Empleados>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrabajadoresBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firestore = FirebaseFirestore.getInstance()

        // Configurar RecyclerView
        binding.recyclerViewTrabajadores.layoutManager = LinearLayoutManager(this)
        adapter = EmpleadoAdapter(
            context = this,
            empleados = listaEmpleados,
            onViewClick = { verTrabajador(it) },
            onEditClick = { editarTrabajador(it) },
            onDeleteClick = { eliminarTrabajador(it) }
        )
        binding.recyclerViewTrabajadores.adapter = adapter

        cargarEmpleados()

        // Configurar búsqueda
        binding.btnBuscarDni.setOnClickListener { buscarTrabajadorPorDni() }
        binding.btnCancelarBusqueda.setOnClickListener { limpiarBusqueda() }

        binding.btnAgregarTrabajador.setOnClickListener {
            startActivity(Intent(this, CrearTrabajadorActivity::class.java))
        }

        binding.btnVolver.setOnClickListener { finish() }
    }

    override fun onResume() {
        super.onResume()
        cargarEmpleados() // Recarga la lista cada vez que se reanuda la actividad
    }

    private fun cargarEmpleados() {
        firestore.collection("empleados")
            .whereEqualTo("estado", "activo")
            .orderBy("nombre")
            .get()
            .addOnSuccessListener { snapshot ->
                listaCompleta.clear()
                listaCompleta.addAll(snapshot.documents.mapNotNull { it.toObject(Empleados::class.java) })
                listaEmpleados.clear()
                listaEmpleados.addAll(listaCompleta)
                adapter.notifyDataSetChanged()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error al cargar empleados", Toast.LENGTH_SHORT).show()
            }
    }

    private fun buscarTrabajadorPorDni() {
        val dni = binding.edtBuscarDni.text.toString().trim()
        if (!dni.matches(Regex("^\\d{8}$"))) {
            binding.tilBuscarDni.error = "DNI inválido (8 dígitos numéricos)."
            return
        } else {
            binding.tilBuscarDni.error = null
        }

        val resultado = listaCompleta.filter { it.dni == dni }
        if (resultado.isEmpty()) {
            Toast.makeText(this, "DNI no encontrado", Toast.LENGTH_SHORT).show()
        } else {
            listaEmpleados.clear()
            listaEmpleados.addAll(resultado)
            adapter.notifyDataSetChanged()
        }
    }

    private fun limpiarBusqueda() {
        binding.edtBuscarDni.text?.clear()
        binding.tilBuscarDni.error = null
        listaEmpleados.clear()
        listaEmpleados.addAll(listaCompleta)
        adapter.notifyDataSetChanged()
    }

    private fun verTrabajador(trabajador: Empleados) {
        val intent = Intent(this, DetalleTrabajadorActivity::class.java).apply {
            putExtra("trabajador_dni", trabajador.dni)
            putExtra("trabajador_nombre", trabajador.nombre)
            putExtra("trabajador_apellido", trabajador.apellido)
            putExtra("trabajador_fechNac", trabajador.fechNac)
            putExtra("trabajador_fechIng", trabajador.fechIng)
            putExtra("trabajador_puesto", trabajador.puesto)
        }
        startActivity(intent)
    }

    private fun editarTrabajador(trabajador: Empleados) {
        val intent = Intent(this, EditarTrabajadorActivity::class.java).apply {
            putExtra("trabajador_dni", trabajador.dni)
        }
        startActivity(intent)
    }

    private fun eliminarTrabajador(trabajador: Empleados) {
        // Crear el modal de confirmación
        androidx.appcompat.app.AlertDialog.Builder(this)
            .setTitle("Confirmar eliminación")
            .setMessage("¿Está seguro de que desea eliminar al trabajador ${trabajador.nombre}?")
            .setPositiveButton("Eliminar") { _, _ ->
                // Lógica de eliminación solo si el usuario confirma
                firestore.collection("empleados")
                    .whereEqualTo("dni", trabajador.dni)
                    .get()
                    .addOnSuccessListener { snapshot ->
                        snapshot.documents.firstOrNull()?.reference?.update("estado", "inactivo")
                            ?.addOnSuccessListener {
                                Toast.makeText(this, "Trabajador eliminado", Toast.LENGTH_SHORT).show()
                                cargarEmpleados()
                            }
                            ?.addOnFailureListener {
                                Toast.makeText(this, "Error al eliminar trabajador", Toast.LENGTH_SHORT).show()
                            }
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "No se pudo encontrar al trabajador", Toast.LENGTH_SHORT).show()
                    }
            }
            .setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss() // Cierra el diálogo sin hacer nada
            }
            .show()
    }

}



