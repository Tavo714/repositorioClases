package pe.edu.idat.dsi.daa2.monomvc.models;

public class User {
    private int id;
    private String name;
    private String lastname;
    private String nid;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    
    public User() {
    }

    public User(int id){
        this.id=id;
    }

    public User(int id, String name, String lastname, String nid, String username, String password, String email,
            String phoneNumber) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.nid = nid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
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
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}


