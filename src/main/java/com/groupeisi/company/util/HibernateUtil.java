package com.groupeisi.company.util;

import com.groupeisi.company.entities.Product;
import com.groupeisi.company.entities.Purchases;
import com.groupeisi.company.entities.Sales;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    // Explicitly add entity classes (belt-and-suspenders with the XML mapping)
                    .addAnnotatedClass(Product.class)
                    .addAnnotatedClass(Purchases.class)
                    .addAnnotatedClass(Sales.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            throw new ExceptionInInitializerError("Failed to build SessionFactory: " + e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}