package Utils;

import Classes.Type_client;
import Classes.Deliveries;
import Classes.Suppliers;
import Classes.Provision;
import Classes.Products;
import Classes.Customers;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Type_client.class);
                configuration.addAnnotatedClass(Deliveries.class);
                configuration.addAnnotatedClass(Suppliers.class);
                configuration.addAnnotatedClass(Provision.class);
                configuration.addAnnotatedClass(Products.class);
                configuration.addAnnotatedClass(Customers.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                System.out.println("Exception: " + e);
            }
        }
        return sessionFactory;
    }
}