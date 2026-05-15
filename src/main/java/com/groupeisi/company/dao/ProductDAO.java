package com.groupeisi.company.dao;

import com.groupeisi.company.entities.Product;
import com.groupeisi.company.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAO {

    public void save(Product product) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(product);   // ← Hibernate 6: persist() replaces save()
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public List<Product> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Hibernate 6: HQL works the same, just make sure the type is explicit
            return session.createQuery("FROM Product", Product.class).list();
        }
    }
}