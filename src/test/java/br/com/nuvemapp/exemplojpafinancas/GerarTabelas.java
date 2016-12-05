package br.com.nuvemapp.exemplojpafinancas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerarTabelas {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("financas");

	public static EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	public static void main(String[] args) {
		// Executando esse código antes dos testes, irá fazer o hibernate gerar
		// as tabelas a partir do arquivo persistence.xml
		EntityManager manager = GerarTabelas.createEntityManager();
		manager.close();
		System.out.println(">>>>> Tabelas geradas com sucesso! <<<<<<<");
		System.exit(0);

	}
}
