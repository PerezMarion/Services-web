package com.poe.documentationonline.dao;

import com.poe.documentationonline.entity.Category;
import com.poe.documentationonline.jpa.EntityManagerSingleton;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class CategoryDao {
    
    public static void createCategory(Category categoryTocreate){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(categoryTocreate);
        tx.commit();
    }
    
    public static List<Category> findAllCategories() {

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        Query findAllQuery = entityManager.createQuery
                ("select c from Category c");
        return findAllQuery.getResultList();
    }
    
    public static Category findCategoryById(Long id) {

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        Category categoryToFind = entityManager.find(Category.class, id);
        return categoryToFind;
    }

    public static void deleteCategory(Category categoryToDelete) {

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(categoryToDelete);
        tx.commit();
    }

    public static void updateCategory(Long id, Category updatedCategory) {

        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        Category categoryToUpdate = entityManager.find(Category.class, id);
        categoryToUpdate.setNotNullData(updatedCategory);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(categoryToUpdate);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }
}