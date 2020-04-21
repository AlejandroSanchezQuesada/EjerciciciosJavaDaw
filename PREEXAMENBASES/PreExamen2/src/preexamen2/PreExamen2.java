package preexamen2;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import preexamen2.CONTROLLERS.DetallespedidosJpaController;
import preexamen2.CONTROLLERS.EmpleadosJpaController;
import preexamen2.CONTROLLERS.PedidosJpaController;
import preexamen2.CONTROLLERS.exceptions.NonexistentEntityException;

public class PreExamen2 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("Introduzca una opcion");
            System.out.println("JDBC");
            System.out.println("-------------------------");
            System.out.println("1 Coste pedido");
            System.out.println("2 Inserta empleado");
            System.out.println("3 Asignar jefe");
            System.out.println("");
            System.out.println("JPA");
            System.out.println("-------------------------");
            System.out.println("4 Coste pedido");
            System.out.println("5 Inserta empleado");
            System.out.println("6 Asignar jefe");
            System.out.println("========================");
            System.out.println("0 para salir");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    costePedido();
                    break;
                case 2:
                    InsertaEmpleado();
                    break;
                case 3:
                    asignaJefe();
                    break;
                case 4:
                    costePedidoJPA();
                    break;
                case 5:
                    insertaEmpleadoJPA();
                    break;
                case 6:
                    asignaJefeJPA();
                    break;
            }

        } while (opcion != 0);

    }

    public static void costePedido() {
        final String URL = "jdbc:mysql://localhost/neptuno";
        final String USER = "root";
        final String PASSWORD = "";
        Connection conexion = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte IdPedido");
        int idpedido = sc.nextInt();
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery("SELECT SUM(PrecioUnidad*Cantidad)*(1-Descuento) AS suma FROM detallespedidos "
                    + "WHERE IdPedido =" + idpedido);

            while (resultado.next()) {
                System.out.println(resultado.getFloat(resultado.findColumn("suma")));

            }

        } catch (Exception e) {
        }

    }

    public static void InsertaEmpleado() {
        final String URL = "jdbc:mysql://localhost/neptuno";
        final String USER = "root";
        final String PASSWORD = "";
        Connection conexion = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte Nombre");
        String nombre = sc.nextLine();
        System.out.println("Inserte Apellidos");
        String apellido = sc.nextLine();
        java.sql.Date fecha = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        System.out.println(fecha);
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();
            String sql = ("INSERT INTO empleados(Apellidos,Nombre,FechaContratacion) VALUES ('" + apellido + "','" + nombre + "','" + fecha + "');");
            //String sql = ("INSERT INTO empleados(Apellidos,Nombre) VALUES ('"+apellido+"','"+nombre+"')");
            sentencia.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(PreExamen2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void asignaJefe() {
        final String URL = "jdbc:mysql://localhost/neptuno";
        final String USER = "root";
        final String PASSWORD = "";
        Connection conexion = null;
        Scanner sc = new Scanner(System.in);

        //Variables
        int subdito;
        int jefazo;

        System.out.println("Inserta IdEmpleado que será el subdito!");
        subdito = sc.nextInt();
        System.out.println("Inserta el IdEmpleado que será el jefazo");
        jefazo = sc.nextInt();

        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();
            String sql = "UPDATE empleados SET jefe ='" + jefazo + "' WHERE IdEmpleado ='" + subdito + "'";
            sentencia.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(PreExamen2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void costePedidoJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PreExamen2PU");
        DetallespedidosJpaController dPedidosController = new DetallespedidosJpaController(emf);
        Scanner sc = new Scanner(System.in);
        int idPedido = sc.nextInt();
        float suma = 0;
        int cantidad = 0;
        float unidad;
        float descuento = 0;

        List<Detallespedidos> listaDetalles = (dPedidosController.findDetallespedidosByIdPedido(idPedido));

        for (int i = 0; i < listaDetalles.size(); i++) {

            cantidad = listaDetalles.get(i).getCantidad();
            unidad = listaDetalles.get(i).getPrecioUnidad().floatValue();
            descuento = listaDetalles.get(i).getDescuento();
            suma = suma + ((cantidad * unidad) * (1 - descuento));
        }

        System.out.println("EL COSTE TOTAL DEL PEDIDO ES " + suma);
    }

    public static void insertaEmpleadoJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PreExamen2PU");
        EmpleadosJpaController empleadosController = new EmpleadosJpaController(emf);
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserte nombre empleado");
        String nombre = sc.nextLine();
        System.out.println("Inserte apellidos empleado");
        String apellidos = sc.nextLine();

        java.sql.Date fecha = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        Empleados empleadoNuevo = new Empleados();

        empleadoNuevo.setNombre(nombre);
        empleadoNuevo.setApellidos(apellidos);
        empleadoNuevo.setFechaContratacion(fecha);

        empleadosController.create(empleadoNuevo);

    }

    public static void asignaJefeJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PreExamen2PU");
        EmpleadosJpaController empleadosController = new EmpleadosJpaController(emf);

        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte IdEmpleado del subdito!");
        short subdito = sc.nextShort();
        System.out.println("Iserte IdEmpleado del jefazo");
        int jefazo = sc.nextInt();
        
        List<Empleados>Subdito = empleadosController.findByIdEmpleado(subdito);
        List<Empleados>Jefe = empleadosController.findByIdEmpleado(jefazo);
        Empleados jeff = Jefe.get(0);
        Empleados minion = Subdito.get(0);
       
        minion.setJefe(jeff);
        
        try {
            empleadosController.edit(minion);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PreExamen2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PreExamen2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println("Realizado");
        
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PreExamen2PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
