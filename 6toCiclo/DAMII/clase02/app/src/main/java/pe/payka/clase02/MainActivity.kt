package pe.payka.clase02

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var txtResultado: TextView = findViewById(R.id.txtResultado)
        var txtNombres: EditText = findViewById(R.id.txtNombres)
        var txtEdad: EditText = findViewById(R.id.txtEdad)
        var btnHallar: Button = findViewById(R.id.btnHallar)
        var btnCalcular: Button = findViewById(R.id.btnCalcular)
        var btnLimpiar: Button = findViewById(R.id.btnLimpiar)
        btnCalcular.setOnClickListener{
            var nombres=txtNombres.text.toString()
            txtResultado.text="Apellidos y Nombres:.$nombres"
            var final=txtEdad.text.toString().toInt()
            if(final<=17){
                Toast.makeText(this,"Es menor de edad",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Es mayor listo para trabajar",Toast.LENGTH_SHORT).show()
            }
        }
        btnLimpiar.setOnClickListener{
            txtResultado.text="Apellidos y Nombres:"
            txtNombres.setText("")
            txtEdad.setText("")
            txtNombres.requestFocus()
        }
        btnHallar.setOnClickListener{
            Toast.makeText(this, "Kotlin 2025", Toast.LENGTH_SHORT).show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}