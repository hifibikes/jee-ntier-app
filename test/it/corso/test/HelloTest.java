package it.corso.test;

import it.corso.controllers.HelloBean;
import it.corso.dao.NomeDao;
import it.corso.model.Nome;

import java.util.List;

import javax.inject.Inject;

import junit.framework.Assert;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class HelloTest extends ArquillianTest {
	
	@Inject HelloBean helloBean;
	@Inject NomeDao nomeDao;
	
	@Test
	public void testName() {
		
		helloBean.setName("geppo");
		helloBean.doSalute();
		List<Nome> nomi = nomeDao.findAll();
		
		boolean found = false;
		for(Nome nome: nomi) {
			if (nome.getNome().equals("geppo")) {
				found = true;
				break;
			}
		}
		
		Assert.assertTrue(found);
		
	}

}
