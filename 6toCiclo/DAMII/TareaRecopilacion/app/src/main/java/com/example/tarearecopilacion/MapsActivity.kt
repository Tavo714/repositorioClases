package com.example.tarearecopilacion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps) // ✅ Este es el layout correcto
        createFragment()
    }

    private fun createFragment() {
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Coordenadas: Piura
        val ubicacion = LatLng(-5.184514, -80.628880)

        // Marcador
        map.addMarker(MarkerOptions().position(ubicacion).title("Ubicación de interés"))

        // Mover la cámara
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 15f))
    }
}
