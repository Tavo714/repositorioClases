package com.example.aplicacionrest.Modelo;

import jakarta.persistence.*;

@Entity
@Table (name="trabajador")
public class CTrabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codtra;
    private String apetra;
    private String nomtra;
    private String dnitra;
    private String dirtra;
    private String teltra;
    private String cortra;
    private String fretra; //Al guardar en la base de datos automaticamente lo trata como tipo fecha.

    public CTrabajador() {
    }

    public CTrabajador(int codtra, String apetra, String nomtra, String dnitra, String dirtra, String teltra,
            String cortra, String fretra) {
        this.codtra = codtra;
        this.apetra = apetra;
        this.nomtra = nomtra;
        this.dnitra = dnitra;
        this.dirtra = dirtra;
        this.teltra = teltra;
        this.cortra = cortra;
        this.fretra = fretra;
    }

    public int getCodtra() {
        return codtra;
    }

    public void setCodtra(int codtra) {
        this.codtra = codtra;
    }

    public String getApetra() {
        return apetra;
    }

    public void setApetra(String apetra) {
        this.apetra = apetra;
    }

    public String getNomtra() {
        return nomtra;
    }

    public void setNomtra(String nomtra) {
        this.nomtra = nomtra;
    }

    public String getDnitra() {
        return dnitra;
    }

    public void setDnitra(String dnitra) {
        this.dnitra = dnitra;
    }

    public String getDirtra() {
        return dirtra;
    }

    public void setDirtra(String dirtra) {
        this.dirtra = dirtra;
    }

    public String getTeltra() {
        return teltra;
    }

    public void setTeltra(String teltra) {
        this.teltra = teltra;
    }

    public String getCortra() {
        return cortra;
    }

    public void setCortra(String cortra) {
        this.cortra = cortra;
    }

    public String getFretra() {
        return fretra;
    }

    public void setFretra(String fretra) {
        this.fretra = fretra;
    }      
    
}
