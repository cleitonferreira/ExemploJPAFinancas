package br.com.nuvemapp.exemplojpafinancas.consultas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.nuvemapp.exemplojpafinancas.model.Movimentacao;

public class ConsultaMovimentacaoContaTest {

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
	public void consultaMovimentacaoConta() {

        Movimentacao movimentacao = manager
                .find(Movimentacao.class, 2); // id 2 deve existir no banco
        
        System.out.println(movimentacao.getConta().getTitular());

	}

}