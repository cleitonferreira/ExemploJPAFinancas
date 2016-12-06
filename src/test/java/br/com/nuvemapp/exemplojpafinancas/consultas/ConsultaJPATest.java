package br.com.nuvemapp.exemplojpafinancas.consultas;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.nuvemapp.exemplojpafinancas.model.Conta;
import br.com.nuvemapp.exemplojpafinancas.util.JpaUtil;

public class ConsultaJPATest {

	@Test
	public void consultaJPA() {

		double inicio = System.currentTimeMillis();

        EntityManager manager = new JpaUtil().getEntityManager();

        //manager.getTransaction().begin();
        
        Conta conta = manager.find(Conta.class, 4);
        
        System.out.println("Conta: "+ conta.getId() +" / "+ conta.getAgencia() +" / "+ conta.getBanco() +" / "+ conta.getNumero() +" / "+ conta.getTitular());

        double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio) / 1000 + "s");
	}

}