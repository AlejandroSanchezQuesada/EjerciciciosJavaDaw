/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLERS;

import CONTROLLERS.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import practicandojdbcjpafinal.Pedidos;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import practicandojdbcjpafinal.Companyaenvios;

/**
 *
 * @author alexk
 */
public class CompanyaenviosJpaController implements Serializable {

    public CompanyaenviosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Companyaenvios companyaenvios) {
        if (companyaenvios.getPedidosCollection() == null) {
            companyaenvios.setPedidosCollection(new ArrayList<Pedidos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Pedidos> attachedPedidosCollection = new ArrayList<Pedidos>();
            for (Pedidos pedidosCollectionPedidosToAttach : companyaenvios.getPedidosCollection()) {
                pedidosCollectionPedidosToAttach = em.getReference(pedidosCollectionPedidosToAttach.getClass(), pedidosCollectionPedidosToAttach.getIdPedido());
                attachedPedidosCollection.add(pedidosCollectionPedidosToAttach);
            }
            companyaenvios.setPedidosCollection(attachedPedidosCollection);
            em.persist(companyaenvios);
            for (Pedidos pedidosCollectionPedidos : companyaenvios.getPedidosCollection()) {
                Companyaenvios oldFormaEnvioOfPedidosCollectionPedidos = pedidosCollectionPedidos.getFormaEnvio();
                pedidosCollectionPedidos.setFormaEnvio(companyaenvios);
                pedidosCollectionPedidos = em.merge(pedidosCollectionPedidos);
                if (oldFormaEnvioOfPedidosCollectionPedidos != null) {
                    oldFormaEnvioOfPedidosCollectionPedidos.getPedidosCollection().remove(pedidosCollectionPedidos);
                    oldFormaEnvioOfPedidosCollectionPedidos = em.merge(oldFormaEnvioOfPedidosCollectionPedidos);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Companyaenvios companyaenvios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Companyaenvios persistentCompanyaenvios = em.find(Companyaenvios.class, companyaenvios.getIdCompanyaEnvios());
            Collection<Pedidos> pedidosCollectionOld = persistentCompanyaenvios.getPedidosCollection();
            Collection<Pedidos> pedidosCollectionNew = companyaenvios.getPedidosCollection();
            Collection<Pedidos> attachedPedidosCollectionNew = new ArrayList<Pedidos>();
            for (Pedidos pedidosCollectionNewPedidosToAttach : pedidosCollectionNew) {
                pedidosCollectionNewPedidosToAttach = em.getReference(pedidosCollectionNewPedidosToAttach.getClass(), pedidosCollectionNewPedidosToAttach.getIdPedido());
                attachedPedidosCollectionNew.add(pedidosCollectionNewPedidosToAttach);
            }
            pedidosCollectionNew = attachedPedidosCollectionNew;
            companyaenvios.setPedidosCollection(pedidosCollectionNew);
            companyaenvios = em.merge(companyaenvios);
            for (Pedidos pedidosCollectionOldPedidos : pedidosCollectionOld) {
                if (!pedidosCollectionNew.contains(pedidosCollectionOldPedidos)) {
                    pedidosCollectionOldPedidos.setFormaEnvio(null);
                    pedidosCollectionOldPedidos = em.merge(pedidosCollectionOldPedidos);
                }
            }
            for (Pedidos pedidosCollectionNewPedidos : pedidosCollectionNew) {
                if (!pedidosCollectionOld.contains(pedidosCollectionNewPedidos)) {
                    Companyaenvios oldFormaEnvioOfPedidosCollectionNewPedidos = pedidosCollectionNewPedidos.getFormaEnvio();
                    pedidosCollectionNewPedidos.setFormaEnvio(companyaenvios);
                    pedidosCollectionNewPedidos = em.merge(pedidosCollectionNewPedidos);
                    if (oldFormaEnvioOfPedidosCollectionNewPedidos != null && !oldFormaEnvioOfPedidosCollectionNewPedidos.equals(companyaenvios)) {
                        oldFormaEnvioOfPedidosCollectionNewPedidos.getPedidosCollection().remove(pedidosCollectionNewPedidos);
                        oldFormaEnvioOfPedidosCollectionNewPedidos = em.merge(oldFormaEnvioOfPedidosCollectionNewPedidos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = companyaenvios.getIdCompanyaEnvios();
                if (findCompanyaenvios(id) == null) {
                    throw new NonexistentEntityException("The companyaenvios with id " + id + " no longer exists.");
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
            Companyaenvios companyaenvios;
            try {
                companyaenvios = em.getReference(Companyaenvios.class, id);
                companyaenvios.getIdCompanyaEnvios();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The companyaenvios with id " + id + " no longer exists.", enfe);
            }
            Collection<Pedidos> pedidosCollection = companyaenvios.getPedidosCollection();
            for (Pedidos pedidosCollectionPedidos : pedidosCollection) {
                pedidosCollectionPedidos.setFormaEnvio(null);
                pedidosCollectionPedidos = em.merge(pedidosCollectionPedidos);
            }
            em.remove(companyaenvios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Companyaenvios> findCompanyaenviosEntities() {
        return findCompanyaenviosEntities(true, -1, -1);
    }

    public List<Companyaenvios> findCompanyaenviosEntities(int maxResults, int firstResult) {
        return findCompanyaenviosEntities(false, maxResults, firstResult);
    }

    private List<Companyaenvios> findCompanyaenviosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Companyaenvios.class));
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

    public Companyaenvios findCompanyaenvios(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Companyaenvios.class, id);
        } finally {
            em.close();
        }
    }

    public int getCompanyaenviosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Companyaenvios> rt = cq.from(Companyaenvios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
