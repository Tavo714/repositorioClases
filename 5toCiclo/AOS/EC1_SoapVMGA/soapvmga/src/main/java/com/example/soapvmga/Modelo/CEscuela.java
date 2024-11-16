package com.example.soapvmga.Modelo;

import jakarta.persistence.*;

@Entity
@Table (name="escuela")
public class CEscuela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codesc;
    private String desesc;
    private int codfac;
    private String ubiesc;

    public CEscuela() {
        //super();
    }

    public CEscuela(int codesc, String desesc, int codfac, String ubiesc) {
        this.codesc = codesc;
        this.desesc = desesc;
        this.codfac = codfac;
        this.ubiesc = ubiesc;
    }

    public int getCodesc() {
        return codesc;
    }

    public void setCodesc(int codesc) {
        this.codesc = codesc;
    }

    public String getDesesc() {
        return desesc;
    }

    public void setDesesc(String desesc) {
        this.desesc = desesc;
    }

    public int getCodfac() {
        return codfac;
    }

    public void setCodfac(int codfac) {
        this.codfac = codfac;
    }

    public String getUbiesc() {
        return ubiesc;
    }

    public void setUbiesc(String ubiesc) {
        this.ubiesc = ubiesc;
    } 


}
