
package com.mycompany.inmobiliariahernie.persistencia;

import com.mycompany.inmobiliariahernie.logica.Inquilino;
import com.mycompany.inmobiliariahernie.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class InquilinoJpaController implements Serializable {

    public InquilinoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public InquilinoJpaController() {
        emf = Persistence.createEntityManagerFactory("InmoHerniePU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Inquilino inquilino) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(inquilino);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Inquilino inquilino) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            inquilino = em.merge(inquilino);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = inquilino.getId_inquilino();
                if (findInquilino(id) == null) {
                    throw new NonexistentEntityException("The inquilino with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Inquilino inquilino;
            try {
                inquilino = em.getReference(Inquilino.class, id);
                inquilino.getId_inquilino();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The inquilino with id " + id + " no longer exists.", enfe);
            }
            em.remove(inquilino);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Inquilino> findInquilinoEntities() {
        return findInquilinoEntities(true, -1, -1);
    }

    public List<Inquilino> findInquilinoEntities(int maxResults, int firstResult) {
        return findInquilinoEntities(false, maxResults, firstResult);
    }

    private List<Inquilino> findInquilinoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Inquilino.class));
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

    public Inquilino findInquilino(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Inquilino.class, id);
        } finally {
            em.close();
        }
    }

    public int getInquilinoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Inquilino> rt = cq.from(Inquilino.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
