package com.pixelpulse.app_final.Model

data class Empleados(
    val nombre: String = "",
    val apellido: String = "",
    val dni: String = "",
    val fechNac: String = "",
    val fechIng: String = "",
    val puesto: String = "",
    var asistenciaRegistrada: Boolean = false, // Estado local de asistencia

)


