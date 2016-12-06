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

public class ConsultaComDAOTest {

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
	public void consultaComDAO() {
		
        Conta conta = manager.find(Conta.class, 2);//id 2 deve existir no banco

        MovimentacaoDao dao = new MovimentacaoDao(manager);
        Double media = dao.mediaDaConta(conta);
        System.out.println("Média da conta: "+conta.getNumero()+" de: "+conta.getTitular()+" é: R$ "+media);

	}

}