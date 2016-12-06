package br.com.nuvemapp.exemplojpafinancas.consultas;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.nuvemapp.exemplojpafinancas.model.Conta;

public class ConsultaFuncaoMaxTest {

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
	public void consultaFuncaoMax() {

		Conta conta = manager.find(Conta.class, 2);//id 2 deve existir no banco

        TypedQuery<BigDecimal> query = manager.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta", BigDecimal.class);

        query.setParameter("pConta", conta);
        BigDecimal valorTotal = query.getSingleResult();
        System.out.println("Total de movimentações: " + valorTotal);

	}

}