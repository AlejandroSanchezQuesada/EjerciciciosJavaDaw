package examenjdbcjpa;

import CONTROLLERS.TodosJpaController;
import CONTROLLERS.UsersJpaController;
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

public class ExamenJDBCJPA {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("Introduzca una opcion");
            System.out.println("JDBC");
            System.out.println("-------------------------");
            System.out.println("1 Inserta usuario");
            System.out.println("2 Mostrar eventos pendientes");
            System.out.println("3 Marcar como completados");
            System.out.println("");
            System.out.println("JPA");
            System.out.println("-------------------------");
            System.out.println("4 Inserta usuario");
            System.out.println("5 Mostrar eventos pendientes");
            System.out.println("6 Marcar como completados");
            System.out.println("========================");
            System.out.println("0 para salir");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    insertaUsuario();
                    break;
                case 2:
                    eventosPendientes();
                    break;
                case 3:
                    completados();
                    break;
                case 4:
                    insertaUsuarioJPA();
                    break;
                case 5:
                    eventosPendientesJPA();
                    break;
                case 6:
                    completadosJPA();
                    break;
            }

        } while (opcion != 0);

    }

    private static void insertaUsuario() {
        final String URL = "jdbc:mysql://localhost/eventospendientes";
        final String USER = "root";
        final String PASSWORD = "";
        Connection conexion = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte nombre");
        String nombre = sc.nextLine();
        System.out.println("Inserte contraseña");
        String contrasena = sc.nextLine();
        System.out.println("Inserte nre");
        String nre = sc.nextLine();
        String email = nre + "@alu.murciaeduca.es";

        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();

            String sql = ("INSERT INTO users(name,email,password) VALUES('" + nombre + "','" + email + "','" + contrasena + "');");
            sentencia.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(ExamenJDBCJPA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void eventosPendientes() {
        final String URL = "jdbc:mysql://localhost/eventospendientes";
        final String USER = "root";
        final String PASSWORD = "";
        Connection conexion = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte email");
        String email = sc.nextLine();
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();
            ResultSet resultado = sentencia.executeQuery("SELECT title from users,todos where users.id = todos.user_id and email='" + email + "' and isComplete=0");

            while (resultado.next()) {

                System.out.println(resultado.getString(resultado.findColumn("title")));

            }

        } catch (SQLException ex) {
            Logger.getLogger(ExamenJDBCJPA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void completados() {
        final String URL = "jdbc:mysql://localhost/eventospendientes";
        final String USER = "root";
        final String PASSWORD = "";
        Connection conexion = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte email");
        String email = sc.nextLine();

        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement sentencia = conexion.createStatement();
            String sql = "UPDATE todos SET isComplete=1 WHERE user_id = (SELECT id from users where email ='" + email + "')";
            sentencia.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(ExamenJDBCJPA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void insertaUsuarioJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamenJDBCJPAPU");
        UsersJpaController userscontrol = new UsersJpaController(emf);

        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte nombre");
        String nombre = sc.nextLine();
        System.out.println("Inserte contraseña");
        String contrasena = sc.nextLine();
        System.out.println("Inserte nre");
        String nre = sc.nextLine();
        String email = nre + "@alu.murciaeduca.es";

        Users usuarioNuevo = new Users();

        usuarioNuevo.setName(nombre);
        usuarioNuevo.setPassword(contrasena);
        usuarioNuevo.setEmail(email);

        userscontrol.create(usuarioNuevo);
        System.out.println("Usuario creado con exito");

    }

    private static void eventosPendientesJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamenJDBCJPAPU");
        UsersJpaController userscontrol = new UsersJpaController(emf);
        TodosJpaController todoscontrol = new TodosJpaController(emf);

        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte email");
        String email = sc.nextLine();

        List<Users> ListaUsuarioEmail = userscontrol.encuentraEmail(email);
        Users usuario = ListaUsuarioEmail.get(0);
        List<Todos> ListaEmailTodos = todoscontrol.EncuentraIdUser(usuario);
        Todos usuarioTodos = ListaEmailTodos.get(0);

        List<Todos> ResultadoFinal = todoscontrol.EncuentraNoCompletados(usuarioTodos);

        for (int i = 0; i < ResultadoFinal.size(); i++) {
            long r = ResultadoFinal.get(i).getUserId().getId();
            if (r == usuario.getId()) {
                System.out.println(ResultadoFinal.get(i).getTitle());
            }

        }

    }

    private static void completadosJPA() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamenJDBCJPAPU");
        UsersJpaController userscontrol = new UsersJpaController(emf);
        TodosJpaController todoscontrol = new TodosJpaController(emf);

        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte email");
        String email = sc.nextLine();

        List<Users> ListaUsuarioEmail = userscontrol.encuentraEmail(email);
        Users usuario = ListaUsuarioEmail.get(0);

        List<Todos> ListaEmailTodos = todoscontrol.EncuentraIdUser(usuario);
        Todos usuarioTodos = ListaEmailTodos.get(0);

        List<Todos> ResultadoFinal = todoscontrol.EncuentraNoCompletados(usuarioTodos);

        for (int i = 0; i < ResultadoFinal.size(); i++) {
            long r = ResultadoFinal.get(i).getUserId().getId();
            if (r == usuario.getId()) {
                Todos t = ResultadoFinal.get(i);
                t.setIsComplete(true);

                try {
                    todoscontrol.edit(t);
                } catch (Exception ex) {
                    Logger.getLogger(ExamenJDBCJPA.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }

    //--------------------------------------------------------------------------------------------------------------
    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamenJDBCJPAPU");
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
