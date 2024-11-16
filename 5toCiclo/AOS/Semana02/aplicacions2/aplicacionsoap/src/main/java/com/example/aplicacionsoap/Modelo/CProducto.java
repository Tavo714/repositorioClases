package com.example.aplicacionsoap.Modelo;

import jakarta.persistence.*;


@Entity
@Table(name="producto")


public class CProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codpro;
    private long codcat;
    private String despro;
    private String unipro;
    private double pcopro;
    private double pvepro;
    private double stopro;
    private String frepro;

    public CProducto() {
 
    }
    
    public CProducto(long codpro, long codcat, String despro, String unipro, double pcopro, double pvepro, double stopro,
            String frepro) {
        this.codpro = codpro;
        this.codcat = codcat;
        this.despro = despro;
        this.unipro = unipro;
        this.pcopro = pcopro;
        this.pvepro = pvepro;
        this.stopro = stopro;
        this.frepro = frepro;
    }

    public long getCodpro() {
        return codpro;
    }

    public void setCodpro(long codpro) {
        this.codpro = codpro;
    }

    public long getCodcat() {
        return codcat;
    }

    public void setCodcat(long codcat) {
        this.codcat = codcat;
    }

    public String getDespro() {
        return despro;
    }

    public void setDespro(String despro) {
        this.despro = despro;
    }

    public String getUnipro() {
        return unipro;
    }

    public void setUnipro(String unipro) {
        this.unipro = unipro;
    }

    public double getPcopro() {
        return pcopro;
    }

    public void setPcopro(double pcopro) {
        this.pcopro = pcopro;
    }

    public double getPvepro() {
        return pvepro;
    }

    public void setPvepro(double pvepro) {
        this.pvepro = pvepro;
    }

    public double getStopro() {
        return stopro;
    }

    public void setStopro(double stopro) {
        this.stopro = stopro;
    }

    public String getFrepro() {
        return frepro;
    }

    public void setFrepro(String frepro) {
        this.frepro = frepro;
    }    

}
