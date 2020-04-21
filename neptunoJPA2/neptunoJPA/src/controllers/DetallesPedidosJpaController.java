/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.exceptions.NonexistentEntityException;
import controllers.exceptions.PreexistingEntityException;
import entities.DetallesPedidos;
import entities.DetallesPedidosPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entities.Pedidos;
import entities.Productos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author alumno
 */
public class DetallesPedidosJpaController implements Serializable {

    public DetallesPedidosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetallesPedidos detallesPedidos) throws PreexistingEntityException, Exception {
        if (detallesPedidos.getDetallesPedidosPK() == null) {
            detallesPedidos.setDetallesPedidosPK(new DetallesPedidosPK());
        }
        detallesPedidos.getDetallesPedidosPK().setIdPedido(detallesPedidos.getPedidos().getIdPedido());
        detallesPedidos.getDetallesPedidosPK().setIdProducto(detallesPedidos.getProductos().getIdProducto());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedidos pedidos = detallesPedidos.getPedidos();
            if (pedidos != null) {
                pedidos = em.getReference(pedidos.getClass(), pedidos.getIdPedido());
                detallesPedidos.setPedidos(pedidos);
            }
            Productos productos = detallesPedidos.getProductos();
            if (productos != null) {
                productos = em.getReference(productos.getClass(), productos.getIdProducto());
                detallesPedidos.setProductos(productos);
            }
            em.persist(detallesPedidos);
            if (pedidos != null) {
                pedidos.getDetallesPedidosCollection().add(detallesPedidos);
                pedidos = em.merge(pedidos);
            }
            if (productos != null) {
                productos.getDetallesPedidosCollection().add(detallesPedidos);
                productos = em.merge(productos);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDetallesPedidos(detallesPedidos.getDetallesPedidosPK()) != null) {
                throw new PreexistingEntityException("DetallesPedidos " + detallesPedidos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetallesPedidos detallesPedidos) throws NonexistentEntityException, Exception {
        detallesPedidos.getDetallesPedidosPK().setIdPedido(detallesPedidos.getPedidos().getIdPedido());
        detallesPedidos.getDetallesPedidosPK().setIdProducto(detallesPedidos.getProductos().getIdProducto());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetallesPedidos persistentDetallesPedidos = em.find(DetallesPedidos.class, detallesPedidos.getDetallesPedidosPK());
            Pedidos pedidosOld = persistentDetallesPedidos.getPedidos();
            Pedidos pedidosNew = detallesPedidos.getPedidos();
            Productos productosOld = persistentDetallesPedidos.getProductos();
            Productos productosNew = detallesPedidos.getProductos();
            if (pedidosNew != null) {
                pedidosNew = em.getReference(pedidosNew.getClass(), pedidosNew.getIdPedido());
                detallesPedidos.setPedidos(pedidosNew);
            }
            if (productosNew != null) {
                productosNew = em.getReference(productosNew.getClass(), productosNew.getIdProducto());
                detallesPedidos.setProductos(productosNew);
            }
            detallesPedidos = em.merge(detallesPedidos);
            if (pedidosOld != null && !pedidosOld.equals(pedidosNew)) {
                pedidosOld.getDetallesPedidosCollection().remove(detallesPedidos);
                pedidosOld = em.merge(pedidosOld);
            }
            if (pedidosNew != null && !pedidosNew.equals(pedidosOld)) {
                pedidosNew.getDetallesPedidosCollection().add(detallesPedidos);
                pedidosNew = em.merge(pedidosNew);
            }
            if (productosOld != null && !productosOld.equals(productosNew)) {
                productosOld.getDetallesPedidosCollection().remove(detallesPedidos);
                productosOld = em.merge(productosOld);
            }
            if (productosNew != null && !productosNew.equals(productosOld)) {
                productosNew.getDetallesPedidosCollection().add(detallesPedidos);
                productosNew = em.merge(productosNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                DetallesPedidosPK id = detallesPedidos.getDetallesPedidosPK();
                if (findDetallesPedidos(id) == null) {
                    throw new NonexistentEntityException("The detallesPedidos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(DetallesPedidosPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetallesPedidos detallesPedidos;
            try {
                detallesPedidos = em.getReference(DetallesPedidos.class, id);
                detallesPedidos.getDetallesPedidosPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detallesPedidos with id " + id + " no longer exists.", enfe);
            }
            Pedidos pedidos = detallesPedidos.getPedidos();
            if (pedidos != null) {
                pedidos.getDetallesPedidosCollection().remove(detallesPedidos);
                pedidos = em.merge(pedidos);
            }
            Productos productos = detallesPedidos.getProductos();
            if (productos != null) {
                productos.getDetallesPedidosCollection().remove(detallesPedidos);
                productos = em.merge(productos);
            }
            em.remove(detallesPedidos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetallesPedidos> findDetallesPedidosEntities() {
        return findDetallesPedidosEntities(true, -1, -1);
    }

    public List<DetallesPedidos> findDetallesPedidosEntities(int maxResults, int firstResult) {
        return findDetallesPedidosEntities(false, maxResults, firstResult);
    }

    private List<DetallesPedidos> findDetallesPedidosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetallesPedidos.class));
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

    public DetallesPedidos findDetallesPedidos(DetallesPedidosPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetallesPedidos.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetallesPedidosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetallesPedidos> rt = cq.from(DetallesPedidos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
