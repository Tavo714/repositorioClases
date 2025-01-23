package dao;

import java.sql.*;
import dbase.Conexiondb;
import vo.Departamentovo;

public class Departamentodao {

    public Departamentovo findById(int id_departamento) {
        Departamentovo departamento = null;
        try (Connection conn = Conexiondb.MySQL();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM departamentos WHERE id_departamento = ?")) {
            ps.setInt(1, id_departamento);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    departamento = new Departamentovo();
                    departamento.setId_departamento(rs.getInt("id_departamento"));
                    departamento.setNombre(rs.getString("nombre"));
                    departamento.setEdificio(rs.getString("edificio"));
                    departamento.setPlanta(rs.getInt("planta"));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return departamento;
    }
}
