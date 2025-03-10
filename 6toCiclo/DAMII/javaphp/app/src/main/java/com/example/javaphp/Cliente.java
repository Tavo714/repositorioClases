package com.example.javaphp;

public class Cliente {
    private String dni, nombre, correo, telefono, fechaNacimiento, latitud, longitud;

    public Cliente(String dni, String nombre, String correo, String telefono, String fechaNacimiento, String latitud, String longitud) {
        this.dni = dni;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public String getLatitud() { return latitud; }
    public String getLongitud() { return longitud; }
}
