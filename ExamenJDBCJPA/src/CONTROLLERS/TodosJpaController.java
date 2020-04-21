/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import CONTROLLERS.exceptions.NonexistentEntityException;
import examenjdbcjpa.Todos;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import examenjdbcjpa.Users;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author alexk
 */
public class TodosJpaController implements Serializable {

    public TodosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Todos todos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users userId = todos.getUserId();
            if (userId != null) {
                userId = em.getReference(userId.getClass(), userId.getId());
                todos.setUserId(userId);
            }
            em.persist(todos);
            if (userId != null) {
                userId.getTodosCollection().add(todos);
                userId = em.merge(userId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Todos todos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Todos persistentTodos = em.find(Todos.class, todos.getId());
            Users userIdOld = persistentTodos.getUserId();
            Users userIdNew = todos.getUserId();
            if (userIdNew != null) {
                userIdNew = em.getReference(userIdNew.getClass(), userIdNew.getId());
                todos.setUserId(userIdNew);
            }
            todos = em.merge(todos);
            if (userIdOld != null && !userIdOld.equals(userIdNew)) {
                userIdOld.getTodosCollection().remove(todos);
                userIdOld = em.merge(userIdOld);
            }
            if (userIdNew != null && !userIdNew.equals(userIdOld)) {
                userIdNew.getTodosCollection().add(todos);
                userIdNew = em.merge(userIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = todos.getId();
                if (findTodos(id) == null) {
                    throw new NonexistentEntityException("The todos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Todos todos;
            try {
                todos = em.getReference(Todos.class, id);
                todos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The todos with id " + id + " no longer exists.", enfe);
            }
            Users userId = todos.getUserId();
            if (userId != null) {
                userId.getTodosCollection().remove(todos);
                userId = em.merge(userId);
            }
            em.remove(todos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Todos> findTodosEntities() {
        return findTodosEntities(true, -1, -1);
    }

    public List<Todos> findTodosEntities(int maxResults, int firstResult) {
        return findTodosEntities(false, maxResults, firstResult);
    }

    private List<Todos> findTodosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Todos.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Todos findTodos(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Todos.class, id);
        } finally {
            em.close();
        }
    }
    
    
    public List<Todos>EncuentraIdUser(Users usuario){
    EntityManager em = getEntityManager();
    Query q = em.createNamedQuery("Todos.findById");
    q.setParameter("id", usuario.getId());
    return q.getResultList();
     
    
    }
    
    public List<Todos>EncuentraNoCompletados(Todos usuario){
    EntityManager em = getEntityManager();
    Query q = em.createNamedQuery("Todos.findByIsComplete");
    q.setParameter("isComplete", false);
    return q.getResultList();
    
    
    
    }
    

    public int getTodosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Todos> rt = cq.from(Todos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
