package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    String bd = "salessistem";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection con;

    public Conexion() {
    }

    public Connection getConnection() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + bd, user, password);
            System.out.println("Conexion Correcta: " + bd);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Conexion Fallida: " + bd);
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void desconectar() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Conexion cx = new Conexion();
        cx.getConnection();
    }
}
