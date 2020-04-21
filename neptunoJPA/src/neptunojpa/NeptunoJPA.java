/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neptunojpa;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JFrame;
import views.CategoriasProductosForm;

/**
 *
 * @author alexk
 */
public class NeptunoJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //modificaCategoria(11,"Ahora modificado con JPA en Persistence");

        //muestraClientes();
        //anadirClientes("df","ALEJANDRO");
        
        JFrame frame = new JFrame();
        frame.setContentPane(new CategoriasProductosForm());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        
        
        
        
        
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("neptunoJPAPU");
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

    private static void modificaCategoria(int idCategoria, String valor) throws SQLException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("neptunoJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createNamedQuery("Categorias.findByIdCategoria");
        query.setParameter("idCategoria", idCategoria);

        Categorias categoria = (Categorias) query.getSingleResult();

        categoria.setDescripcion(valor);

        try {
            em.persist(categoria);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

    }

    private static void muestraClientes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("neptunoJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createNamedQuery("Clientes.findAll");

        System.out.println(query.getResultList());
        System.out.println("---------------------");

    }

    private static void anadirClientes(String nombCompany, String nombContacto) {
        String idCliente = nombContacto.substring(0, 5);

        System.out.println(idCliente);

    }

}
