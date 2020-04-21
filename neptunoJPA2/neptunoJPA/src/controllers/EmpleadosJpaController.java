/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.exceptions.IllegalOrphanException;
import controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Empleados;
import entities.Pedidos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author alumno
 */
public class EmpleadosJpaController implements Serializable {

    public EmpleadosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleados empleados) {
        if (empleados.getPedidosCollection() == null) {
            empleados.setPedidosCollection(new ArrayList<Pedidos>());
        }
        if (empleados.getEmpleadosCollection() == null) {
            empleados.setEmpleadosCollection(new ArrayList<Empleados>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados jefe = empleados.getJefe();
            if (jefe != null) {
                jefe = em.getReference(jefe.getClass(), jefe.getIdEmpleado());
                empleados.setJefe(jefe);
            }
            Collection<Pedidos> attachedPedidosCollection = new ArrayList<Pedidos>();
            for (Pedidos pedidosCollectionPedidosToAttach : empleados.getPedidosCollection()) {
                pedidosCollectionPedidosToAttach = em.getReference(pedidosCollectionPedidosToAttach.getClass(), pedidosCollectionPedidosToAttach.getIdPedido());
                attachedPedidosCollection.add(pedidosCollectionPedidosToAttach);
            }
            empleados.setPedidosCollection(attachedPedidosCollection);
            Collection<Empleados> attachedEmpleadosCollection = new ArrayList<Empleados>();
            for (Empleados empleadosCollectionEmpleadosToAttach : empleados.getEmpleadosCollection()) {
                empleadosCollectionEmpleadosToAttach = em.getReference(empleadosCollectionEmpleadosToAttach.getClass(), empleadosCollectionEmpleadosToAttach.getIdEmpleado());
                attachedEmpleadosCollection.add(empleadosCollectionEmpleadosToAttach);
            }
            empleados.setEmpleadosCollection(attachedEmpleadosCollection);
            em.persist(empleados);
            if (jefe != null) {
                jefe.getEmpleadosCollection().add(empleados);
                jefe = em.merge(jefe);
            }
            for (Pedidos pedidosCollectionPedidos : empleados.getPedidosCollection()) {
                Empleados oldIdEmpleadoOfPedidosCollectionPedidos = pedidosCollectionPedidos.getIdEmpleado();
                pedidosCollectionPedidos.setIdEmpleado(empleados);
                pedidosCollectionPedidos = em.merge(pedidosCollectionPedidos);
                if (oldIdEmpleadoOfPedidosCollectionPedidos != null) {
                    oldIdEmpleadoOfPedidosCollectionPedidos.getPedidosCollection().remove(pedidosCollectionPedidos);
                    oldIdEmpleadoOfPedidosCollectionPedidos = em.merge(oldIdEmpleadoOfPedidosCollectionPedidos);
                }
            }
            for (Empleados empleadosCollectionEmpleados : empleados.getEmpleadosCollection()) {
                Empleados oldJefeOfEmpleadosCollectionEmpleados = empleadosCollectionEmpleados.getJefe();
                empleadosCollectionEmpleados.setJefe(empleados);
                empleadosCollectionEmpleados = em.merge(empleadosCollectionEmpleados);
                if (oldJefeOfEmpleadosCollectionEmpleados != null) {
                    oldJefeOfEmpleadosCollectionEmpleados.getEmpleadosCollection().remove(empleadosCollectionEmpleados);
                    oldJefeOfEmpleadosCollectionEmpleados = em.merge(oldJefeOfEmpleadosCollectionEmpleados);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleados empleados) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados persistentEmpleados = em.find(Empleados.class, empleados.getIdEmpleado());
            Empleados jefeOld = persistentEmpleados.getJefe();
            Empleados jefeNew = empleados.getJefe();
            Collection<Pedidos> pedidosCollectionOld = persistentEmpleados.getPedidosCollection();
            Collection<Pedidos> pedidosCollectionNew = empleados.getPedidosCollection();
            Collection<Empleados> empleadosCollectionOld = persistentEmpleados.getEmpleadosCollection();
            Collection<Empleados> empleadosCollectionNew = empleados.getEmpleadosCollection();
            List<String> illegalOrphanMessages = null;
            for (Pedidos pedidosCollectionOldPedidos : pedidosCollectionOld) {
                if (!pedidosCollectionNew.contains(pedidosCollectionOldPedidos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pedidos " + pedidosCollectionOldPedidos + " since its idEmpleado field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (jefeNew != null) {
                jefeNew = em.getReference(jefeNew.getClass(), jefeNew.getIdEmpleado());
                empleados.setJefe(jefeNew);
            }
            Collection<Pedidos> attachedPedidosCollectionNew = new ArrayList<Pedidos>();
            for (Pedidos pedidosCollectionNewPedidosToAttach : pedidosCollectionNew) {
                pedidosCollectionNewPedidosToAttach = em.getReference(pedidosCollectionNewPedidosToAttach.getClass(), pedidosCollectionNewPedidosToAttach.getIdPedido());
                attachedPedidosCollectionNew.add(pedidosCollectionNewPedidosToAttach);
            }
            pedidosCollectionNew = attachedPedidosCollectionNew;
            empleados.setPedidosCollection(pedidosCollectionNew);
            Collection<Empleados> attachedEmpleadosCollectionNew = new ArrayList<Empleados>();
            for (Empleados empleadosCollectionNewEmpleadosToAttach : empleadosCollectionNew) {
                empleadosCollectionNewEmpleadosToAttach = em.getReference(empleadosCollectionNewEmpleadosToAttach.getClass(), empleadosCollectionNewEmpleadosToAttach.getIdEmpleado());
                attachedEmpleadosCollectionNew.add(empleadosCollectionNewEmpleadosToAttach);
            }
            empleadosCollectionNew = attachedEmpleadosCollectionNew;
            empleados.setEmpleadosCollection(empleadosCollectionNew);
            empleados = em.merge(empleados);
            if (jefeOld != null && !jefeOld.equals(jefeNew)) {
                jefeOld.getEmpleadosCollection().remove(empleados);
                jefeOld = em.merge(jefeOld);
            }
            if (jefeNew != null && !jefeNew.equals(jefeOld)) {
                jefeNew.getEmpleadosCollection().add(empleados);
                jefeNew = em.merge(jefeNew);
            }
            for (Pedidos pedidosCollectionNewPedidos : pedidosCollectionNew) {
                if (!pedidosCollectionOld.contains(pedidosCollectionNewPedidos)) {
                    Empleados oldIdEmpleadoOfPedidosCollectionNewPedidos = pedidosCollectionNewPedidos.getIdEmpleado();
                    pedidosCollectionNewPedidos.setIdEmpleado(empleados);
                    pedidosCollectionNewPedidos = em.merge(pedidosCollectionNewPedidos);
                    if (oldIdEmpleadoOfPedidosCollectionNewPedidos != null && !oldIdEmpleadoOfPedidosCollectionNewPedidos.equals(empleados)) {
                        oldIdEmpleadoOfPedidosCollectionNewPedidos.getPedidosCollection().remove(pedidosCollectionNewPedidos);
                        oldIdEmpleadoOfPedidosCollectionNewPedidos = em.merge(oldIdEmpleadoOfPedidosCollectionNewPedidos);
                    }
                }
            }
            for (Empleados empleadosCollectionOldEmpleados : empleadosCollectionOld) {
                if (!empleadosCollectionNew.contains(empleadosCollectionOldEmpleados)) {
                    empleadosCollectionOldEmpleados.setJefe(null);
                    empleadosCollectionOldEmpleados = em.merge(empleadosCollectionOldEmpleados);
                }
            }
            for (Empleados empleadosCollectionNewEmpleados : empleadosCollectionNew) {
                if (!empleadosCollectionOld.contains(empleadosCollectionNewEmpleados)) {
                    Empleados oldJefeOfEmpleadosCollectionNewEmpleados = empleadosCollectionNewEmpleados.getJefe();
                    empleadosCollectionNewEmpleados.setJefe(empleados);
                    empleadosCollectionNewEmpleados = em.merge(empleadosCollectionNewEmpleados);
                    if (oldJefeOfEmpleadosCollectionNewEmpleados != null && !oldJefeOfEmpleadosCollectionNewEmpleados.equals(empleados)) {
                        oldJefeOfEmpleadosCollectionNewEmpleados.getEmpleadosCollection().remove(empleadosCollectionNewEmpleados);
                        oldJefeOfEmpleadosCollectionNewEmpleados = em.merge(oldJefeOfEmpleadosCollectionNewEmpleados);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = empleados.getIdEmpleado();
                if (findEmpleados(id) == null) {
                    throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Short id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleados empleados;
            try {
                empleados = em.getReference(Empleados.class, id);
                empleados.getIdEmpleado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleados with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Pedidos> pedidosCollectionOrphanCheck = empleados.getPedidosCollection();
            for (Pedidos pedidosCollectionOrphanCheckPedidos : pedidosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empleados (" + empleados + ") cannot be destroyed since the Pedidos " + pedidosCollectionOrphanCheckPedidos + " in its pedidosCollection field has a non-nullable idEmpleado field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Empleados jefe = empleados.getJefe();
            if (jefe != null) {
                jefe.getEmpleadosCollection().remove(empleados);
                jefe = em.merge(jefe);
            }
            Collection<Empleados> empleadosCollection = empleados.getEmpleadosCollection();
            for (Empleados empleadosCollectionEmpleados : empleadosCollection) {
                empleadosCollectionEmpleados.setJefe(null);
                empleadosCollectionEmpleados = em.merge(empleadosCollectionEmpleados);
            }
            em.remove(empleados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleados> findEmpleadosEntities() {
        return findEmpleadosEntities(true, -1, -1);
    }

    public List<Empleados> findEmpleadosEntities(int maxResults, int firstResult) {
        return findEmpleadosEntities(false, maxResults, firstResult);
    }

    private List<Empleados> findEmpleadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleados.class));
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

    public Empleados findEmpleados(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleados.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleados> rt = cq.from(Empleados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
