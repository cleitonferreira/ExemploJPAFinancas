package br.com.nuvemapp.exemplojpafinancas.consultas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.nuvemapp.exemplojpafinancas.dao.MovimentacaoDao;
import br.com.nuvemapp.exemplojpafinancas.model.Conta;

public class ConsultaComNamedQueryTest {

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
	public void consultaComNamedQuery() {

		Conta conta = new Conta();
		conta.setId(3);

		MovimentacaoDao dao = new MovimentacaoDao(manager);
		Long total = dao.totalDeMovimentacoes(conta);

		System.out.println(total);

	}

}