package com.poe.documentationonline.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerSingleton {
    
    private static EntityManager entityManager;
    
    public static EntityManager getEntityManager() {
        
        if(entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("doc");
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }
}
