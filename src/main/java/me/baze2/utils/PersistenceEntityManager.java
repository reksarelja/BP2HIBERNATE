package me.baze2.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class PersistenceEntityManager {

	private static PersistenceEntityManager instance;
	private final EntityManagerFactory emf;


	private PersistenceEntityManager(String persistenceUnitName){
		emf = Persistence.createEntityManagerFactory(persistenceUnitName);
	}

	public static synchronized PersistenceEntityManager getInstance(String persistenceUnitName){
		if(instance == null){
			instance = new PersistenceEntityManager(persistenceUnitName);
		}
		return instance;
	}

	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}

}

