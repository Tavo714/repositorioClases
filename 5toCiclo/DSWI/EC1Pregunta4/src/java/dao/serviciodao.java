
package dao;

import java.sql.*;
import java.util.*;
import dbase.conexiondb;
import vo.serviciovo;

public class serviciodao {
    
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public serviciodao() {}

    public serviciovo findById(int codigo) {

        serviciovo servicio=null;
 
        try {

            conn=conexiondb.MySQL();          
            ps=conn.prepareStatement("select * from tbservicio where codigo=?");
            ps.setInt(1,codigo);            
            rs=ps.executeQuery();

            if(rs.next()) {
                servicio=new serviciovo();               
                servicio.setCodigo(rs.getInt("codigo"));
                servicio.setDescripcion(rs.getString("descripcion"));
                servicio.setImporte(rs.getDouble("importe"));
            }

        }

        catch(Exception ex){

            ex.printStackTrace();

        }
 
        return servicio;

    }

    public Collection<serviciovo> findAll() {
        List<serviciovo> list=new ArrayList<>();
        try {
            conn=conexiondb.MySQL();            
            ps=conn.prepareStatement("select * from tbservicio");
            rs=ps.executeQuery();
            while(rs.next()) {
                serviciovo servicio=new serviciovo();                
                servicio.setCodigo(rs.getInt("codigo"));
                servicio.setDescripcion(rs.getString("descripcion"));    
                servicio.setImporte(rs.getDouble("importe"));
                list.add(servicio);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
}
