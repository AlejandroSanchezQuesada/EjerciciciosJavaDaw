package entrenandojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EntrenandoJDBC {

    static final String URL = "jdbc:mysql://localhost/";
    static final String DATABASE = "neptuno";
    static final String USER = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {

        try {
            Connection conexion = DriverManager.getConnection(URL + DATABASE, USER, PASSWORD);
            
            
            Statement sentencia = conexion.createStatement();
            
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM empleados");
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EntrenandoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
