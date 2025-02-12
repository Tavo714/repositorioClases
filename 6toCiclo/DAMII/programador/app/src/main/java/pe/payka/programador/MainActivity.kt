package pe.payka.programador

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNombres = findViewById<EditText>(R.id.etNombres)
        val etEdad = findViewById<EditText>(R.id.etEdad)
        val rbMasculino = findViewById<RadioButton>(R.id.rbMasculino)
        val rbFemenino = findViewById<RadioButton>(R.id.rbFemenino)
        val cbJunior = findViewById<CheckBox>(R.id.cbJunior)
        val cbIntermedio = findViewById<CheckBox>(R.id.cbIntermedio)
        val cbSenior = findViewById<CheckBox>(R.id.cbSenior)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val btnLimpiar = findViewById<Button>(R.id.btnLimpiar)

        val tvResultadoNombresText = findViewById<TextView>(R.id.tvResultadoNombresText)
        val tvResultadoEdadText = findViewById<TextView>(R.id.tvResultadoEdadText)
        val tvResultadoSexoText = findViewById<TextView>(R.id.tvResultadoSexoText)
        val tvResultadoSueldoText = findViewById<TextView>(R.id.tvResultadoSueldoText)

        btnCalcular.setOnClickListener {
            val nombres = etNombres.text.toString()
            val edad = etEdad.text.toString()
            val sexo = if (rbMasculino.isChecked) "Masculino" else if (rbFemenino.isChecked) "Femenino" else "No especificado"

            var sueldo = 0
            if (cbJunior.isChecked) sueldo += 1500
            if (cbIntermedio.isChecked) sueldo += 3000
            if (cbSenior.isChecked) sueldo += 5000

            tvResultadoNombresText.text = nombres
            tvResultadoEdadText.text = edad
            tvResultadoSexoText.text = sexo
            tvResultadoSueldoText.text = "S/ $sueldo"
        }

        btnLimpiar.setOnClickListener {
            etNombres.text.clear()
            etEdad.text.clear()
            rbMasculino.isChecked = false
            rbFemenino.isChecked = false
            cbJunior.isChecked = false
            cbIntermedio.isChecked = false
            cbSenior.isChecked = false
            tvResultadoNombresText.text = ""
            tvResultadoEdadText.text = ""
            tvResultadoSexoText.text = ""
            tvResultadoSueldoText.text = ""
        }
    }
}
