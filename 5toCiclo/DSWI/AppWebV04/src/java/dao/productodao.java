package dao;
 
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import dbase.conexiondb;
import vo.categoriavo;
import vo.productovo;
 
public class productodao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private categoriadao categoriadao = new categoriadao();
    public productodao(){
    }
    public void insert(productovo producto){
        try{
          conn = conexiondb.MySQL();
          ps = conn.prepareStatement("insert into productos(nombre,marca,precio,stock,id_categoria) values(?,?,?,?,?)");
          ps.setString(1, producto.getNombre());
          ps.setString(2, producto.getMarca());
          ps.setDouble(3, producto.getPrecio());
          ps.setInt(4, producto.getStock());
          ps.setInt(5, producto.getCategoria().getId_categoria());
          int rows=ps.executeUpdate();
          if(rows!=1)
              throw new Exception("Error al insertar!!!");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public Collection<productovo> findAll()
    {
        List<productovo> list = new ArrayList<>();
        try
        {
          conn = conexiondb.MySQL();
          ps = conn.prepareStatement("select * from productos");
          rs = ps.executeQuery();
          while(rs.next())
          {
              productovo producto = new productovo();
              producto.setId_producto(rs.getInt("id_producto"));
              producto.setNombre(rs.getString("nombre"));
              producto.setMarca(rs.getString("marca"));
              producto.setPrecio(rs.getDouble("precio"));
              producto.setStock(rs.getInt("stock"));
              categoriavo categoria=categoriadao.findById(rs.getInt("id_categoria"));
              producto.setCategoria(categoria);
              list.add(producto);
          }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

}