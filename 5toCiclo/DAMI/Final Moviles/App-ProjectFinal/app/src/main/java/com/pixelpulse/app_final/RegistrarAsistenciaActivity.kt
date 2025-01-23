package com.pixelpulse.app_final

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.pixelpulse.app_final.Model.Empleados
import com.pixelpulse.app_final.adapter.EmpleadoAsistenciaAdapter
import com.pixelpulse.app_final.databinding.ActivityRegistrarAsistenciaBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

class RegistrarAsistenciaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrarAsistenciaBinding
    private lateinit var firestore: FirebaseFirestore
    private lateinit var adapter: EmpleadoAsistenciaAdapter

    // Obtener fecha y hora en la zona horaria de Lima, Perú
    private val fechaHoy: String
        get() {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            sdf.timeZone = TimeZone.getTimeZone("America/Lima") // Zona horaria de Lima
            return sdf.format(Date())
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarAsistenciaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firestore = FirebaseFirestore.getInstance()

        binding.recyclerViewEmpleados.layoutManager = LinearLayoutManager(this)

        adapter = EmpleadoAsistenciaAdapter(
            context = this,
            empleados = mutableListOf(),
            onCheckClick = { empleado, callback ->
                registrarAsistencia(empleado) { success ->
                    if (success) {
                        callback(true)
                    } else {
                        callback(false)
                    }
                }
            },
            onCancelCheckClick = { empleado -> cancelarAsistencia(empleado) }
        )

        binding.recyclerViewEmpleados.adapter = adapter

        crearSubcoleccionDeHoy()
        cargarEmpleados()

        binding.btnVolver.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }

    private fun crearSubcoleccionDeHoy() {
        firestore.collection("asistencia").document(fechaHoy)
            .get()
            .addOnSuccessListener { document ->
                if (!document.exists()) {
                    firestore.collection("asistencia").document(fechaHoy)
                        .set(hashMapOf("creado" to true))
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error al inicializar asistencia", Toast.LENGTH_SHORT).show()
            }
    }

    private fun cargarEmpleados() {
        firestore.collection("empleados")
            .whereEqualTo("estado", "activo")
            .get()
            .addOnSuccessListener { empleadosSnapshot ->
                val empleados = empleadosSnapshot.documents.mapNotNull { doc ->
                    val nombre = doc.getString("nombre") ?: "Desconocido"
                    val apellido = doc.getString("apellido") ?: "Sin Apellido"
                    val dni = doc.getString("dni") ?: return@mapNotNull null
                    val fechNac = doc.getString("fechNac") ?: ""
                    val fechIng = doc.getString("fechIng") ?: ""
                    val puesto = doc.getString("puesto") ?: ""
                    Empleados(
                        nombre = nombre,
                        apellido = apellido,
                        dni = dni,
                        fechNac = fechNac,
                        fechIng = fechIng,
                        puesto = puesto
                    )
                }.toMutableList()

                verificarAsistencia(empleados)
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error al cargar empleados", Toast.LENGTH_SHORT).show()
            }
    }

    private fun verificarAsistencia(empleados: MutableList<Empleados>) {
        firestore.collection("asistencia").document(fechaHoy).collection("asistentes")
            .get()
            .addOnSuccessListener { asistentesSnapshot ->
                val asistentesDni = asistentesSnapshot.documents.map { it.id }
                empleados.forEach { empleado ->
                    if (asistentesDni.contains(empleado.dni)) {
                        empleado.asistenciaRegistrada = true
                    }
                }
                adapter.actualizarLista(empleados)
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error al verificar asistencia", Toast.LENGTH_SHORT).show()
            }
    }

    private fun registrarAsistencia(trabajador: Empleados, callback: (Boolean) -> Unit) {
        firestore.collection("asistencia").document(fechaHoy).collection("asistentes")
            .document(trabajador.dni)
            .set(
                hashMapOf(
                    "nombre" to trabajador.nombre,
                    "apellido" to trabajador.apellido,
                    "fechNac" to trabajador.fechNac,
                    "fechIng" to trabajador.fechIng,
                    "puesto" to trabajador.puesto,
                    "dni" to trabajador.dni
                )
            )
            .addOnSuccessListener {
                trabajador.asistenciaRegistrada = true
                callback(true)
                Toast.makeText(this, "Asistencia registrada", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                callback(false)
                Toast.makeText(this, "Error al registrar asistencia", Toast.LENGTH_SHORT).show()
            }
    }

    private fun cancelarAsistencia(empleado: Empleados) {
        AlertDialog.Builder(this)
            .setTitle("Cancelar Asistencia")
            .setMessage("¿Está seguro de cancelar la asistencia de ${empleado.nombre}?")
            .setPositiveButton("Sí") { _, _ ->
                firestore.collection("asistencia").document(fechaHoy).collection("asistentes")
                    .document(empleado.dni)
                    .delete()
                    .addOnSuccessListener {
                        empleado.asistenciaRegistrada = false
                        adapter.notifyDataSetChanged()
                        Toast.makeText(this, "Asistencia cancelada", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Error al cancelar asistencia", Toast.LENGTH_SHORT).show()
                    }
            }
            .setNegativeButton("No", null)
            .show()
    }
}


