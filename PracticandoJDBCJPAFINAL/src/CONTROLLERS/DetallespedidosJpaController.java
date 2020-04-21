/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import CONTROLLERS.exceptions.NonexistentEntityException;
import CONTROLLERS.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import practicandojdbcjpafinal.Detallespedidos;
import practicandojdbcjpafinal.DetallespedidosPK;
import practicandojdbcjpafinal.Pedidos;
import practicandojdbcjpafinal.Productos;

/**
 *
 * @author alexk
 */
public class DetallespedidosJpaController implements Serializable {

    public DetallespedidosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Detallespedidos detallespedidos) throws PreexistingEntityException, Exception {
        if (detallespedidos.getDetallespedidosPK() == null) {
            detallespedidos.setDetallespedidosPK(new DetallespedidosPK());
        }
        detallespedidos.getDetallespedidosPK().setIdPedido(detallespedidos.getPedidos().getIdPedido());
        detallespedidos.getDetallespedidosPK().setIdProducto(detallespedidos.getProductos().getIdProducto());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedidos pedidos = detallespedidos.getPedidos();
            if (pedidos != null) {
                pedidos = em.getReference(pedidos.getClass(), pedidos.getIdPedido());
                detallespedidos.setPedidos(pedidos);
            }
            Productos productos = detallespedidos.getProductos();
            if (productos != null) {
                productos = em.getReference(productos.getClass(), productos.getIdProducto());
                detallespedidos.setProductos(productos);
            }
            em.persist(detallespedidos);
            if (pedidos != null) {
                pedidos.getDetallespedidosCollection().add(detallespedidos);
                pedidos = em.merge(pedidos);
            }
            if (productos != null) {
                productos.getDetallespedidosCollection().add(detallespedidos);
                productos = em.merge(productos);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDetallespedidos(detallespedidos.getDetallespedidosPK()) != null) {
                throw new PreexistingEntityException("Detallespedidos " + detallespedidos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Detallespedidos detallespedidos) throws NonexistentEntityException, Exception {
        detallespedidos.getDetallespedidosPK().setIdPedido(detallespedidos.getPedidos().getIdPedido());
        detallespedidos.getDetallespedidosPK().setIdProducto(detallespedidos.getProductos().getIdProducto());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Detallespedidos persistentDetallespedidos = em.find(Detallespedidos.class, detallespedidos.getDetallespedidosPK());
            Pedidos pedidosOld = persistentDetallespedidos.getPedidos();
            Pedidos pedidosNew = detallespedidos.getPedidos();
            Productos productosOld = persistentDetallespedidos.getProductos();
            Productos productosNew = detallespedidos.getProductos();
            if (pedidosNew != null) {
                pedidosNew = em.getReference(pedidosNew.getClass(), pedidosNew.getIdPedido());
                detallespedidos.setPedidos(pedidosNew);
            }
            if (productosNew != null) {
                productosNew = em.getReference(productosNew.getClass(), productosNew.getIdProducto());
                detallespedidos.setProductos(productosNew);
            }
            detallespedidos = em.merge(detallespedidos);
            if (pedidosOld != null && !pedidosOld.equals(pedidosNew)) {
                pedidosOld.getDetallespedidosCollection().remove(detallespedidos);
                pedidosOld = em.merge(pedidosOld);
            }
            if (pedidosNew != null && !pedidosNew.equals(pedidosOld)) {
                pedidosNew.getDetallespedidosCollection().add(detallespedidos);
                pedidosNew = em.merge(pedidosNew);
            }
            if (productosOld != null && !productosOld.equals(productosNew)) {
                productosOld.getDetallespedidosCollection().remove(detallespedidos);
                productosOld = em.merge(productosOld);
            }
            if (productosNew != null && !productosNew.equals(productosOld)) {
                productosNew.getDetallespedidosCollection().add(detallespedidos);
                productosNew = em.merge(productosNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                DetallespedidosPK id = detallespedidos.getDetallespedidosPK();
                if (findDetallespedidos(id) == null) {
                    throw new NonexistentEntityException("The detallespedidos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(DetallespedidosPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Detallespedidos detallespedidos;
            try {
                detallespedidos = em.getReference(Detallespedidos.class, id);
                detallespedidos.getDetallespedidosPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detallespedidos with id " + id + " no longer exists.", enfe);
            }
            Pedidos pedidos = detallespedidos.getPedidos();
            if (pedidos != null) {
                pedidos.getDetallespedidosCollection().remove(detallespedidos);
                pedidos = em.merge(pedidos);
            }
            Productos productos = detallespedidos.getProductos();
            if (productos != null) {
                productos.getDetallespedidosCollection().remove(detallespedidos);
                productos = em.merge(productos);
            }
            em.remove(detallespedidos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Detallespedidos> findDetallespedidosEntities() {
        return findDetallespedidosEntities(true, -1, -1);
    }

    public List<Detallespedidos> findDetallespedidosEntities(int maxResults, int firstResult) {
        return findDetallespedidosEntities(false, maxResults, firstResult);
    }

    private List<Detallespedidos> findDetallespedidosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Detallespedidos.class));
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

    public Detallespedidos findDetallespedidos(DetallespedidosPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Detallespedidos.class, id);
        } finally {
            em.close();
        }
    }
    
    public List<Detallespedidos> findDetallespedidosPorIdPedido(int _idPedido){
    EntityManager em = getEntityManager();
    Query q = em.createNamedQuery("Detallespedidos.findByIdPedido");
    q.setParameter("idPedido", _idPedido);
    
    return q.getResultList();
    
    
    }
    
    

    public int getDetallespedidosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Detallespedidos> rt = cq.from(Detallespedidos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
