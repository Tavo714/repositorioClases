package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import dbase.conexiondb;
import vo.empresasvo;
import vo.alumnosvo;


public class alumnosdao {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private empresasdao empresasdao = new empresasdao();


    public alumnosdao(){
    }
    public void insert(alumnosvo alumno){
        try{
          conn = conexiondb.MySQL();
          ps = conn.prepareStatement("insert into alumnos(dni,nombre,apellido1,apellido2,direccion,telefono,edad,empresa) values(?,?,?,?,?,?,?,?)");
          ps.setString(1, alumno.getDni());
          ps.setString(2, alumno.getNombre());
          ps.setString(3, alumno.getApellido1());
          ps.setString(4, alumno.getApellido2());
          ps.setString(5, alumno.getDireccion());
          ps.setString(6, alumno.getTelefono());
          ps.setInt(7, alumno.getEdad());
          ps.setString(8, alumno.getEmpresa().getCif());
          int rows=ps.executeUpdate();
          if(rows!=1)
              throw new Exception("Error al insertar!!!");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public Collection<alumnosvo> findAll()
    {
        List<alumnosvo> list = new ArrayList<>();
        try
        {
          conn = conexiondb.MySQL();
          ps = conn.prepareStatement("select * from alumnos");
          rs = ps.executeQuery();
          while(rs.next())
          {
              alumnosvo alumno = new alumnosvo();
              alumno.setDni(rs.getString("dni"));
              alumno.setNombre(rs.getString("nombre"));
              alumno.setApellido1(rs.getString("apellido1"));
              alumno.setApellido2(rs.getString("apellido2"));
              alumno.setDireccion(rs.getString("direccion"));
              alumno.setTelefono(rs.getString("telefono"));
              alumno.setEdad(rs.getInt("edad"));             
              empresasvo empresa=empresasdao.findById(rs.getString("cif"));
              alumno.setEmpresa(empresa);
              list.add(alumno);
          }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

}

