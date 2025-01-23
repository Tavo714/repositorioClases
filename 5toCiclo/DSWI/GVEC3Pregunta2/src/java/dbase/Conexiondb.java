package dbase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexiondb {
    public static Connection MySQL() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bdpersonal", "root", "");
    }
}
