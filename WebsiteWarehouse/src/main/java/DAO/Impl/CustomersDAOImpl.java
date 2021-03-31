package DAO.Impl;

import Classes.Customers;
import DAO.CustomersDAO;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomersDAOImpl implements CustomersDAO {
    public void create(Customers customer) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(customer);
            tx1.commit();
            session.close();
        } catch (Exception tmp) {
            System.out.println("Customers Create Exception thrown: " + tmp.getMessage());
        }
    }

    public void update(Customers customer) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(customer);
            tx1.commit();
            session.close();
        } catch (Exception tmp) {
            System.out.println("Customers Update Exception thrown: " + tmp.getMessage());
        }
    }

    public void delete(Customers customer) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(customer);
            tx1.commit();
            session.close();
        } catch (Exception tmp) {
            System.out.println("Customers Delete Exception thrown: " + tmp.getMessage());
        }
    }

    @Override
    public Customers readById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Customers customer = session.get(Customers.class, id);
        session.close();
        return customer;
    }
}
