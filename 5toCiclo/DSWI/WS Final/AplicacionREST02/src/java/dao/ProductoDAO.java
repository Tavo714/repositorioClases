package dao;

import dbase.ConexionDb;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import vo.ProductoVO;

public class ProductoDAO {
    private Connection connection;
    private PreparedStatement prepSt;
    private ResultSet rSet;
    
    public List<ProductoVO> getAllProductos(){
        List<ProductoVO> productos = new ArrayList<ProductoVO>();
        try{
            connection = ConexionDb.MySQL();
            prepSt = connection.prepareStatement("SELECT * FROM producto");
            rSet = prepSt.executeQuery();
            while(rSet.next()){
                ProductoVO producto = new ProductoVO();
                producto.setIdproducto(rSet.getInt("idproducto"));
                producto.setNompro(rSet.getString("nompro"));
                producto.setDespro(rSet.getString("despro"));
                producto.setCantidad(rSet.getInt("cantidad"));
                producto.setPrecio(rSet.getDouble("precio"));
                producto.setIdcategoria(rSet.getInt("idcategoria"));  
                producto.setIdproveedor(rSet.getInt("idproveedor")); 
                productos.add(producto);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return productos;
    }
    public ProductoVO getProductoById(int id){
        ProductoVO producto = null;
        try {
            connection=ConexionDb.MySQL();            
            prepSt=connection.prepareStatement("SELECT * FROM producto WHERE idproducto = ?");
            prepSt.setInt(1, id);
            rSet=prepSt.executeQuery();
            if(rSet.next()) {
                producto =new ProductoVO();                
                producto.setIdproducto(rSet.getInt("idproducto"));
                producto.setNompro(rSet.getString("nompro"));
                producto.setDespro(rSet.getString("despro"));
                producto.setCantidad(rSet.getInt("cantidad"));
                producto.setPrecio(rSet.getDouble("precio"));
                producto.setIdcategoria(rSet.getInt("idcategoria"));  
                producto.setIdproveedor(rSet.getInt("idproveedor")); 
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return producto;
    }
    public void insertProducto(ProductoVO producto){
        try {
            connection=ConexionDb.MySQL();            
            prepSt=connection.prepareStatement("INSERT INTO producto (nompro, despro, cantidad, precio, idcategoria, idproveedor) VALUES (?, ?, ?, ?, ?, ?)");  
            prepSt.setString(1, producto.getNompro());
            prepSt.setString(2, producto.getDespro());
            prepSt.setInt(3, producto.getCantidad());
            prepSt.setDouble(4, producto.getPrecio());
            prepSt.setInt(5, producto.getIdcategoria());
            prepSt.setInt(6, producto.getIdproveedor());
            int rows=prepSt.executeUpdate();
            if(rows!=1)
            throw new Exception("Error al insertar!!!");
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void updateProducto(int idproducto, ProductoVO producto){
        ProductoVO productoExistente = getProductoById(idproducto);
        if(productoExistente !=null){
            try {
                connection=ConexionDb.MySQL();            
                prepSt=connection.prepareStatement("UPDATE producto SET nompro = ?, despro = ?, cantidad = ?, precio = ?, idcategoria = ?, idproveedor = ? WHERE idproducto = ?"); 
                prepSt.setString(1, producto.getNompro()!= null ? producto.getNompro(): productoExistente.getNompro());
                prepSt.setString(2, producto.getDespro()!= null ? producto.getDespro(): productoExistente.getDespro());
                prepSt.setInt(3, producto.getCantidad()!= null ? producto.getCantidad(): productoExistente.getCantidad());
                prepSt.setDouble(4, producto.getPrecio()!= null ? producto.getPrecio(): productoExistente.getPrecio());
                prepSt.setInt(5, producto.getIdcategoria()!= null ? producto.getIdcategoria(): productoExistente.getIdcategoria());
                prepSt.setInt(6, producto.getIdproveedor()!= null ? producto.getIdproveedor(): productoExistente.getIdproveedor());
                prepSt.setInt(7,idproducto);
                
                int rows = prepSt.executeUpdate();
                if(rows!=1)
                throw new Exception("Error al ACTUALIZAR!!!");

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else{
            
        }
    }
    public void deleteProducto(int id) {
        ProductoVO productoExistente = getProductoById(id);
       
        if (productoExistente != null) {
            try {
                connection= ConexionDb.MySQL();
                prepSt = connection.prepareStatement("DELETE FROM producto WHERE idproducto = ?");
                prepSt.setInt(1, id);  
                int rows = prepSt.executeUpdate();
                if (rows != 1) {
                    throw new Exception("Error al eliminar el pedido.");
                }  
                
            } catch (Exception ex) {
                ex.printStackTrace();
                }   
        } else {
            
        }
        
    }
    public List<ProductoVO> marshall() {
        List<ProductoVO> productos = getAllProductos();
        ObjectMapper objectmapper = new ObjectMapper();
        try{
            objectmapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
            objectmapper.writeValue(new File("D:\\repositoriosRemotos\\WS\\JSON\\productos.json"), productos);
            System.out.println(objectmapper.writeValueAsString(productos));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return productos;
    }
    public List<ProductoVO> unmarshall() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ProductoVO> productos = null;
        try {
            
            productos = objectMapper.readValue(
                new File("D:\\repositoriosRemotos\\WS\\JSON\\productos.json"),
                objectMapper.getTypeFactory().constructCollectionType(List.class, ProductoVO.class)
            );
            
            for (ProductoVO producto : productos) {
                System.out.println("Datos del Producto \n ===================");
                System.out.println("ID Producto: " + producto.getIdproducto());
                System.out.println("Nombre del Empleado: " + producto.getNompro());
                System.out.println("Apellido del Empleado: " + producto.getDespro());
                System.out.println("DNI del empleado: " + producto.getCantidad());
                System.out.println("Telefono del empleado: " + producto.getPrecio());
                System.out.println("Correo del empleado: " + producto.getIdcategoria());
                System.out.println("Correo del empleado: " + producto.getIdproveedor());
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productos;
    }
}
