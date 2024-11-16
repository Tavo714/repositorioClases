package dbase;
 
import java.sql.*;
 
public class conexiondb {
    public static Connection MySQL() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c=DriverManager.getConnection
                                  ("jdbc:mysql://localhost:3306/bdclinica","gvalera","01234567");
        return c;
    }
}