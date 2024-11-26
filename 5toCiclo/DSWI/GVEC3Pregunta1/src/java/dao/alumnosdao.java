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
    private empresasdao empresadao = new empresasdao();

    public alumnosdao() {
    }

    public void insert(alumnosvo alumno) {
        try {
            conn = conexiondb.MySQL();
            ps = conn.prepareStatement("INSERT INTO alumnos (dni, nombre, apellido1, apellido2, direccion, telefono, edad, cif) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, alumno.getDni());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido1());
            ps.setString(4, alumno.getApellido2());
            ps.setString(5, alumno.getDireccion());
            ps.setString(6, alumno.getTelefono());
            ps.setInt(7, alumno.getEdad());
            ps.setString(8, alumno.getEmpresa().getCif());
            int rows = ps.executeUpdate();
            if (rows != 1) {
                throw new Exception("Error al insertar!!!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Collection<alumnosvo> findByEmpresa(String nombreEmpresa) {
        List<alumnosvo> list = new ArrayList<>();
        try {
            conn = conexiondb.MySQL();
            ps = conn.prepareStatement(
                "SELECT a.* " +
                "FROM alumnos a " +
                "JOIN empresas e ON a.cif = e.cif " +
                "WHERE e.nombre = ?"
            );
            ps.setString(1, nombreEmpresa);
            rs = ps.executeQuery();
            while (rs.next()) {
                alumnosvo alumno = new alumnosvo();
                alumno.setDni(rs.getString("dni"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido1(rs.getString("apellido1"));
                alumno.setApellido2(rs.getString("apellido2"));
                alumno.setDireccion(rs.getString("direccion"));
                alumno.setTelefono(rs.getString("telefono"));
                alumno.setEdad(rs.getInt("edad"));
                empresasvo empresa = empresadao.findById(rs.getString("cif"));
                alumno.setEmpresa(empresa);
                list.add(alumno);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
