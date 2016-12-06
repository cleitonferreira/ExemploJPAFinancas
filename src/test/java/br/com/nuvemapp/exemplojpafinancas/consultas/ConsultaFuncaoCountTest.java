package br.com.nuvemapp.exemplojpafinancas.consultas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.nuvemapp.exemplojpafinancas.model.Conta;

public class ConsultaFuncaoCountTest {

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
	public void consultaFuncaoCount() {

		Conta conta = manager.find(Conta.class, 3);//id 3 deve existir no banco

        TypedQuery<Long> query = manager.createQuery("select count(m) from Movimentacao m where m.conta = :pConta", Long.class);

        query.setParameter("pConta", conta);
        Long quantidade = query.getSingleResult();
        System.out.println("Total de movimentações: " + quantidade);

	}

}