package dao;
 
import java.sql.*;
import java.util.*;
import dbase.conexiondb;
import vo.categoriavo;
import vo.productovo;
 
public class productodao {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;    
    private categoriadao categoriaDao=new categoriadao();
 
    public productodao() {}

    public Collection<productovo> findAll() 

    {
        List<productovo> list=new ArrayList<>();
         try {
            conn=conexiondb.MySQL();           
            ps=conn.prepareStatement("select * from producto");
            rs=ps.executeQuery();
            while(rs.next()) {
                productovo producto=new productovo();
                producto.setId_producto(rs.getInt("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setMarca(rs.getString("marca"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
                categoriavo categoria=categoriaDao.findById(rs.getInt("id_categoria"));
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

 