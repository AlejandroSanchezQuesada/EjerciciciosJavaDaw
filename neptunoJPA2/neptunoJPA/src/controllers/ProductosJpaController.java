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
import entities.Categorias;
import entities.Proveedores;
import entities.DetallesPedidos;
import entities.Productos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author alumno
 */
public class ProductosJpaController implements Serializable {

    public ProductosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Productos productos) {
        if (productos.getDetallesPedidosCollection() == null) {
            productos.setDetallesPedidosCollection(new ArrayList<DetallesPedidos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categorias idCategoria = productos.getIdCategoria();
            if (idCategoria != null) {
                idCategoria = em.getReference(idCategoria.getClass(), idCategoria.getIdCategoria());
                productos.setIdCategoria(idCategoria);
            }
            Proveedores idProveedor = productos.getIdProveedor();
            if (idProveedor != null) {
                idProveedor = em.getReference(idProveedor.getClass(), idProveedor.getIdProveedor());
                productos.setIdProveedor(idProveedor);
            }
            Collection<DetallesPedidos> attachedDetallesPedidosCollection = new ArrayList<DetallesPedidos>();
            for (DetallesPedidos detallesPedidosCollectionDetallesPedidosToAttach : productos.getDetallesPedidosCollection()) {
                detallesPedidosCollectionDetallesPedidosToAttach = em.getReference(detallesPedidosCollectionDetallesPedidosToAttach.getClass(), detallesPedidosCollectionDetallesPedidosToAttach.getDetallesPedidosPK());
                attachedDetallesPedidosCollection.add(detallesPedidosCollectionDetallesPedidosToAttach);
            }
            productos.setDetallesPedidosCollection(attachedDetallesPedidosCollection);
            em.persist(productos);
            if (idCategoria != null) {
                idCategoria.getProductosCollection().add(productos);
                idCategoria = em.merge(idCategoria);
            }
            if (idProveedor != null) {
                idProveedor.getProductosCollection().add(productos);
                idProveedor = em.merge(idProveedor);
            }
            for (DetallesPedidos detallesPedidosCollectionDetallesPedidos : productos.getDetallesPedidosCollection()) {
                Productos oldProductosOfDetallesPedidosCollectionDetallesPedidos = detallesPedidosCollectionDetallesPedidos.getProductos();
                detallesPedidosCollectionDetallesPedidos.setProductos(productos);
                detallesPedidosCollectionDetallesPedidos = em.merge(detallesPedidosCollectionDetallesPedidos);
                if (oldProductosOfDetallesPedidosCollectionDetallesPedidos != null) {
                    oldProductosOfDetallesPedidosCollectionDetallesPedidos.getDetallesPedidosCollection().remove(detallesPedidosCollectionDetallesPedidos);
                    oldProductosOfDetallesPedidosCollectionDetallesPedidos = em.merge(oldProductosOfDetallesPedidosCollectionDetallesPedidos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Productos productos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Productos persistentProductos = em.find(Productos.class, productos.getIdProducto());
            Categorias idCategoriaOld = persistentProductos.getIdCategoria();
            Categorias idCategoriaNew = productos.getIdCategoria();
            Proveedores idProveedorOld = persistentProductos.getIdProveedor();
            Proveedores idProveedorNew = productos.getIdProveedor();
            Collection<DetallesPedidos> detallesPedidosCollectionOld = persistentProductos.getDetallesPedidosCollection();
            Collection<DetallesPedidos> detallesPedidosCollectionNew = productos.getDetallesPedidosCollection();
            List<String> illegalOrphanMessages = null;
            for (DetallesPedidos detallesPedidosCollectionOldDetallesPedidos : detallesPedidosCollectionOld) {
                if (!detallesPedidosCollectionNew.contains(detallesPedidosCollectionOldDetallesPedidos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetallesPedidos " + detallesPedidosCollectionOldDetallesPedidos + " since its productos field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idCategoriaNew != null) {
                idCategoriaNew = em.getReference(idCategoriaNew.getClass(), idCategoriaNew.getIdCategoria());
                productos.setIdCategoria(idCategoriaNew);
            }
            if (idProveedorNew != null) {
                idProveedorNew = em.getReference(idProveedorNew.getClass(), idProveedorNew.getIdProveedor());
                productos.setIdProveedor(idProveedorNew);
            }
            Collection<DetallesPedidos> attachedDetallesPedidosCollectionNew = new ArrayList<DetallesPedidos>();
            for (DetallesPedidos detallesPedidosCollectionNewDetallesPedidosToAttach : detallesPedidosCollectionNew) {
                detallesPedidosCollectionNewDetallesPedidosToAttach = em.getReference(detallesPedidosCollectionNewDetallesPedidosToAttach.getClass(), detallesPedidosCollectionNewDetallesPedidosToAttach.getDetallesPedidosPK());
                attachedDetallesPedidosCollectionNew.add(detallesPedidosCollectionNewDetallesPedidosToAttach);
            }
            detallesPedidosCollectionNew = attachedDetallesPedidosCollectionNew;
            productos.setDetallesPedidosCollection(detallesPedidosCollectionNew);
            productos = em.merge(productos);
            if (idCategoriaOld != null && !idCategoriaOld.equals(idCategoriaNew)) {
                idCategoriaOld.getProductosCollection().remove(productos);
                idCategoriaOld = em.merge(idCategoriaOld);
            }
            if (idCategoriaNew != null && !idCategoriaNew.equals(idCategoriaOld)) {
                idCategoriaNew.getProductosCollection().add(productos);
                idCategoriaNew = em.merge(idCategoriaNew);
            }
            if (idProveedorOld != null && !idProveedorOld.equals(idProveedorNew)) {
                idProveedorOld.getProductosCollection().remove(productos);
                idProveedorOld = em.merge(idProveedorOld);
            }
            if (idProveedorNew != null && !idProveedorNew.equals(idProveedorOld)) {
                idProveedorNew.getProductosCollection().add(productos);
                idProveedorNew = em.merge(idProveedorNew);
            }
            for (DetallesPedidos detallesPedidosCollectionNewDetallesPedidos : detallesPedidosCollectionNew) {
                if (!detallesPedidosCollectionOld.contains(detallesPedidosCollectionNewDetallesPedidos)) {
                    Productos oldProductosOfDetallesPedidosCollectionNewDetallesPedidos = detallesPedidosCollectionNewDetallesPedidos.getProductos();
                    detallesPedidosCollectionNewDetallesPedidos.setProductos(productos);
                    detallesPedidosCollectionNewDetallesPedidos = em.merge(detallesPedidosCollectionNewDetallesPedidos);
                    if (oldProductosOfDetallesPedidosCollectionNewDetallesPedidos != null && !oldProductosOfDetallesPedidosCollectionNewDetallesPedidos.equals(productos)) {
                        oldProductosOfDetallesPedidosCollectionNewDetallesPedidos.getDetallesPedidosCollection().remove(detallesPedidosCollectionNewDetallesPedidos);
                        oldProductosOfDetallesPedidosCollectionNewDetallesPedidos = em.merge(oldProductosOfDetallesPedidosCollectionNewDetallesPedidos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = productos.getIdProducto();
                if (findProductos(id) == null) {
                    throw new NonexistentEntityException("The productos with id " + id + " no longer exists.");
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
            Productos productos;
            try {
                productos = em.getReference(Productos.class, id);
                productos.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productos with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<DetallesPedidos> detallesPedidosCollectionOrphanCheck = productos.getDetallesPedidosCollection();
            for (DetallesPedidos detallesPedidosCollectionOrphanCheckDetallesPedidos : detallesPedidosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Productos (" + productos + ") cannot be destroyed since the DetallesPedidos " + detallesPedidosCollectionOrphanCheckDetallesPedidos + " in its detallesPedidosCollection field has a non-nullable productos field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Categorias idCategoria = productos.getIdCategoria();
            if (idCategoria != null) {
                idCategoria.getProductosCollection().remove(productos);
                idCategoria = em.merge(idCategoria);
            }
            Proveedores idProveedor = productos.getIdProveedor();
            if (idProveedor != null) {
                idProveedor.getProductosCollection().remove(productos);
                idProveedor = em.merge(idProveedor);
            }
            em.remove(productos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Productos> findProductosEntities() {
        return findProductosEntities(true, -1, -1);
    }

    public List<Productos> findProductosEntities(int maxResults, int firstResult) {
        return findProductosEntities(false, maxResults, firstResult);
    }

    private List<Productos> findProductosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Productos.class));
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

    public Productos findProductos(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Productos.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Productos> rt = cq.from(Productos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
