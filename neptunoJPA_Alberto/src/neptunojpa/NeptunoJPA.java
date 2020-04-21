/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neptunojpa;

import Controllers.CategoriasJpaController;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author alumno
 */
public class NeptunoJPA {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("neptunoJPAPU");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // modificaCategoria(11, "El mismo objeto modificado");
            createCategoriaWithJPAController();
        } catch (SQLException ex) {
            Logger.getLogger(NeptunoJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(NeptunoJPA.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public static void persist(Object object) {
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
        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Categorias.findByIdCategoria");
        query.setParameter("idCategoria", idCategoria);
        Categorias categoria = (Categorias) query.getSingleResult();
        categoria.setDescripcion(valor);
        em.getTransaction().begin();
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

    private static void createCategoriaWithJPAController() throws Exception {
        CategoriasJpaController categoriaJpaController
                = new CategoriasJpaController(emf);
        Categorias categoria = new Categorias();
        categoria.setNombreCategoria("conControlador");
        categoria.setDescripcion("Creada con un JPA Controller");
        categoriaJpaController.create(categoria);
    }
}
