package dao;

import java.sql.*;
import dbase.conexiondb;
import vo.empresasvo;


public class empresasdao {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    public empresasdao(){
    }
    public empresasvo findById(String cif){
        empresasvo empresa=null;
        try{
            conn = conexiondb.MySQL();
            ps = conn.prepareStatement("select * from empresas where cif = ?");
            ps.setString(1, cif);
            rs=ps.executeQuery();
            if(rs.next())
            {
                empresa=new empresasvo();
                empresa.setCif(rs.getString("cif"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setTelefono(rs.getString("telefono"));
                empresa.setDireccion(rs.getString("direccion"));
                
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return empresa;
    }

}

