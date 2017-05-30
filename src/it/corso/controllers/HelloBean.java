package it.corso.controllers;

import it.corso.logic.HelloCalc;
import it.corso.model.Nome;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * Named bean, it only handles mechanics related to the presentation layer,
 * it connects with the business logic layer to trigger calculations
 * @author barbieri
 *
 */
@Named
@SessionScoped
public class HelloBean implements Serializable {

	@Inject HelloCalc helloCalc;
	
	private String name;
	private List<String> salutes;
	private String salute;
	private List<Nome> nomi;
	
	@PostConstruct
	public void init() {
		salutes = new ArrayList<String>();
		salutes.add("Prof.");
		salutes.add("Dott.");
		salutes.add("Dott.Ing.");
		salutes.add("Cav.Uff.");
		salutes.add("Gr.Lup.Mann.");
		
		nomi = new ArrayList<Nome>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSalutes() {
		return salutes;
	}

	public void setSalutes(List<String> salutes) {
		this.salutes = salutes;
	}
	
	public String doSalute() {
		setSalute(name);
		List<Nome> nomi = helloCalc.performSalute(name);
		setNomi(nomi);		
		return null;
	}

	public String getSalute() {
		return salute;
	}

	public void setSalute(String salute) {
		this.salute = salute;
	}

	public List<Nome> getNomi() {
		return nomi;
	}

	public void setNomi(List<Nome> nomi) {
		this.nomi = nomi;
	}
}
