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
import neptunojpa.Clientes;
import neptunojpa.Empleados;
import neptunojpa.Companyaenvios;
import neptunojpa.Detallespedidos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import neptunojpa.Pedidos;

/**
 *
 * @author alexk
 */
public class PedidosJpaController implements Serializable {

    public PedidosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pedidos pedidos) {
        if (pedidos.getDetallespedidosCollection() == null) {
            pedidos.setDetallespedidosCollection(new ArrayList<Detallespedidos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Clientes idCliente = pedidos.getIdCliente();
            if (idCliente != null) {
                idCliente = em.getReference(idCliente.getClass(), idCliente.getIdCliente());
                pedidos.setIdCliente(idCliente);
            }
            Empleados idEmpleado = pedidos.getIdEmpleado();
            if (idEmpleado != null) {
                idEmpleado = em.getReference(idEmpleado.getClass(), idEmpleado.getIdEmpleado());
                pedidos.setIdEmpleado(idEmpleado);
            }
            Companyaenvios formaEnvio = pedidos.getFormaEnvio();
            if (formaEnvio != null) {
                formaEnvio = em.getReference(formaEnvio.getClass(), formaEnvio.getIdCompanyaEnvios());
                pedidos.setFormaEnvio(formaEnvio);
            }
            Collection<Detallespedidos> attachedDetallespedidosCollection = new ArrayList<Detallespedidos>();
            for (Detallespedidos detallespedidosCollectionDetallespedidosToAttach : pedidos.getDetallespedidosCollection()) {
                detallespedidosCollectionDetallespedidosToAttach = em.getReference(detallespedidosCollectionDetallespedidosToAttach.getClass(), detallespedidosCollectionDetallespedidosToAttach.getDetallespedidosPK());
                attachedDetallespedidosCollection.add(detallespedidosCollectionDetallespedidosToAttach);
            }
            pedidos.setDetallespedidosCollection(attachedDetallespedidosCollection);
            em.persist(pedidos);
            if (idCliente != null) {
                idCliente.getPedidosCollection().add(pedidos);
                idCliente = em.merge(idCliente);
            }
            if (idEmpleado != null) {
                idEmpleado.getPedidosCollection().add(pedidos);
                idEmpleado = em.merge(idEmpleado);
            }
            if (formaEnvio != null) {
                formaEnvio.getPedidosCollection().add(pedidos);
                formaEnvio = em.merge(formaEnvio);
            }
            for (Detallespedidos detallespedidosCollectionDetallespedidos : pedidos.getDetallespedidosCollection()) {
                Pedidos oldPedidosOfDetallespedidosCollectionDetallespedidos = detallespedidosCollectionDetallespedidos.getPedidos();
                detallespedidosCollectionDetallespedidos.setPedidos(pedidos);
                detallespedidosCollectionDetallespedidos = em.merge(detallespedidosCollectionDetallespedidos);
                if (oldPedidosOfDetallespedidosCollectionDetallespedidos != null) {
                    oldPedidosOfDetallespedidosCollectionDetallespedidos.getDetallespedidosCollection().remove(detallespedidosCollectionDetallespedidos);
                    oldPedidosOfDetallespedidosCollectionDetallespedidos = em.merge(oldPedidosOfDetallespedidosCollectionDetallespedidos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pedidos pedidos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedidos persistentPedidos = em.find(Pedidos.class, pedidos.getIdPedido());
            Clientes idClienteOld = persistentPedidos.getIdCliente();
            Clientes idClienteNew = pedidos.getIdCliente();
            Empleados idEmpleadoOld = persistentPedidos.getIdEmpleado();
            Empleados idEmpleadoNew = pedidos.getIdEmpleado();
            Companyaenvios formaEnvioOld = persistentPedidos.getFormaEnvio();
            Companyaenvios formaEnvioNew = pedidos.getFormaEnvio();
            Collection<Detallespedidos> detallespedidosCollectionOld = persistentPedidos.getDetallespedidosCollection();
            Collection<Detallespedidos> detallespedidosCollectionNew = pedidos.getDetallespedidosCollection();
            List<String> illegalOrphanMessages = null;
            for (Detallespedidos detallespedidosCollectionOldDetallespedidos : detallespedidosCollectionOld) {
                if (!detallespedidosCollectionNew.contains(detallespedidosCollectionOldDetallespedidos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Detallespedidos " + detallespedidosCollectionOldDetallespedidos + " since its pedidos field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idClienteNew != null) {
                idClienteNew = em.getReference(idClienteNew.getClass(), idClienteNew.getIdCliente());
                pedidos.setIdCliente(idClienteNew);
            }
            if (idEmpleadoNew != null) {
                idEmpleadoNew = em.getReference(idEmpleadoNew.getClass(), idEmpleadoNew.getIdEmpleado());
                pedidos.setIdEmpleado(idEmpleadoNew);
            }
            if (formaEnvioNew != null) {
                formaEnvioNew = em.getReference(formaEnvioNew.getClass(), formaEnvioNew.getIdCompanyaEnvios());
                pedidos.setFormaEnvio(formaEnvioNew);
            }
            Collection<Detallespedidos> attachedDetallespedidosCollectionNew = new ArrayList<Detallespedidos>();
            for (Detallespedidos detallespedidosCollectionNewDetallespedidosToAttach : detallespedidosCollectionNew) {
                detallespedidosCollectionNewDetallespedidosToAttach = em.getReference(detallespedidosCollectionNewDetallespedidosToAttach.getClass(), detallespedidosCollectionNewDetallespedidosToAttach.getDetallespedidosPK());
                attachedDetallespedidosCollectionNew.add(detallespedidosCollectionNewDetallespedidosToAttach);
            }
            detallespedidosCollectionNew = attachedDetallespedidosCollectionNew;
            pedidos.setDetallespedidosCollection(detallespedidosCollectionNew);
            pedidos = em.merge(pedidos);
            if (idClienteOld != null && !idClienteOld.equals(idClienteNew)) {
                idClienteOld.getPedidosCollection().remove(pedidos);
                idClienteOld = em.merge(idClienteOld);
            }
            if (idClienteNew != null && !idClienteNew.equals(idClienteOld)) {
                idClienteNew.getPedidosCollection().add(pedidos);
                idClienteNew = em.merge(idClienteNew);
            }
            if (idEmpleadoOld != null && !idEmpleadoOld.equals(idEmpleadoNew)) {
                idEmpleadoOld.getPedidosCollection().remove(pedidos);
                idEmpleadoOld = em.merge(idEmpleadoOld);
            }
            if (idEmpleadoNew != null && !idEmpleadoNew.equals(idEmpleadoOld)) {
                idEmpleadoNew.getPedidosCollection().add(pedidos);
                idEmpleadoNew = em.merge(idEmpleadoNew);
            }
            if (formaEnvioOld != null && !formaEnvioOld.equals(formaEnvioNew)) {
                formaEnvioOld.getPedidosCollection().remove(pedidos);
                formaEnvioOld = em.merge(formaEnvioOld);
            }
            if (formaEnvioNew != null && !formaEnvioNew.equals(formaEnvioOld)) {
                formaEnvioNew.getPedidosCollection().add(pedidos);
                formaEnvioNew = em.merge(formaEnvioNew);
            }
            for (Detallespedidos detallespedidosCollectionNewDetallespedidos : detallespedidosCollectionNew) {
                if (!detallespedidosCollectionOld.contains(detallespedidosCollectionNewDetallespedidos)) {
                    Pedidos oldPedidosOfDetallespedidosCollectionNewDetallespedidos = detallespedidosCollectionNewDetallespedidos.getPedidos();
                    detallespedidosCollectionNewDetallespedidos.setPedidos(pedidos);
                    detallespedidosCollectionNewDetallespedidos = em.merge(detallespedidosCollectionNewDetallespedidos);
                    if (oldPedidosOfDetallespedidosCollectionNewDetallespedidos != null && !oldPedidosOfDetallespedidosCollectionNewDetallespedidos.equals(pedidos)) {
                        oldPedidosOfDetallespedidosCollectionNewDetallespedidos.getDetallespedidosCollection().remove(detallespedidosCollectionNewDetallespedidos);
                        oldPedidosOfDetallespedidosCollectionNewDetallespedidos = em.merge(oldPedidosOfDetallespedidosCollectionNewDetallespedidos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pedidos.getIdPedido();
                if (findPedidos(id) == null) {
                    throw new NonexistentEntityException("The pedidos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedidos pedidos;
            try {
                pedidos = em.getReference(Pedidos.class, id);
                pedidos.getIdPedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedidos with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Detallespedidos> detallespedidosCollectionOrphanCheck = pedidos.getDetallespedidosCollection();
            for (Detallespedidos detallespedidosCollectionOrphanCheckDetallespedidos : detallespedidosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pedidos (" + pedidos + ") cannot be destroyed since the Detallespedidos " + detallespedidosCollectionOrphanCheckDetallespedidos + " in its detallespedidosCollection field has a non-nullable pedidos field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Clientes idCliente = pedidos.getIdCliente();
            if (idCliente != null) {
                idCliente.getPedidosCollection().remove(pedidos);
                idCliente = em.merge(idCliente);
            }
            Empleados idEmpleado = pedidos.getIdEmpleado();
            if (idEmpleado != null) {
                idEmpleado.getPedidosCollection().remove(pedidos);
                idEmpleado = em.merge(idEmpleado);
            }
            Companyaenvios formaEnvio = pedidos.getFormaEnvio();
            if (formaEnvio != null) {
                formaEnvio.getPedidosCollection().remove(pedidos);
                formaEnvio = em.merge(formaEnvio);
            }
            em.remove(pedidos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pedidos> findPedidosEntities() {
        return findPedidosEntities(true, -1, -1);
    }

    public List<Pedidos> findPedidosEntities(int maxResults, int firstResult) {
        return findPedidosEntities(false, maxResults, firstResult);
    }

    private List<Pedidos> findPedidosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedidos.class));
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

    public Pedidos findPedidos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedidos.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedidosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedidos> rt = cq.from(Pedidos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
