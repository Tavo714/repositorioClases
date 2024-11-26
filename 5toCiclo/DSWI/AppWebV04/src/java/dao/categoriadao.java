package dao;
 
import java.sql.*;
import dbase.conexiondb;
import vo.categoriavo;
 
public class categoriadao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    public categoriadao(){
    }
    public categoriavo findById(int id_categoria){
        categoriavo categoria=null;
        try{
            conn = conexiondb.MySQL();
            ps = conn.prepareStatement("select * from categorias where id_categoria = ?");
            ps.setInt(1, id_categoria);
            rs=ps.executeQuery();
            if(rs.next())
            {
                categoria=new categoriavo();
                categoria.setId_categoria(rs.getInt("id_categoria"));
                categoria.setDescripcion(rs.getString("descripcion"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return categoria;
    }
}
