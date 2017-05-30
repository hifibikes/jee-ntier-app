package it.corso.test;

import java.io.File;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.exporter.ZipExporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public class ArquillianTest {

	Logger log = Logger.getLogger(ArquillianTest.class);
	
	@Deployment(name = "CorsoTest")
	@OverProtocol("Servlet 3.0") // Evita il timeout sui test lunghi eseguiti da Eclipse
	public static Archive<?> createDeployment() {
	
		WebArchive archive = ShrinkWrap.create(WebArchive.class, "CorsoTest.war")
        .addPackages(true, "it.corso.controllers")
        .addPackages(true, "it.corso.dao")
        .addPackages(true, "it.corso.model")
        .addPackages(true, "it.corso.test")
        .addPackages(true, "it.corso.logic")
        .addAsResource("META-INF/persistence.xml")
        /*.addAsResource("META-INF/ejb-jar.xml")*/
        /*.addAsLibraries(Maven.resolver().loadPomFromFile("pom.xml").resolve("org.apache.httpcomponents:httpmime").withTransitivity().asFile())*/
        .addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"));
		
		// Esportazione di prova per controllo
		  archive.as(ZipExporter.class).exportTo(
				    new File("target/arquillianPackage.war"), true);
		
		return archive;
		
	}
	
	
}
	