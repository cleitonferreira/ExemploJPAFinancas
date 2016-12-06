package br.com.nuvemapp.exemplojpafinancas.consultas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.nuvemapp.exemplojpafinancas.model.Conta;

public class ContaMovimentacoesTest {

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
	public void consultaMovimentacoes() {

//      Conta conta = manager.find(Conta.class, 2); //id deve existir
      Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes where c.id = :pId");
      query.setParameter("pId", 2);
      Conta conta = (Conta) query.getSingleResult();

      System.out.println(conta.getMovimentacoes().size());

	}

}