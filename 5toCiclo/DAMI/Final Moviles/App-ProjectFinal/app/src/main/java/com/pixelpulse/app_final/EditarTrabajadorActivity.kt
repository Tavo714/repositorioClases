package com.pixelpulse.app_final

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.firebase.firestore.FirebaseFirestore
import com.pixelpulse.app_final.Model.Empleados
import com.pixelpulse.app_final.databinding.ActivityEditarTrabajadorBinding
import java.text.SimpleDateFormat
import java.util.*

class EditarTrabajadorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditarTrabajadorBinding
    private lateinit var firestore: FirebaseFirestore
    private var trabajadorId: String? = null
    private val dateFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarTrabajadorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firestore = FirebaseFirestore.getInstance()

        trabajadorId = intent.getStringExtra("trabajador_dni")

        if (trabajadorId.isNullOrEmpty()) {
            Toast.makeText(this, "ID del trabajador no disponible", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        cargarDatosTrabajador()
        setupDatePickers()

        binding.btnGuardarCambios.setOnClickListener {
            confirmarGuardarCambios()
        }

        binding.btnCancelar.setOnClickListener {
            finish()
        }
    }

    private fun cargarDatosTrabajador() {
        firestore.collection("empleados")
            .whereEqualTo("dni", trabajadorId)
            .get()
            .addOnSuccessListener { snapshot ->
                val document = snapshot.documents.firstOrNull()
                val trabajador = document?.toObject(Empleados::class.java)
                if (trabajador != null) {
                    binding.txtDni.text = trabajador.dni
                    binding.edtNombre.setText(trabajador.nombre)
                    binding.edtApellido.setText(trabajador.apellido)
                    binding.edtFechaNac.setText(trabajador.fechNac)
                    binding.edtFechaIng.setText(trabajador.fechIng)
                    binding.edtPuesto.setText(trabajador.puesto)
                } else {
                    Toast.makeText(this, "Trabajador no encontrado", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error al cargar trabajador", Toast.LENGTH_SHORT).show()
                finish()
            }
    }

    private fun setupDatePickers() {
        val constraintsPasadas = CalendarConstraints.Builder().apply {
            setValidator(DateValidatorPointBackward.now())
        }.build()

        binding.edtFechaNac.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Selecciona Fecha de Nacimiento")
                .setCalendarConstraints(constraintsPasadas)
                .build()

            datePicker.show(supportFragmentManager, "FechaNacimiento")
            datePicker.addOnPositiveButtonClickListener { selection ->
                val calendar = Calendar.getInstance()
                calendar.timeInMillis = selection
                binding.edtFechaNac.setText(dateFormatter.format(calendar.time))
            }
        }

        binding.edtFechaIng.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setTitleText("Selecciona Fecha de Ingreso")
                .build()

            datePicker.show(supportFragmentManager, "FechaIngreso")
            datePicker.addOnPositiveButtonClickListener { selection ->
                val calendar = Calendar.getInstance()
                calendar.timeInMillis = selection
                binding.edtFechaIng.setText(dateFormatter.format(calendar.time))
            }
        }
    }

    private fun confirmarGuardarCambios() {
        val nombre = binding.edtNombre.text.toString().trim()
        val apellido = binding.edtApellido.text.toString().trim()
        val fechaNac = binding.edtFechaNac.text.toString().trim()
        val fechaIng = binding.edtFechaIng.text.toString().trim()
        val puesto = binding.edtPuesto.text.toString().trim()

        if (!validarCampos(nombre, apellido, fechaNac, fechaIng, puesto)) return

        AlertDialog.Builder(this)
            .setTitle("Confirmar cambios")
            .setMessage("¿Está seguro de guardar los cambios?")
            .setPositiveButton("Guardar") { _, _ ->
                guardarCambiosTrabajador(nombre, apellido, fechaNac, fechaIng, puesto)
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun validarCampos(
        nombre: String,
        apellido: String,
        fechaNac: String,
        fechaIng: String,
        puesto: String
    ): Boolean {
        var esValido = true

        if (nombre.isEmpty() || !nombre.matches(Regex("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$"))) {
            binding.edtNombre.error = "Nombre inválido."
            esValido = false
        }

        if (apellido.isEmpty() || !apellido.matches(Regex("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$"))) {
            binding.edtApellido.error = "Apellido inválido."
            esValido = false
        }

        if (fechaNac.isEmpty()) {
            binding.edtFechaNac.error = "Fecha de nacimiento inválida."
            esValido = false
        }

        if (fechaIng.isEmpty()) {
            binding.edtFechaIng.error = "Fecha de ingreso inválida."
            esValido = false
        }

        if (puesto.isEmpty()) {
            binding.edtPuesto.error = "El puesto no puede estar vacío."
            esValido = false
        }

        return esValido
    }

    private fun guardarCambiosTrabajador(
        nombre: String,
        apellido: String,
        fechaNac: String,
        fechaIng: String,
        puesto: String
    ) {
        val datosActualizados = mapOf(
            "nombre" to nombre,
            "apellido" to apellido,
            "fechNac" to fechaNac,
            "fechIng" to fechaIng,
            "puesto" to puesto
        )

        firestore.collection("empleados")
            .whereEqualTo("dni", trabajadorId)
            .get()
            .addOnSuccessListener { snapshot ->
                val document = snapshot.documents.firstOrNull()
                document?.reference?.update(datosActualizados)
                    ?.addOnSuccessListener {
                        Toast.makeText(this, "Cambios guardados con éxito", Toast.LENGTH_SHORT).show()
                        setResult(RESULT_OK)
                        finish()
                    }
                    ?.addOnFailureListener {
                        Toast.makeText(this, "Error al guardar cambios", Toast.LENGTH_SHORT).show()
                    }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error al buscar trabajador", Toast.LENGTH_SHORT).show()
            }
    }
}

