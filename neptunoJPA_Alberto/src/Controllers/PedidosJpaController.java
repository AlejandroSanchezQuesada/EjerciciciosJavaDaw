/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.exceptions.IllegalOrphanException;
import Controllers.exceptions.NonexistentEntityException;
import Controllers.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import neptunojpa.DetallesPedidos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import neptunojpa.Pedidos;

/**
 *
 * @author alumno
 */
public class PedidosJpaController implements Serializable {

    public PedidosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pedidos pedidos) throws PreexistingEntityException, Exception {
        if (pedidos.getDetallesPedidosCollection() == null) {
            pedidos.setDetallesPedidosCollection(new ArrayList<DetallesPedidos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<DetallesPedidos> attachedDetallesPedidosCollection = new ArrayList<DetallesPedidos>();
            for (DetallesPedidos detallesPedidosCollectionDetallesPedidosToAttach : pedidos.getDetallesPedidosCollection()) {
                detallesPedidosCollectionDetallesPedidosToAttach = em.getReference(detallesPedidosCollectionDetallesPedidosToAttach.getClass(), detallesPedidosCollectionDetallesPedidosToAttach.getDetallesPedidosPK());
                attachedDetallesPedidosCollection.add(detallesPedidosCollectionDetallesPedidosToAttach);
            }
            pedidos.setDetallesPedidosCollection(attachedDetallesPedidosCollection);
            em.persist(pedidos);
            for (DetallesPedidos detallesPedidosCollectionDetallesPedidos : pedidos.getDetallesPedidosCollection()) {
                Pedidos oldPedidosOfDetallesPedidosCollectionDetallesPedidos = detallesPedidosCollectionDetallesPedidos.getPedidos();
                detallesPedidosCollectionDetallesPedidos.setPedidos(pedidos);
                detallesPedidosCollectionDetallesPedidos = em.merge(detallesPedidosCollectionDetallesPedidos);
                if (oldPedidosOfDetallesPedidosCollectionDetallesPedidos != null) {
                    oldPedidosOfDetallesPedidosCollectionDetallesPedidos.getDetallesPedidosCollection().remove(detallesPedidosCollectionDetallesPedidos);
                    oldPedidosOfDetallesPedidosCollectionDetallesPedidos = em.merge(oldPedidosOfDetallesPedidosCollectionDetallesPedidos);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPedidos(pedidos.getIdPedido()) != null) {
                throw new PreexistingEntityException("Pedidos " + pedidos + " already exists.", ex);
            }
            throw ex;
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
            Collection<DetallesPedidos> detallesPedidosCollectionOld = persistentPedidos.getDetallesPedidosCollection();
            Collection<DetallesPedidos> detallesPedidosCollectionNew = pedidos.getDetallesPedidosCollection();
            List<String> illegalOrphanMessages = null;
            for (DetallesPedidos detallesPedidosCollectionOldDetallesPedidos : detallesPedidosCollectionOld) {
                if (!detallesPedidosCollectionNew.contains(detallesPedidosCollectionOldDetallesPedidos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetallesPedidos " + detallesPedidosCollectionOldDetallesPedidos + " since its pedidos field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<DetallesPedidos> attachedDetallesPedidosCollectionNew = new ArrayList<DetallesPedidos>();
            for (DetallesPedidos detallesPedidosCollectionNewDetallesPedidosToAttach : detallesPedidosCollectionNew) {
                detallesPedidosCollectionNewDetallesPedidosToAttach = em.getReference(detallesPedidosCollectionNewDetallesPedidosToAttach.getClass(), detallesPedidosCollectionNewDetallesPedidosToAttach.getDetallesPedidosPK());
                attachedDetallesPedidosCollectionNew.add(detallesPedidosCollectionNewDetallesPedidosToAttach);
            }
            detallesPedidosCollectionNew = attachedDetallesPedidosCollectionNew;
            pedidos.setDetallesPedidosCollection(detallesPedidosCollectionNew);
            pedidos = em.merge(pedidos);
            for (DetallesPedidos detallesPedidosCollectionNewDetallesPedidos : detallesPedidosCollectionNew) {
                if (!detallesPedidosCollectionOld.contains(detallesPedidosCollectionNewDetallesPedidos)) {
                    Pedidos oldPedidosOfDetallesPedidosCollectionNewDetallesPedidos = detallesPedidosCollectionNewDetallesPedidos.getPedidos();
                    detallesPedidosCollectionNewDetallesPedidos.setPedidos(pedidos);
                    detallesPedidosCollectionNewDetallesPedidos = em.merge(detallesPedidosCollectionNewDetallesPedidos);
                    if (oldPedidosOfDetallesPedidosCollectionNewDetallesPedidos != null && !oldPedidosOfDetallesPedidosCollectionNewDetallesPedidos.equals(pedidos)) {
                        oldPedidosOfDetallesPedidosCollectionNewDetallesPedidos.getDetallesPedidosCollection().remove(detallesPedidosCollectionNewDetallesPedidos);
                        oldPedidosOfDetallesPedidosCollectionNewDetallesPedidos = em.merge(oldPedidosOfDetallesPedidosCollectionNewDetallesPedidos);
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
            Collection<DetallesPedidos> detallesPedidosCollectionOrphanCheck = pedidos.getDetallesPedidosCollection();
            for (DetallesPedidos detallesPedidosCollectionOrphanCheckDetallesPedidos : detallesPedidosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pedidos (" + pedidos + ") cannot be destroyed since the DetallesPedidos " + detallesPedidosCollectionOrphanCheckDetallesPedidos + " in its detallesPedidosCollection field has a non-nullable pedidos field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
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
