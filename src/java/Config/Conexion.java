
package Config;

import java.sql.*;

public class Conexion {
    Connection con;
    public Conexion(){
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/practicabdd?zeroDateTimeBehavior=convertToNull","root","");            
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error"+e);
        }
    }
    public Connection getConnection(){
        return con;
    }
}
