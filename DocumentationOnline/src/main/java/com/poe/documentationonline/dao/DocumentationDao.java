package com.poe.documentationonline.dao;

import com.poe.documentationonline.entity.Documentation;
import com.poe.documentationonline.jpa.EntityManagerSingleton;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class DocumentationDao {
    
    public static void createDocumentation(Documentation documentationToCreate) {

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(documentationToCreate);
        tx.commit();
    }
    
    public static List<Documentation> findAllDocumentations() {

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        Query findAllQuery = entityManager.createQuery
                ("select d from Documentation d");
        return findAllQuery.getResultList();
    }
    public static Documentation findDocumentationById(Long id) {

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        Documentation documentation = entityManager.find(Documentation.class, id);
        return documentation;
    }

    public static void deleteDocumentation(Documentation documentation) {

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(documentation);
        tx.commit();
    }

    public static void updateDocumentation(Long id, Documentation updatedDocumentation) {

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        Documentation documentationToUpdate = entityManager.find(Documentation.class, id);
        documentationToUpdate.setNotNullData(updatedDocumentation);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(documentationToUpdate);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }
}