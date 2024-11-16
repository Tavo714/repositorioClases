package vo;

public class productovo {

    private int id_producto;
    private String nombre;
    private String marca;
    private double precio;
    private int stock;  
    private categoriavo categoria;

    public productovo() {}
 
    public productovo(int id_producto, String nombre, String marca, double precio, int stock, categoriavo categoria) {

        this.id_producto = id_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;

    }
//OJO CON ESTA ETIQUETA OVERRIDE!!!
    @Override
     public String toString() {
        return "ProductoVo{" + "id_producto=" + id_producto + ", nombre=" + nombre + 
                     ", marca=" + marca + ", precio=" + precio + 
                     ", stock=" + stock + ", categoria=" + categoria.getDescripcion() + '}';
    }
//
 
    public int getId_producto() {
        return id_producto;
    }
 
    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public String getMarca() {
        return marca;
    }
 
    public void setMarca(String marca) {
        this.marca = marca;
    }
 
    public double getPrecio() {
        return precio;
    }
 
    public void setPrecio(double precio) {
        this.precio = precio;
    }
 
    public int getStock() {
        return stock;
    }
 
    public void setStock(int stock) {
        this.stock = stock;
    }
 
    public categoriavo getCategoria() {
        return categoria;
    }
 
    public void setCategoria(categoriavo categoria) {
        this.categoria = categoria;
    }
}

 