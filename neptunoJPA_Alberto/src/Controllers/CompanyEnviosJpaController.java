/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Controllers.exceptions.NonexistentEntityException;
import Controllers.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import neptunojpa.CompanyEnvios;

/**
 *
 * @author alumno
 */
public class CompanyEnviosJpaController implements Serializable {

    public CompanyEnviosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CompanyEnvios companyEnvios) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(companyEnvios);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCompanyEnvios(companyEnvios.getIdCompanyEnvios()) != null) {
                throw new PreexistingEntityException("CompanyEnvios " + companyEnvios + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CompanyEnvios companyEnvios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            companyEnvios = em.merge(companyEnvios);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = companyEnvios.getIdCompanyEnvios();
                if (findCompanyEnvios(id) == null) {
                    throw new NonexistentEntityException("The companyEnvios with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CompanyEnvios companyEnvios;
            try {
                companyEnvios = em.getReference(CompanyEnvios.class, id);
                companyEnvios.getIdCompanyEnvios();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The companyEnvios with id " + id + " no longer exists.", enfe);
            }
            em.remove(companyEnvios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CompanyEnvios> findCompanyEnviosEntities() {
        return findCompanyEnviosEntities(true, -1, -1);
    }

    public List<CompanyEnvios> findCompanyEnviosEntities(int maxResults, int firstResult) {
        return findCompanyEnviosEntities(false, maxResults, firstResult);
    }

    private List<CompanyEnvios> findCompanyEnviosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CompanyEnvios.class));
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

    public CompanyEnvios findCompanyEnvios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CompanyEnvios.class, id);
        } finally {
            em.close();
        }
    }

    public int getCompanyEnviosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CompanyEnvios> rt = cq.from(CompanyEnvios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
