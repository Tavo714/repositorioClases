package dao;

import java.sql.*;
import dbase.conexiondb;
import vo.empresasvo;

public class empresasdao {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public empresasdao() {
    }

    public empresasvo findById(String cif) {
        empresasvo empresa = null;
        try {
            conn = conexiondb.MySQL();
            ps = conn.prepareStatement("SELECT * FROM empresas WHERE cif = ?");
            ps.setString(1, cif);
            rs = ps.executeQuery();
            if (rs.next()) {
                empresa = new empresasvo();
                empresa.setCif(rs.getString("cif"));
                empresa.setNombre(rs.getString("nombre"));
                empresa.setTelefono(rs.getString("telefono"));
                empresa.setDireccion(rs.getString("direccion"));
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
        return empresa;
    }
}

