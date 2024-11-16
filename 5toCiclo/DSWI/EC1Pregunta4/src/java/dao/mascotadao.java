
package dao;

import java.sql.*;
import java.util.*;
import dbase.conexiondb;
import vo.serviciovo;
import vo.mascotavo;

public class mascotadao {
    
    
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;    
    private serviciodao servicioDao=new serviciodao();
 
    public mascotadao() {}

    public Collection<mascotavo> findAll() 

    {
        List<mascotavo> list=new ArrayList<>();
         try {
            conn=conexiondb.MySQL();           
            ps=conn.prepareStatement("select * from tbmascota");
            rs=ps.executeQuery();
            while(rs.next()) {
                mascotavo mascota=new mascotavo();
                mascota.setId_mascota(rs.getInt("id_mascota"));
                mascota.setNombre(rs.getString("nombre"));
                mascota.setTipo(rs.getString("tipo"));
                mascota.setNacimiento(rs.getDate("nacimiento"));
                mascota.setRegistro(rs.getDate("registro"));
                mascota.setDni_propietario(rs.getString("dni_propietario"));
                mascota.setPropietario(rs.getString("propietario"));
                mascota.setDomicilio(rs.getString("domicilio"));
                serviciovo servicio=servicioDao.findById(rs.getInt("codigo"));
                mascota.setServicio(servicio);
                list.add(mascota);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
}
