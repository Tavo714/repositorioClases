
package dao;

import java.sql.*;
import java.util.*;
import dbase.conexiondb;
import vo.areavo;

public class areadao {
    
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public areadao() {}

    public areavo findById(int id_area) {

        areavo area=null;
 
        try {

            conn=conexiondb.MySQL();          
            ps=conn.prepareStatement("select * from tbarea where id_area=?");
            ps.setInt(1,id_area);            
            rs=ps.executeQuery();

            if(rs.next()) {
                area=new areavo();               
                area.setId_area(rs.getInt("id_area"));
                area.setNombre(rs.getString("nombre"));
            }

        }

        catch(Exception ex){

            ex.printStackTrace();

        }
 
        return area;

    }

    public Collection<areavo> findAll() {
        List<areavo> list=new ArrayList<>();
        try {
            conn=conexiondb.MySQL();            
            ps=conn.prepareStatement("select * from tbarea");
            rs=ps.executeQuery();
            while(rs.next()) {
                areavo area=new areavo();                
                area.setId_area(rs.getInt("id_area"));
                area.setNombre(rs.getString("nombre"));                
                list.add(area);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }
    
}
