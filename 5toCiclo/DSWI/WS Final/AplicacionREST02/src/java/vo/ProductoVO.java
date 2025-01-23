package vo;


public class ProductoVO {
    private Integer idproducto;
    private String nompro;
    private String despro;
    private Integer cantidad;
    private Double precio;
    private Integer idcategoria;
    private Integer idproveedor;

    public ProductoVO() {
    }

    public ProductoVO(Integer idproducto, String nompro, String despro, Integer cantidad, Double precio, Integer idcategoria, Integer idproveedor) {
        this.idproducto = idproducto;
        this.nompro = nompro;
        this.despro = despro;
        this.cantidad = cantidad;
        this.precio = precio;
        this.idcategoria = idcategoria;
        this.idproveedor = idproveedor;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNompro() {
        return nompro;
    }

    public void setNompro(String nompro) {
        this.nompro = nompro;
    }

    public String getDespro() {
        return despro;
    }

    public void setDespro(String despro) {
        this.despro = despro;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public Integer getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }
    
    
}
