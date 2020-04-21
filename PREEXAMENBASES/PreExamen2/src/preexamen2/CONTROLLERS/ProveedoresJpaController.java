/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preexamen2.CONTROLLERS;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import preexamen2.Productos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import preexamen2.CONTROLLERS.exceptions.NonexistentEntityException;
import preexamen2.Proveedores;

/**
 *
 * @author alexk
 */
public class ProveedoresJpaController implements Serializable {

    public ProveedoresJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proveedores proveedores) {
        if (proveedores.getProductosCollection() == null) {
            proveedores.setProductosCollection(new ArrayList<Productos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Productos> attachedProductosCollection = new ArrayList<Productos>();
            for (Productos productosCollectionProductosToAttach : proveedores.getProductosCollection()) {
                productosCollectionProductosToAttach = em.getReference(productosCollectionProductosToAttach.getClass(), productosCollectionProductosToAttach.getIdProducto());
                attachedProductosCollection.add(productosCollectionProductosToAttach);
            }
            proveedores.setProductosCollection(attachedProductosCollection);
            em.persist(proveedores);
            for (Productos productosCollectionProductos : proveedores.getProductosCollection()) {
                Proveedores oldIdProveedorOfProductosCollectionProductos = productosCollectionProductos.getIdProveedor();
                productosCollectionProductos.setIdProveedor(proveedores);
                productosCollectionProductos = em.merge(productosCollectionProductos);
                if (oldIdProveedorOfProductosCollectionProductos != null) {
                    oldIdProveedorOfProductosCollectionProductos.getProductosCollection().remove(productosCollectionProductos);
                    oldIdProveedorOfProductosCollectionProductos = em.merge(oldIdProveedorOfProductosCollectionProductos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proveedores proveedores) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedores persistentProveedores = em.find(Proveedores.class, proveedores.getIdProveedor());
            Collection<Productos> productosCollectionOld = persistentProveedores.getProductosCollection();
            Collection<Productos> productosCollectionNew = proveedores.getProductosCollection();
            Collection<Productos> attachedProductosCollectionNew = new ArrayList<Productos>();
            for (Productos productosCollectionNewProductosToAttach : productosCollectionNew) {
                productosCollectionNewProductosToAttach = em.getReference(productosCollectionNewProductosToAttach.getClass(), productosCollectionNewProductosToAttach.getIdProducto());
                attachedProductosCollectionNew.add(productosCollectionNewProductosToAttach);
            }
            productosCollectionNew = attachedProductosCollectionNew;
            proveedores.setProductosCollection(productosCollectionNew);
            proveedores = em.merge(proveedores);
            for (Productos productosCollectionOldProductos : productosCollectionOld) {
                if (!productosCollectionNew.contains(productosCollectionOldProductos)) {
                    productosCollectionOldProductos.setIdProveedor(null);
                    productosCollectionOldProductos = em.merge(productosCollectionOldProductos);
                }
            }
            for (Productos productosCollectionNewProductos : productosCollectionNew) {
                if (!productosCollectionOld.contains(productosCollectionNewProductos)) {
                    Proveedores oldIdProveedorOfProductosCollectionNewProductos = productosCollectionNewProductos.getIdProveedor();
                    productosCollectionNewProductos.setIdProveedor(proveedores);
                    productosCollectionNewProductos = em.merge(productosCollectionNewProductos);
                    if (oldIdProveedorOfProductosCollectionNewProductos != null && !oldIdProveedorOfProductosCollectionNewProductos.equals(proveedores)) {
                        oldIdProveedorOfProductosCollectionNewProductos.getProductosCollection().remove(productosCollectionNewProductos);
                        oldIdProveedorOfProductosCollectionNewProductos = em.merge(oldIdProveedorOfProductosCollectionNewProductos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = proveedores.getIdProveedor();
                if (findProveedores(id) == null) {
                    throw new NonexistentEntityException("The proveedores with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Short id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedores proveedores;
            try {
                proveedores = em.getReference(Proveedores.class, id);
                proveedores.getIdProveedor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proveedores with id " + id + " no longer exists.", enfe);
            }
            Collection<Productos> productosCollection = proveedores.getProductosCollection();
            for (Productos productosCollectionProductos : productosCollection) {
                productosCollectionProductos.setIdProveedor(null);
                productosCollectionProductos = em.merge(productosCollectionProductos);
            }
            em.remove(proveedores);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proveedores> findProveedoresEntities() {
        return findProveedoresEntities(true, -1, -1);
    }

    public List<Proveedores> findProveedoresEntities(int maxResults, int firstResult) {
        return findProveedoresEntities(false, maxResults, firstResult);
    }

    private List<Proveedores> findProveedoresEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proveedores.class));
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

    public Proveedores findProveedores(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedores.class, id);
        } finally {
            em.close();
        }
    }

    public int getProveedoresCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proveedores> rt = cq.from(Proveedores.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
