package conexionjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionJDBC {

    private static final String URL = "jdbc:mysql://localhost/";
    private static final String DATABASE = "neptuno";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection = null;

    public static void main(String[] args) {

        try {
            connection = DriverManager.getConnection(URL+DATABASE, USER, PASSWORD);
            System.out.println("Conexion establecida con exito");

            //muestraCategorias();
            
            //insertarCategoria("Probando","Probamos el ExecUpdate");
            //modificaCategoria(9,"Descripcion","AHORA CON UPDATE");
            muestraClientes();
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConexionJDBC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }
    
    private static void muestraClientes() throws SQLException{
        Statement sentencia = connection.createStatement();
        ResultSet rs = sentencia.executeQuery("SELECT * FROM clientes");
        
    
        while(rs.next()){
        
        String filaTabla = 
                
                rs.getString("IdCliente") + " " +
                rs.getString("NombreCompany") + " " +
                rs.getString("NombreContacto") + " " +
                rs.getString("NombreCompany") + " " +
                rs.getString("CargoContacto") + " " +
                rs.getString("Direccion") + " " +
                rs.getString("Ciudad") + " " +
                rs.getString("Region") + " " +
                rs.getString("CodPostal") + " " +
                rs.getString("Pais") + " " +
                rs.getString("Telefono") + " " +
                rs.getString("Fax") + " " +
                rs.getFloat("Saldo");
            System.out.println(filaTabla);
            System.out.println("--------------------------------------------------------------------");
        
        }
        
        
        
        
    
    }
    
    
    
    

    private static void muestraCategorias() throws SQLException {
        Statement sentencia = connection.createStatement();
        ResultSet rs = sentencia.executeQuery("SELECT * FROM categorias");

        while (rs.next()) {
            String fila
                    = rs.getInt("IdCategoria") + " "
                    + rs.getString("NombreCategoria") + " "
                    + rs.getString("Descripcion");

            System.out.println(fila);

        }

    }

    private static int getMaxIdCategoria() throws SQLException {
        Statement sentencia = connection.createStatement();
        ResultSet rs = sentencia.executeQuery("SELECT MAX(IdCategoria) FROM categorias");
        int maxIdCategoria = 0;
        while (rs.next()) {
            maxIdCategoria = rs.getInt(1);

        }
        System.out.println(maxIdCategoria);
        return maxIdCategoria;
    }
    
    
    private static boolean insertarCategoria(String nombre, String descripcion) throws SQLException {
        int idCategoria = getMaxIdCategoria() + 1;
        Statement sentencia = connection.createStatement();
        String sql = "INSERT INTO Categorias(IdCategoria, NombreCategoria, Descripcion)"
                + "VALUES (" + idCategoria + ",'" + nombre + "', '" + descripcion + "')";
        return(sentencia.executeUpdate(sql) > 0);
        
    }
    
      private static boolean modificaCategoria(int idCategoria, String atributo, String valor) throws SQLException {
        Statement sentencia = connection.createStatement();
        String sql = "UPDATE Categorias SET " + atributo + " = '" + valor + "' "
                + "WHERE IdCategoria = " + idCategoria;
        return(sentencia.executeUpdate(sql) > 0);
        
    }

    
    
    

}
