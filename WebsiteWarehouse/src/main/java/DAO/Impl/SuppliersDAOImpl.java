package DAO.Impl;

import Classes.Suppliers;
import DAO.SuppliersDAO;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SuppliersDAOImpl implements SuppliersDAO {
    @Override
    public void create(Suppliers suppliers) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(suppliers);
            tx1.commit();
            session.close();
        } catch (Exception tmp) {
            System.out.println("Suppliers Create Exception thrown: " + tmp.getMessage());
        }
    }

    @Override
    public void update(Suppliers suppliers) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(suppliers);
            tx1.commit();
            session.close();
        } catch (Exception tmp) {
            System.out.println("Suppliers Update Exception thrown: " + tmp.getMessage());
        }
    }

    @Override
    public void delete(Suppliers suppliers) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(suppliers);
            tx1.commit();
            session.close();
        } catch (Exception tmp) {
            System.out.println("Suppliers Delete Exception thrown: " + tmp.getMessage());
        }
    }

    @Override
    public Suppliers readById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Suppliers suppliers = session.get(Suppliers.class, id);
        session.close();
        return suppliers;
    }
}
