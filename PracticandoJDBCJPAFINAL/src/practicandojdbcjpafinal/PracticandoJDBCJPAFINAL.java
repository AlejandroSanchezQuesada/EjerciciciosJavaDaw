package practicandojdbcjpafinal;

import CONTROLLERS.ClientesJpaController;
import CONTROLLERS.DetallespedidosJpaController;
import CONTROLLERS.EmpleadosJpaController;
import CONTROLLERS.PedidosJpaController;
import CONTROLLERS.exceptions.NonexistentEntityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PracticandoJDBCJPAFINAL {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {

            System.out.println("---------JDBC----------");
            System.out.println("-----------------------");
            System.out.println("1 - Mostrar todos los empleados");
            System.out.println("2 - Mostrar todos los clientes");
            System.out.println("3 - Mostrar todos los pedidos");
            System.out.println("4 - Insertar empleado");
            System.out.println("5 - Asignar jefe");
            System.out.println("6 - Mostrar Coste Pedido");
            System.out.println("---------JPA-----------");
            System.out.println("-----------------------");
            System.out.println("7 - Mostrar todos los empleados");
            System.out.println("8 - Mostrar todos los clientes");
            System.out.println("9 - Mostrar todos los pedidos");
            System.out.println("10 - Insertar empleado");
            System.out.println("11 - Asignar jefe");
            System.out.println("12 - Mostrar Coste Pedido");

            System.out.println("Selecciona opcion");
            opcion = sc.nextInt();

            if (opcion == 1) {
                muestraEmpleadosJDBC();
            } else if (opcion == 2) {
                muestraClientesJDBC();
            } else if (opcion == 3) {
                muestraPedidosJDBC();
            } else if (opcion == 4) {
                insertaEmpleadosJDBC();
            } else if (opcion == 5) {

            } else if (opcion == 6) {
                costePedidoJDBC();
            } else if (opcion == 7) {
                muestraEmpleadosJPA();
            } else if (opcion == 8) {
                muestraClientesJPA();
            } else if (opcion == 9) {
                muestraPedidosJPA();
            } else if (opcion == 10) {
                insertarEmpleadoJPA();
            } else if (opcion == 11) {
                asignarJefeJPA();
            } else if (opcion == 12) {
costePedidoJPA();
            }

        } while (opcion != 0);

    }

    public static void muestraEmpleadosJDBC() {
        final String URL = "jdbc:mysql://localhost/neptuno";
        final String USER = "root";
        final String PASSWORD = "";
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery("SELECT * FROM empleados");

            while (resultado.next()) {

                System.out.println(resultado.getInt(resultado.findColumn("IdEmpleado")) + " - "
                        + resultado.getString(resultado.findColumn("Nombre")) + " - "
                        + resultado.getString(resultado.findColumn("Apellidos")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(PracticandoJDBCJPAFINAL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void muestraClientesJDBC() {
        final String URL = "jdbc:mysql://localhost/neptuno";
        final String USER = "root";
        final String PASSWORD = "";
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM clientes");

            while (resultado.next()) {
                System.out.println(resultado.getString(resultado.findColumn("IdCliente")) + " - "
                        + resultado.getString(resultado.findColumn("NombreCompany")) + " - "
                        + resultado.getString(resultado.findColumn("NombreContacto")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(PracticandoJDBCJPAFINAL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void muestraPedidosJDBC() {
        final String URL = "jdbc:mysql://localhost/neptuno";
        final String USER = "root";
        final String PASSWORD = "";
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT * FROM pedidos");

            while (resultado.next()) {
                System.out.println(resultado.getInt(resultado.findColumn("IdPedido")) + " - "
                        + resultado.getString(resultado.findColumn("IdCliente")) + " - "
                        + resultado.getInt(resultado.findColumn("IdEmpleado"))
                );

            }

        } catch (SQLException ex) {
            Logger.getLogger(PracticandoJDBCJPAFINAL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void insertaEmpleadosJDBC() {
        final String URL = "jdbc:mysql://localhost/neptuno";
        final String USER = "root";
        final String PASSWORD = "";
        Connection conexion = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserte nombre");
        String nombre = sc.nextLine();
        System.out.println("Inserte apellido");
        String apellido = sc.nextLine();

        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();

            String sql = ("INSERT INTO empleados(Apellidos,Nombre) VALUES('" + apellido + "','" + nombre + "');");

            sentencia.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(PracticandoJDBCJPAFINAL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void costePedidoJDBC() {
        final String URL = "jdbc:mysql://localhost/neptuno";
        final String USER = "root";
        final String PASSWORD = "";
        Connection conexion = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("Inserte IdPedido para saber su coste");
        int idPedido = sc.nextInt();

        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT SUM(PrecioUnidad*Cantidad)*(1-Descuento) AS suma FROM detallespedidos WHERE idPedido =" + idPedido);

            while (resultado.next()) {
                System.out.println(resultado.getFloat(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PracticandoJDBCJPAFINAL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void muestraEmpleadosJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PracticandoJDBCJPAFINALPU");
        EmpleadosJpaController empleadosController = new EmpleadosJpaController(emf);

        List<Empleados> ListaEmpleados = empleadosController.findEmpleadosTodos();

        for (int i = 0; i < ListaEmpleados.size(); i++) {
            System.out.println(ListaEmpleados.get(i).getIdEmpleado() + " - ");
            System.out.print(ListaEmpleados.get(i).getNombre() + " - ");
            System.out.print(ListaEmpleados.get(i).getApellidos());

        }
        System.out.println("");

    }

    public static void muestraClientesJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PracticandoJDBCJPAFINALPU");
        ClientesJpaController clientesController = new ClientesJpaController(emf);

        List<Clientes> ListaClientes = clientesController.findClientesTodos();

        for (int i = 0; i < ListaClientes.size(); i++) {
            System.out.println(ListaClientes.get(i).getIdCliente() + " - ");
            System.out.print(ListaClientes.get(i).getNombreCompany() + " - ");
            System.out.print(ListaClientes.get(i).getNombreContacto());

        }
        System.out.println("");

    }

    public static void muestraPedidosJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PracticandoJDBCJPAFINALPU");
        PedidosJpaController pedidosController = new PedidosJpaController(emf);

        List<Pedidos> ListaPedidos = pedidosController.findPedidosTodos();

        for (int i = 0; i < ListaPedidos.size(); i++) {

            System.out.println(ListaPedidos.get(i).getIdPedido() + " - ");
            System.out.print(ListaPedidos.get(i).getCiudadDestinatario() + " - ");
            System.out.print(ListaPedidos.get(i).getFechaPedido());

        }
        System.out.println("");

    }

    public static void insertarEmpleadoJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PracticandoJDBCJPAFINALPU");
        EmpleadosJpaController empleadosController = new EmpleadosJpaController(emf);
        Scanner sc = new Scanner(System.in);
        Empleados nuevoEmpleado = new Empleados();

        System.out.println("Dime nombre del empleado");
        String nombre = sc.nextLine();
        System.out.println("Dime su apellido");
        String apellido = sc.nextLine();

        nuevoEmpleado.setNombre(nombre);
        nuevoEmpleado.setApellidos(apellido);

        empleadosController.create(nuevoEmpleado);

    }

    public static void asignarJefeJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PracticandoJDBCJPAFINALPU");
        EmpleadosJpaController empleadosController = new EmpleadosJpaController(emf);
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Dime idEmpleado del Jefe");
        int idJefe = sc.nextInt();
        System.out.println("Dime idEmpleado del Subdito");
        int idSubdito = sc.nextInt();
        
        List<Empleados>ListaJefe = empleadosController.findEmpleadoPorIdEmpleado(idJefe);
        List<Empleados>ListaSubdito = empleadosController.findEmpleadoPorIdEmpleado(idSubdito);
        
        Empleados jefe = ListaJefe.get(0);
        Empleados subdito = ListaSubdito.get(0);
        
        
        subdito.setJefe(jefe);
        
        try {
            empleadosController.edit(subdito);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PracticandoJDBCJPAFINAL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PracticandoJDBCJPAFINAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }

    private static void costePedidoJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PracticandoJDBCJPAFINALPU");
        DetallespedidosJpaController dpController = new DetallespedidosJpaController(emf);
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("Inserta idPedido del Pedido que quieras saber su coste");
        int idPedido = sc.nextInt();
        float suma = 0;
        int cantidad = 0;
        float unidad;
        float descuento = 0;
        
        List<Detallespedidos>ListaPedidos  = dpController.findDetallespedidosPorIdPedido(idPedido);
        
        for (int i = 0; i < ListaPedidos.size(); i++) {
            
            cantidad = ListaPedidos.get(i).getCantidad();
            unidad = ListaPedidos.get(i).getPrecioUnidad().floatValue();
            descuento = ListaPedidos.get(i).getDescuento();
            
            suma = suma+(cantidad*unidad)*(1-descuento);
            
        }
        
        System.out.println("Coste total pedido = "+suma);
        
        
    }
    

//-------------------------------------------------------------------------------------------------
    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PracticandoJDBCJPAFINALPU");
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
