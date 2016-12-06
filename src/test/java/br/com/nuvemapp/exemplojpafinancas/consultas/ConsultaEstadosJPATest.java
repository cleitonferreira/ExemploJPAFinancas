package br.com.nuvemapp.exemplojpafinancas.consultas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.nuvemapp.exemplojpafinancas.model.Conta;

public class ConsultaEstadosJPATest {

	private static EntityManagerFactory factory;

	private EntityManager manager;

	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("financas");
	}

	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
	}

	@After
	public void tearDown() {
		this.manager.close();
	}

	@Test
	public void consultaEstadosJPA() {

		Conta conta = manager.find(Conta.class, 5);

		System.out.println("Antes:" + conta.getTitular());

		manager.getTransaction().begin();

			conta.setTitular("Fred William");

			System.out.println("Depois:" + conta.getTitular());

		manager.getTransaction().commit();

	}

}