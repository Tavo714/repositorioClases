package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import dbase.Conexiondb;
import vo.Departamentovo;
import vo.Empleadovo;

public class Empleadodao {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    private Departamentodao departamentosdao = new Departamentodao();

    public Empleadodao() {
    }

    public void insert(Empleadovo empleado) {
        try {
            conn = Conexiondb.MySQL();
            ps = conn.prepareStatement(
                    "INSERT INTO empleados (id_departamento, nombre, puesto, fecha_alta, sueldo) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, empleado.getId_departamento());
            ps.setString(2, empleado.getNombre());
            ps.setString(3, empleado.getPuesto());
            ps.setString(4, empleado.getFecha_alta());
            ps.setDouble(5, empleado.getSueldo());
            int rows = ps.executeUpdate();
            if (rows != 1)
                throw new Exception("Error al insertar el empleado.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Collection<Empleadovo> findAll() {
        List<Empleadovo> list = new ArrayList<>();
        try {
            conn = Conexiondb.MySQL();
            ps = conn.prepareStatement("SELECT * FROM empleados");
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleadovo empleado = new Empleadovo();
                empleado.setId_empleado(rs.getInt("id_empleado"));
                empleado.setId_departamento(rs.getInt("id_departamento"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setPuesto(rs.getString("puesto"));
                empleado.setFecha_alta(rs.getString("fecha_alta"));
                empleado.setSueldo(rs.getDouble("sueldo"));

                Departamentovo departamento = departamentosdao.findById(rs.getInt("id_departamento"));
                empleado.setDepartamento(departamento);

                list.add(empleado);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public Collection<Empleadovo> findByDepartamento(int id_departamento) {
        List<Empleadovo> list = new ArrayList<>();
        try {
            conn = Conexiondb.MySQL();
            ps = conn.prepareStatement("SELECT * FROM empleados WHERE id_departamento = ?");
            ps.setInt(1, id_departamento);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleadovo empleado = new Empleadovo();
                empleado.setId_empleado(rs.getInt("id_empleado"));
                empleado.setId_departamento(rs.getInt("id_departamento"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setPuesto(rs.getString("puesto"));
                empleado.setFecha_alta(rs.getString("fecha_alta"));
                empleado.setSueldo(rs.getDouble("sueldo"));

                Departamentovo departamento = departamentosdao.findById(rs.getInt("id_departamento"));
                empleado.setDepartamento(departamento);

                list.add(empleado);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
