package com.example.emisorusuario1vmga.Model;

public class Mensaje {

    private String fechaHora;
    private String comentario;
    private String usuario;

    public Mensaje() {
    }

    public Mensaje(String fechaHora, String comentario, String usuario) {
        this.fechaHora = fechaHora;
        this.comentario = comentario;
        this.usuario = usuario;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
