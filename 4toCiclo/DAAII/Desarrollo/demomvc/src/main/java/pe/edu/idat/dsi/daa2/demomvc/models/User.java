package pe.edu.idat.dsi.daa2.demomvc.models;

public class User {
    private int id;
    private String name;
    private String lastname;
    private String nid;
    private String phoneNumber;    

    // Constructor vacio
    public User() {
    }
    
    //Constructor lleno
    public User(int id, String name, String lastname, String nid, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.nid = nid;
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getNid() {
        return nid;
    }
    public void setNid(String nid) {
        this.nid = nid;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }    

}

//Pascal Case (clases)

//User
//Persona
//ClienteInterno
//ConexionBD
//RegistroPcm

//Camel Case (metodos, funciones, parametros y atributos)

//correoElectronico
//nombrePersona
//numeroTelefonico
//esUnValidador


