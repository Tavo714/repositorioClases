package com.example.tarearecopilacion

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel

class CurriculumActivity : AppCompatActivity() {

    private var isSobreMiVisible = false
    private var isProyectosVisible = false
    private var isCursosVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curriculum)

        // Configuración de los botones de los proyectos
        findViewById<Button>(R.id.btnCuentos).setOnClickListener {
            startActivity(Intent(this, CuentacuentosActivity::class.java))
        }
        findViewById<Button>(R.id.btnCasaCambios).setOnClickListener {
            startActivity(Intent(this, CasacambiosActivity::class.java))
        }
        findViewById<Button>(R.id.btnPlanillas).setOnClickListener {
            startActivity(Intent(this, PlanillaActivity::class.java))
        }
        findViewById<Button>(R.id.btnProgramador).setOnClickListener {
            startActivity(Intent(this, ProgramaorActivity::class.java))
        }

        // Configuración del ImageSlider
        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        val imageList = arrayListOf(
            SlideModel(R.drawable.androidstudio, ScaleTypes.FIT),
            SlideModel(R.drawable.firebase, ScaleTypes.FIT),
            SlideModel(R.drawable.react,ScaleTypes.FIT),
            SlideModel(R.drawable.angular,ScaleTypes.FIT),
            SlideModel(R.drawable.tailwind, ScaleTypes.FIT),
            SlideModel(R.drawable.java, ScaleTypes.FIT),
            SlideModel(R.drawable.springboot, ScaleTypes.FIT)
        )
        imageSlider.setImageList(imageList)

        // Configuración del menú desplegable "Sobre Mí"
        val btnSobreMi: TextView = findViewById(R.id.btnSobreMi)
        val layoutSobreMi: LinearLayout = findViewById(R.id.layoutSobreMi)
        btnSobreMi.setOnClickListener {
            isSobreMiVisible = !isSobreMiVisible
            layoutSobreMi.visibility = if (isSobreMiVisible) View.VISIBLE else View.GONE
            btnSobreMi.text = if (isSobreMiVisible) "SOBRE MÍ ▲" else "SOBRE MÍ ▼"
        }

        // Configuración del menú desplegable "Proyectos Destacados"
        val btnProyectos: TextView = findViewById(R.id.btnProyectos)
        val layoutProyectos: LinearLayout = findViewById(R.id.layoutProyectos)
        btnProyectos.setOnClickListener {
            isProyectosVisible = !isProyectosVisible
            layoutProyectos.visibility = if (isProyectosVisible) View.VISIBLE else View.GONE
            btnProyectos.text = if (isProyectosVisible) "PROYECTOS DESTACADOS ▲" else "PROYECTOS DESTACADOS ▼"
        }

        // Configuración del menú desplegable "Cursos Actuales"
        val btnCursos: TextView = findViewById(R.id.btnCursos)
        val layoutCursos: LinearLayout = findViewById(R.id.layoutCursos)
        btnCursos.setOnClickListener {
            isCursosVisible = !isCursosVisible
            layoutCursos.visibility = if (isCursosVisible) View.VISIBLE else View.GONE
            btnCursos.text = if (isCursosVisible) "CURSOS ACTUALES ▲" else "CURSOS ACTUALES ▼"
        }
    }
}
