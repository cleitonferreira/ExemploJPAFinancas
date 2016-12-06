package br.com.nuvemapp.exemplojpafinancas.consultas;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.nuvemapp.exemplojpafinancas.model.Conta;
import br.com.nuvemapp.exemplojpafinancas.model.Movimentacao;
import br.com.nuvemapp.exemplojpafinancas.model.TipoMovimentacao;

public class ConsultaJPARelacionamentoTest {

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
	public void consultaJPARelacionamento() {

		double inicio = System.currentTimeMillis();

        Conta conta = new Conta();
//        conta.setId(5);
        conta.setTitular("William");
        conta.setBanco("Caixa");
        conta.setNumero("270989-0");
        conta.setAgencia("0567");
//        conta.setSaldo(new BigDecimal(534.98));

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Conta de Telefone");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("100.99"));
        
        movimentacao.setConta(conta);

        manager.getTransaction().begin();
        
        manager.persist(conta);
        manager.persist(movimentacao);

        manager.getTransaction().commit();

        double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio) / 1000 + "s");

	}

}