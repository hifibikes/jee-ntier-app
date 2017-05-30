package it.corso.dao;

import it.corso.model.Nome;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class NomeDao
 * This contains only the Data Access Object operations, handling tx via JTA
 */
@Stateless
public class NomeDao {

    @PersistenceContext
    EntityManager em;
    
    public List<Nome> findAll() {
    	return em.createQuery("select n from Nome n", Nome.class).getResultList();
    }
    
    public void add(Nome nome) {
    	em.persist(nome);
    }
	
}
