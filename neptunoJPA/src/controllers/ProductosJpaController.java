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
import neptunojpa.Categorias;
import neptunojpa.Proveedores;
import neptunojpa.Detallespedidos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import neptunojpa.Productos;

/**
 *
 * @author alexk
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
        if (productos.getDetallespedidosCollection() == null) {
            productos.setDetallespedidosCollection(new ArrayList<Detallespedidos>());
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
            Collection<Detallespedidos> attachedDetallespedidosCollection = new ArrayList<Detallespedidos>();
            for (Detallespedidos detallespedidosCollectionDetallespedidosToAttach : productos.getDetallespedidosCollection()) {
                detallespedidosCollectionDetallespedidosToAttach = em.getReference(detallespedidosCollectionDetallespedidosToAttach.getClass(), detallespedidosCollectionDetallespedidosToAttach.getDetallespedidosPK());
                attachedDetallespedidosCollection.add(detallespedidosCollectionDetallespedidosToAttach);
            }
            productos.setDetallespedidosCollection(attachedDetallespedidosCollection);
            em.persist(productos);
            if (idCategoria != null) {
                idCategoria.getProductosCollection().add(productos);
                idCategoria = em.merge(idCategoria);
            }
            if (idProveedor != null) {
                idProveedor.getProductosCollection().add(productos);
                idProveedor = em.merge(idProveedor);
            }
            for (Detallespedidos detallespedidosCollectionDetallespedidos : productos.getDetallespedidosCollection()) {
                Productos oldProductosOfDetallespedidosCollectionDetallespedidos = detallespedidosCollectionDetallespedidos.getProductos();
                detallespedidosCollectionDetallespedidos.setProductos(productos);
                detallespedidosCollectionDetallespedidos = em.merge(detallespedidosCollectionDetallespedidos);
                if (oldProductosOfDetallespedidosCollectionDetallespedidos != null) {
                    oldProductosOfDetallespedidosCollectionDetallespedidos.getDetallespedidosCollection().remove(detallespedidosCollectionDetallespedidos);
                    oldProductosOfDetallespedidosCollectionDetallespedidos = em.merge(oldProductosOfDetallespedidosCollectionDetallespedidos);
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
            Collection<Detallespedidos> detallespedidosCollectionOld = persistentProductos.getDetallespedidosCollection();
            Collection<Detallespedidos> detallespedidosCollectionNew = productos.getDetallespedidosCollection();
            List<String> illegalOrphanMessages = null;
            for (Detallespedidos detallespedidosCollectionOldDetallespedidos : detallespedidosCollectionOld) {
                if (!detallespedidosCollectionNew.contains(detallespedidosCollectionOldDetallespedidos)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Detallespedidos " + detallespedidosCollectionOldDetallespedidos + " since its productos field is not nullable.");
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
            Collection<Detallespedidos> attachedDetallespedidosCollectionNew = new ArrayList<Detallespedidos>();
            for (Detallespedidos detallespedidosCollectionNewDetallespedidosToAttach : detallespedidosCollectionNew) {
                detallespedidosCollectionNewDetallespedidosToAttach = em.getReference(detallespedidosCollectionNewDetallespedidosToAttach.getClass(), detallespedidosCollectionNewDetallespedidosToAttach.getDetallespedidosPK());
                attachedDetallespedidosCollectionNew.add(detallespedidosCollectionNewDetallespedidosToAttach);
            }
            detallespedidosCollectionNew = attachedDetallespedidosCollectionNew;
            productos.setDetallespedidosCollection(detallespedidosCollectionNew);
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
            for (Detallespedidos detallespedidosCollectionNewDetallespedidos : detallespedidosCollectionNew) {
                if (!detallespedidosCollectionOld.contains(detallespedidosCollectionNewDetallespedidos)) {
                    Productos oldProductosOfDetallespedidosCollectionNewDetallespedidos = detallespedidosCollectionNewDetallespedidos.getProductos();
                    detallespedidosCollectionNewDetallespedidos.setProductos(productos);
                    detallespedidosCollectionNewDetallespedidos = em.merge(detallespedidosCollectionNewDetallespedidos);
                    if (oldProductosOfDetallespedidosCollectionNewDetallespedidos != null && !oldProductosOfDetallespedidosCollectionNewDetallespedidos.equals(productos)) {
                        oldProductosOfDetallespedidosCollectionNewDetallespedidos.getDetallespedidosCollection().remove(detallespedidosCollectionNewDetallespedidos);
                        oldProductosOfDetallespedidosCollectionNewDetallespedidos = em.merge(oldProductosOfDetallespedidosCollectionNewDetallespedidos);
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
            Collection<Detallespedidos> detallespedidosCollectionOrphanCheck = productos.getDetallespedidosCollection();
            for (Detallespedidos detallespedidosCollectionOrphanCheckDetallespedidos : detallespedidosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Productos (" + productos + ") cannot be destroyed since the Detallespedidos " + detallespedidosCollectionOrphanCheckDetallespedidos + " in its detallespedidosCollection field has a non-nullable productos field.");
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
