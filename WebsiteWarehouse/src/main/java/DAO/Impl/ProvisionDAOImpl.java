package DAO.Impl;

import Classes.Provision;
import DAO.ProvisionDAO;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProvisionDAOImpl implements ProvisionDAO {
    @Override
    public void create(Provision provision) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(provision);
            tx1.commit();
            session.close();
        } catch (Exception tmp) {
            System.out.println("Provision Create Exception thrown: " + tmp.getMessage());
        }
    }

    @Override
    public void update(Provision provision) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(provision);
            tx1.commit();
            session.close();
        } catch (Exception tmp) {
            System.out.println("Provision Update Exception thrown: " + tmp.getMessage());
        }
    }

    @Override
    public void delete(Provision provision) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(provision);
            tx1.commit();
            session.close();
        } catch (Exception tmp) {
            System.out.println("Provision Delete Exception thrown: " + tmp.getMessage());
        }
    }

    @Override
    public Provision readById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Provision provision = session.get(Provision.class, id);
        session.close();
        return provision;
    }

    @Override
    public List<Provision> readByIdProduct(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Provision> query = session.createQuery("FROM Provision WHERE id_product = :param", Provision.class)
                .setParameter("param", id);
        return query.getResultList();
    }

    @Override
    public List<Provision> readByIdCustomer(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Provision> query = session.createQuery("FROM Provision WHERE id_product = :param", Provision.class)
                .setParameter("param", id);
        return query.getResultList();
    }
}
