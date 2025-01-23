package vo;


public class ProveedorVO {
    private Integer idproveedor;
    private String razsocial;
    private String ruc;
    private String telefonopro;
    private String correopro;
    private String contacto;
    private String telefonocon;
    private String correocon;

    public ProveedorVO() {
    }

    public ProveedorVO(Integer idproveedor, String razsocial, String ruc, String telefonopro, String correopro, String contacto, String telefonocon, String correocon) {
        this.idproveedor = idproveedor;
        this.razsocial = razsocial;
        this.ruc = ruc;
        this.telefonopro = telefonopro;
        this.correopro = correopro;
        this.contacto = contacto;
        this.telefonocon = telefonocon;
        this.correocon = correocon;
    }

    public Integer getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getRazsocial() {
        return razsocial;
    }

    public void setRazsocial(String razsocial) {
        this.razsocial = razsocial;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefonopro() {
        return telefonopro;
    }

    public void setTelefonopro(String telefonopro) {
        this.telefonopro = telefonopro;
    }

    public String getCorreopro() {
        return correopro;
    }

    public void setCorreopro(String correopro) {
        this.correopro = correopro;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefonocon() {
        return telefonocon;
    }

    public void setTelefonocon(String telefonocon) {
        this.telefonocon = telefonocon;
    }

    public String getCorreocon() {
        return correocon;
    }

    public void setCorreocon(String correocon) {
        this.correocon = correocon;
    }
    
    
}
