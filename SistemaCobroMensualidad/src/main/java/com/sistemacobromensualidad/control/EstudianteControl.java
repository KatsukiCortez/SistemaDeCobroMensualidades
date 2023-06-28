package com.sistemacobromensualidad.control;

/*import com.sistemacobromensualidad.control.exceptions.EntidadPreexistenteException;
import com.sistemacobromensualidad.control.exceptions.NoExisteEntidadException;
import com.sistemacobromensualidad.entidades.Estudiante;
import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class EstudianteControl implements Serializable {
    public EstudianteControl(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    // METODO INSERTAR
    public int insertar(Estudiante estudiante) throws EntidadPreexistenteException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(estudiante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (buscaEstudiante(estudiante.getEstudianteId()) != null) {
                throw new EntidadPreexistenteException("Estudiante " + estudiante + " ya existe en la base de datos.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return estudiante.getEstudianteId();
    }
    
    // Editar un estudiante
    public void editar(Estudiante estudiante) throws NoExisteEntidadException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            estudiante = em.merge(estudiante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estudiante.getEstudianteId();
                if (buscaEstudiante(id) == null) {
                    throw new NoExisteEntidadException("El estudiante con el id " + id + " no existe.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Eliminar un estudiante
    public void eliminar(Integer id) throws NoExisteEntidadException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudiante estudiante;
            try {
                estudiante = em.getReference(Estudiante.class, id);
                estudiante.getEstudianteId();
            } catch (EntityNotFoundException enfe) {
                throw new NoExisteEntidadException("El estudiante con el id " + id + " no existe.", enfe);
            }
            em.remove(estudiante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Buscar estudiantes
    public List<Estudiante> buscaEstudiantes() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Estudiante> query = em.createNamedQuery("Estudiante.seleccionaTodos", Estudiante.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    // BUSCAR ESTUDIANTE
    public Estudiante buscaEstudiante(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estudiante.class, id);
        } finally {
            em.close();
        }
    }

    // OBTENER TOTAL DE ESTUDIANTES
    public int getTotalEstudiante() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estudiante> rt = cq.from(Estudiante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}*/
