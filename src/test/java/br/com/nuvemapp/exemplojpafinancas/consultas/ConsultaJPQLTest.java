package br.com.nuvemapp.exemplojpafinancas.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.nuvemapp.exemplojpafinancas.model.Conta;
import br.com.nuvemapp.exemplojpafinancas.model.Movimentacao;
import br.com.nuvemapp.exemplojpafinancas.model.TipoMovimentacao;

public class ConsultaJPQLTest {

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

	@SuppressWarnings("unchecked")
	@Test
	public void consultaJPQL() {

		Conta conta = new Conta();
        conta.setId(2);

        Query query = manager.createQuery("select m from Movimentacao m where m.conta=:pConta "
                + "and m.tipoMovimentacao=:pTipo ");

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        List<Movimentacao> movimentacoes = query.getResultList();

        for (Movimentacao mov : movimentacoes) {
            System.out.println("Descrição:.......: " + mov.getDescricao());
            System.out.println("Valor:...........: " + mov.getValor());
            System.out.println("Tipo:............: " + mov.getTipoMovimentacao());
        }

//            int i = 0;
//            do {
//                System.out.println("Descrição:.......: " + movimentacoes.get(i).getDescricao());
//                System.out.println("Valor:...........: " + movimentacoes.get(i).getValor());
//                i = i + 1;
//            } while (i < movimentacoes.size());

//        int i = 0;
//        while (i < movimentacoes.size()) {
//            System.out.println("Descrição:.......: " + movimentacoes.get(i).getDescricao() + "");
//            System.out.println("Valor:...........: " + movimentacoes.get(i).getValor() + "");
//            i = i +1;
//        }


	}

}