package com.pixelpulse.app_final

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.firebase.firestore.FirebaseFirestore
import com.pixelpulse.app_final.databinding.ActivityCrearTrabajadorBinding
import java.text.SimpleDateFormat
import java.util.*

class CrearTrabajadorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCrearTrabajadorBinding
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearTrabajadorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firestore = FirebaseFirestore.getInstance()

        // Bloquear entrada manual y abrir el selector de fecha para Fecha de Nacimiento
        binding.edtFechaNac.apply {
            isFocusable = false
            setOnClickListener { mostrarDatePickerFechaNacimiento() }
        }

        // Bloquear entrada manual y abrir el selector de fecha para Fecha de Ingreso
        binding.edtFechaIng.apply {
            isFocusable = false
            setOnClickListener { mostrarDatePickerFechaIngreso() }
        }

        binding.btnGuardar.setOnClickListener {
            confirmarGuardarTrabajador()
        }

        binding.btnCancelar.setOnClickListener {
            finish()
        }
    }

    private fun mostrarDatePickerFechaNacimiento() {
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Selecciona la fecha de nacimiento")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()

        datePicker.addOnPositiveButtonClickListener { selection ->
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date = sdf.format(Date(selection))
            binding.edtFechaNac.setText(date)
        }

        // Restringir fechas a pasadas
        datePicker.show(supportFragmentManager, "DATE_PICKER")
    }

    private fun mostrarDatePickerFechaIngreso() {
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Selecciona la fecha de ingreso")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .build()

        datePicker.addOnPositiveButtonClickListener { selection ->
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date = sdf.format(Date(selection))
            binding.edtFechaIng.setText(date)
        }

        datePicker.show(supportFragmentManager, "DATE_PICKER")
    }

    private fun confirmarGuardarTrabajador() {
        val nombre = binding.edtNombre.text.toString().trim()
        val apellido = binding.edtApellido.text.toString().trim()
        val dni = binding.edtDni.text.toString().trim()
        val fechaNac = binding.edtFechaNac.text.toString().trim()
        val fechaIng = binding.edtFechaIng.text.toString().trim()
        val puesto = binding.edtPuesto.text.toString().trim()

        if (!validarCampos(nombre, apellido, dni, fechaNac, fechaIng, puesto)) return

        AlertDialog.Builder(this)
            .setTitle("Confirmación")
            .setMessage("¿Está seguro de guardar este trabajador?")
            .setPositiveButton("Guardar") { _, _ ->
                guardarTrabajador(nombre, apellido, dni, fechaNac, fechaIng, puesto)
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun validarCampos(
        nombre: String,
        apellido: String,
        dni: String,
        fechaNac: String,
        fechaIng: String,
        puesto: String
    ): Boolean {
        var esValido = true

        if (nombre.isEmpty()) {
            binding.tilNombre.error = "El nombre no puede estar vacío."
            esValido = false
        } else binding.tilNombre.error = null

        if (apellido.isEmpty()) {
            binding.tilApellido.error = "El apellido no puede estar vacío."
            esValido = false
        } else binding.tilApellido.error = null

        if (dni.isEmpty() || !dni.matches(Regex("\\d{8}"))) {
            binding.tilDni.error = "El DNI debe tener 8 dígitos numéricos."
            esValido = false
        } else binding.tilDni.error = null

        if (fechaNac.isEmpty()) {
            binding.tilFechaNac.error = "Selecciona la fecha de nacimiento."
            esValido = false
        } else binding.tilFechaNac.error = null

        if (fechaIng.isEmpty()) {
            binding.tilFechaIng.error = "Selecciona la fecha de ingreso."
            esValido = false
        } else binding.tilFechaIng.error = null

        if (puesto.isEmpty()) {
            binding.tilPuesto.error = "El puesto no puede estar vacío."
            esValido = false
        } else binding.tilPuesto.error = null

        return esValido
    }

    private fun guardarTrabajador(
        nombre: String,
        apellido: String,
        dni: String,
        fechaNac: String,
        fechaIng: String,
        puesto: String
    ) {
        val nuevoEmpleado = hashMapOf(
            "nombre" to nombre,
            "apellido" to apellido,
            "dni" to dni,
            "fechNac" to fechaNac,
            "fechIng" to fechaIng,
            "puesto" to puesto,
            "estado" to "activo"
        )

        firestore.collection("empleados")
            .add(nuevoEmpleado)
            .addOnSuccessListener {
                Toast.makeText(this, "Trabajador creado con éxito", Toast.LENGTH_SHORT).show()
                setResult(RESULT_OK)
                finish()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Error al crear trabajador: ${exception.message}", Toast.LENGTH_SHORT).show()
            }
    }
}


