/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.exceptions.NonexistentEntityException;
import entities.CompanyaEnvios;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class CompanyaEnviosJpaController implements Serializable {

    public CompanyaEnviosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CompanyaEnvios companyaEnvios) {
        if (companyaEnvios.getPedidosCollection() == null) {
            companyaEnvios.setPedidosCollection(new ArrayList<Pedidos>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Pedidos> attachedPedidosCollection = new ArrayList<Pedidos>();
            for (Pedidos pedidosCollectionPedidosToAttach : companyaEnvios.getPedidosCollection()) {
                pedidosCollectionPedidosToAttach = em.getReference(pedidosCollectionPedidosToAttach.getClass(), pedidosCollectionPedidosToAttach.getIdPedido());
                attachedPedidosCollection.add(pedidosCollectionPedidosToAttach);
            }
            companyaEnvios.setPedidosCollection(attachedPedidosCollection);
            em.persist(companyaEnvios);
            for (Pedidos pedidosCollectionPedidos : companyaEnvios.getPedidosCollection()) {
                CompanyaEnvios oldFormaEnvioOfPedidosCollectionPedidos = pedidosCollectionPedidos.getFormaEnvio();
                pedidosCollectionPedidos.setFormaEnvio(companyaEnvios);
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

    public void edit(CompanyaEnvios companyaEnvios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CompanyaEnvios persistentCompanyaEnvios = em.find(CompanyaEnvios.class, companyaEnvios.getIdCompanyaEnvios());
            Collection<Pedidos> pedidosCollectionOld = persistentCompanyaEnvios.getPedidosCollection();
            Collection<Pedidos> pedidosCollectionNew = companyaEnvios.getPedidosCollection();
            Collection<Pedidos> attachedPedidosCollectionNew = new ArrayList<Pedidos>();
            for (Pedidos pedidosCollectionNewPedidosToAttach : pedidosCollectionNew) {
                pedidosCollectionNewPedidosToAttach = em.getReference(pedidosCollectionNewPedidosToAttach.getClass(), pedidosCollectionNewPedidosToAttach.getIdPedido());
                attachedPedidosCollectionNew.add(pedidosCollectionNewPedidosToAttach);
            }
            pedidosCollectionNew = attachedPedidosCollectionNew;
            companyaEnvios.setPedidosCollection(pedidosCollectionNew);
            companyaEnvios = em.merge(companyaEnvios);
            for (Pedidos pedidosCollectionOldPedidos : pedidosCollectionOld) {
                if (!pedidosCollectionNew.contains(pedidosCollectionOldPedidos)) {
                    pedidosCollectionOldPedidos.setFormaEnvio(null);
                    pedidosCollectionOldPedidos = em.merge(pedidosCollectionOldPedidos);
                }
            }
            for (Pedidos pedidosCollectionNewPedidos : pedidosCollectionNew) {
                if (!pedidosCollectionOld.contains(pedidosCollectionNewPedidos)) {
                    CompanyaEnvios oldFormaEnvioOfPedidosCollectionNewPedidos = pedidosCollectionNewPedidos.getFormaEnvio();
                    pedidosCollectionNewPedidos.setFormaEnvio(companyaEnvios);
                    pedidosCollectionNewPedidos = em.merge(pedidosCollectionNewPedidos);
                    if (oldFormaEnvioOfPedidosCollectionNewPedidos != null && !oldFormaEnvioOfPedidosCollectionNewPedidos.equals(companyaEnvios)) {
                        oldFormaEnvioOfPedidosCollectionNewPedidos.getPedidosCollection().remove(pedidosCollectionNewPedidos);
                        oldFormaEnvioOfPedidosCollectionNewPedidos = em.merge(oldFormaEnvioOfPedidosCollectionNewPedidos);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = companyaEnvios.getIdCompanyaEnvios();
                if (findCompanyaEnvios(id) == null) {
                    throw new NonexistentEntityException("The companyaEnvios with id " + id + " no longer exists.");
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
            CompanyaEnvios companyaEnvios;
            try {
                companyaEnvios = em.getReference(CompanyaEnvios.class, id);
                companyaEnvios.getIdCompanyaEnvios();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The companyaEnvios with id " + id + " no longer exists.", enfe);
            }
            Collection<Pedidos> pedidosCollection = companyaEnvios.getPedidosCollection();
            for (Pedidos pedidosCollectionPedidos : pedidosCollection) {
                pedidosCollectionPedidos.setFormaEnvio(null);
                pedidosCollectionPedidos = em.merge(pedidosCollectionPedidos);
            }
            em.remove(companyaEnvios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CompanyaEnvios> findCompanyaEnviosEntities() {
        return findCompanyaEnviosEntities(true, -1, -1);
    }

    public List<CompanyaEnvios> findCompanyaEnviosEntities(int maxResults, int firstResult) {
        return findCompanyaEnviosEntities(false, maxResults, firstResult);
    }

    private List<CompanyaEnvios> findCompanyaEnviosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CompanyaEnvios.class));
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

    public CompanyaEnvios findCompanyaEnvios(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CompanyaEnvios.class, id);
        } finally {
            em.close();
        }
    }

    public int getCompanyaEnviosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CompanyaEnvios> rt = cq.from(CompanyaEnvios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
