
package dao;

import java.sql.*;
import java.util.*;
import dbase.conexiondb;
import vo.areavo;
import vo.medicovo;

public class medicodao {
    
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;    
    private areadao areaDao=new areadao();
 
    public medicodao() {}

    public Collection<medicovo> findAll() 

    {
        List<medicovo> list=new ArrayList<>();
         try {
            conn=conexiondb.MySQL();           
            ps=conn.prepareStatement("select * from tbmedico");
            rs=ps.executeQuery();
            while(rs.next()) {
                medicovo medico=new medicovo();
                medico.setDni(rs.getInt("dni"));
                medico.setApellidos(rs.getString("apellidos"));
                medico.setNombres(rs.getString("nombres"));
                medico.setTitulo(rs.getString("titulo"));
                medico.setEspecialidad(rs.getString("especialidad"));
                medico.setNacimiento(rs.getDate("nacimiento"));
                medico.setIngreso(rs.getDate("ingreso"));
                medico.setBasico(rs.getDouble("basico"));
                medico.setBasico(rs.getDouble("basico"));
                medico.setBonificaciones(rs.getDouble("bonificaciones"));
                medico.setDescuentos(rs.getDouble("descuentos"));
                areavo area=areaDao.findById(rs.getInt("id_area"));
                medico.setArea(area);
                list.add(medico);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
    
}
