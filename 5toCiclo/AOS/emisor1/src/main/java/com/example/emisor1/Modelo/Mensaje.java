package com.example.emisor1.Modelo;

public class Mensaje {

    private String comentario;
    private String tipo;
    
    public Mensaje() {
    }

    public Mensaje(String comentario, String tipo) {
        this.comentario = comentario;
        this.tipo = tipo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }    
    
}
