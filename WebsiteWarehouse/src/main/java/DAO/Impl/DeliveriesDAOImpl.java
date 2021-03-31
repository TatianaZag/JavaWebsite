package DAO.Impl;

import Classes.Deliveries;
import DAO.DeliveriesDAO;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DeliveriesDAOImpl implements DeliveriesDAO {
    @Override
    public void create(Deliveries deliveries) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(deliveries);
            tx1.commit();
            session.close();
        } catch (Exception tmp) {
            System.out.println("Deliveries Create Exception thrown: " + tmp.getMessage());
        }
    }

    @Override
    public void update(Deliveries deliveries) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(deliveries);
            tx1.commit();
            session.close();
        } catch (Exception tmp) {
            System.out.println("Deliveries Update Exception thrown: " + tmp.getMessage());
        }
    }

    @Override
    public void delete(Deliveries deliveries) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(deliveries);
            tx1.commit();
            session.close();
        } catch (Exception tmp) {
            System.out.println("Deliveries Delete Exception thrown: " + tmp.getMessage());
        }
    }

    @Override
    public Deliveries readById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Deliveries deliveries = session.get(Deliveries.class, id);
        session.close();
        return deliveries;
    }

    @Override
    public List<Deliveries> readByIdProduct(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Deliveries> query = session.createQuery("FROM Deliveries WHERE id_product = :param", Deliveries.class)
                .setParameter("param", id);
        return query.getResultList();
    }

    @Override
    public List<Deliveries> readByIdSupplier(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Deliveries> query = session.createQuery("FROM Deliveries WHERE id_supplier = :param", Deliveries.class)
                .setParameter("param", id);
        return query.getResultList();
    }
}
