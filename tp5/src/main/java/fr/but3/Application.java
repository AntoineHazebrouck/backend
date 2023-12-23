package fr.but3;

import fr.but3.model.Auteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application
{

	public static void main(String[] args)
	{
		EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("persistence-unit");
		EntityManager entityManager = emf.createEntityManager();

		System.out.println(entityManager.find(Auteur.class, 1));

		System.out.println("Hello World!");
	}
}
