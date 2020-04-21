/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import CONTROLLERS.exceptions.IllegalOrphanException;
import CONTROLLERS.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import examenjdbcjpa.Todos;
import examenjdbcjpa.Users;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author alexk
 */
public class UsersJpaController implements Serializable {

    public UsersJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Users users) {
        if (users.getTodosCollection() == null) {
            users.setTodosCollection(new ArrayList<Todos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Todos> attachedTodosCollection = new ArrayList<Todos>();
            for (Todos todosCollectionTodosToAttach : users.getTodosCollection()) {
                todosCollectionTodosToAttach = em.getReference(todosCollectionTodosToAttach.getClass(), todosCollectionTodosToAttach.getId());
                attachedTodosCollection.add(todosCollectionTodosToAttach);
            }
            users.setTodosCollection(attachedTodosCollection);
            em.persist(users);
            for (Todos todosCollectionTodos : users.getTodosCollection()) {
                Users oldUserIdOfTodosCollectionTodos = todosCollectionTodos.getUserId();
                todosCollectionTodos.setUserId(users);
                todosCollectionTodos = em.merge(todosCollectionTodos);
                if (oldUserIdOfTodosCollectionTodos != null) {
                    oldUserIdOfTodosCollectionTodos.getTodosCollection().remove(todosCollectionTodos);
                    oldUserIdOfTodosCollectionTodos = em.merge(oldUserIdOfTodosCollectionTodos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Users users) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users persistentUsers = em.find(Users.class, users.getId());
            Collection<Todos> todosCollectionOld = persistentUsers.getTodosCollection();
            Collection<Todos> todosCollectionNew = users.getTodosCollection();
            List<String> illegalOrphanMessages = null;
            for (Todos todosCollectionOldTodos : todosCollectionOld) {
                if (!todosCollectionNew.contains(todosCollectionOldTodos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Todos " + todosCollectionOldTodos + " since its userId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Todos> attachedTodosCollectionNew = new ArrayList<Todos>();
            for (Todos todosCollectionNewTodosToAttach : todosCollectionNew) {
                todosCollectionNewTodosToAttach = em.getReference(todosCollectionNewTodosToAttach.getClass(), todosCollectionNewTodosToAttach.getId());
                attachedTodosCollectionNew.add(todosCollectionNewTodosToAttach);
            }
            todosCollectionNew = attachedTodosCollectionNew;
            users.setTodosCollection(todosCollectionNew);
            users = em.merge(users);
            for (Todos todosCollectionNewTodos : todosCollectionNew) {
                if (!todosCollectionOld.contains(todosCollectionNewTodos)) {
                    Users oldUserIdOfTodosCollectionNewTodos = todosCollectionNewTodos.getUserId();
                    todosCollectionNewTodos.setUserId(users);
                    todosCollectionNewTodos = em.merge(todosCollectionNewTodos);
                    if (oldUserIdOfTodosCollectionNewTodos != null && !oldUserIdOfTodosCollectionNewTodos.equals(users)) {
                        oldUserIdOfTodosCollectionNewTodos.getTodosCollection().remove(todosCollectionNewTodos);
                        oldUserIdOfTodosCollectionNewTodos = em.merge(oldUserIdOfTodosCollectionNewTodos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = users.getId();
                if (findUsers(id) == null) {
                    throw new NonexistentEntityException("The users with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users users;
            try {
                users = em.getReference(Users.class, id);
                users.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The users with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Todos> todosCollectionOrphanCheck = users.getTodosCollection();
            for (Todos todosCollectionOrphanCheckTodos : todosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Users (" + users + ") cannot be destroyed since the Todos " + todosCollectionOrphanCheckTodos + " in its todosCollection field has a non-nullable userId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(users);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Users> findUsersEntities() {
        return findUsersEntities(true, -1, -1);
    }

    public List<Users> findUsersEntities(int maxResults, int firstResult) {
        return findUsersEntities(false, maxResults, firstResult);
    }

    private List<Users> findUsersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Users.class));
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

    public Users findUsers(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Users.class, id);
        } finally {
            em.close();
        }
    }
    
    public List<Users> encuentraEmail(String _email){
    EntityManager em = getEntityManager();
    Query q = em.createNamedQuery("Users.findByEmail");
    q.setParameter("email", _email);
    
    return q.getResultList();
    
    
    }
    
    

    public int getUsersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Users> rt = cq.from(Users.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
