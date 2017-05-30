package it.corso.logic;

import it.corso.dao.NomeDao;
import it.corso.model.Nome;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * The business logic layer performs data manipulation and decisions,
 * writing and fetching data via the DAO layer
 * @author barbieri
 *
 */
@Stateless
public class HelloCalc {

	@Inject NomeDao nomeDao;
	
	public List<Nome> performSalute(String name) {
		
		Nome nome = new Nome();
		nome.setNome(name);
		nomeDao.add(nome);
		return nomeDao.findAll();
		
	}
	
}
