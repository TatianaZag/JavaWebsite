package DAO.Impl;

import Classes.Customers;
import Classes.Suppliers;
import DAO.CustomersDAO;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class CustomersDAOImpl implements CustomersDAO {
    public void create(Customers customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(customer);
        tx1.commit();
        session.close();
    }

    public void update(Customers customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(customer);
        tx1.commit();
        session.close();
    }

    public void delete(Customers customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(customer);
        tx1.commit();
        session.close();
    }

    @Override
    public Customers readById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Customers customer = session.get(Customers.class, id);
        session.close();
        return customer;
    }

    @Override
    public List<Customers> readAllCustomers() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaQuery<Customers> criteria = session.getCriteriaBuilder().createQuery(Customers.class);
        criteria.from(Customers.class);
        List<Customers> data = session.createQuery(criteria).getResultList();
        session.close();
        return data;
    }
}
