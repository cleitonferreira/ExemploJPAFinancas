package br.com.nuvemapp.exemplojpafinancas.consultas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.nuvemapp.exemplojpafinancas.model.Conta;

public class ConsultaGerenciamentoJPATest {

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
	public void consultaGerenciamentoJPA() {

		manager.getTransaction().begin();

        // ID de uma conta que exista no banco de dados, no caso ID: 1
        Conta conta = manager.find(Conta.class, 4);

        // commit antes da alteração
        manager.getTransaction().commit();

        // Alteração do titular da conta
        conta.setTitular("Cleiton Ferreira");
        
        manager.getTransaction().begin();
        manager.merge(conta);
        manager.getTransaction().commit();

	}

}