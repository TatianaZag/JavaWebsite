package DAO.Impl;

import Classes.Deliveries;
import Classes.Products;
import DAO.DeliveriesDAO;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import java.sql.Date;
import java.util.List;

public class DeliveriesDAOImpl implements DeliveriesDAO {
    @Override
    public void create(Deliveries deliveries) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(deliveries);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Deliveries deliveries) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(deliveries);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Deliveries deliveries) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(deliveries);
        tx1.commit();
        session.close();
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
        Query<Deliveries> query = session.createQuery("SELECT d FROM Deliveries d JOIN d.id_product s WHERE s.id_product = :param", Deliveries.class)
                .setParameter("param", id);
        List<Deliveries> tmp = query.getResultList();
        session.close();
        return tmp;
    }

    @Override
    public List<Deliveries> readByIdSupplier(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Deliveries> query = session.createQuery("SELECT d FROM Deliveries d JOIN d.id_supplier s WHERE s.id_supplier = :param", Deliveries.class)
                .setParameter("param", id);
        List<Deliveries> tmp = query.getResultList();
        session.close();
        return tmp;
    }

    @Override
    public List<Deliveries> readAllDeliveries() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaQuery<Deliveries> criteria = session.getCriteriaBuilder().createQuery(Deliveries.class);
        criteria.from(Deliveries.class);
        List<Deliveries> data = session.createQuery(criteria).getResultList();
        session.close();
        return data;
    }

    @Override
    public List<Deliveries> findDeliveriesByDateAfter(Date date) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Deliveries> query = session.createQuery("FROM Deliveries d WHERE d.date_deliver >= :param", Deliveries.class)
                .setParameter("param", date);
        List<Deliveries> tmp = query.getResultList();
        session.close();
        return tmp;
    }

    @Override
    public List<Deliveries> findDeliveriesByDateBefore(Date date) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Deliveries> query = session.createQuery("FROM Deliveries d WHERE d.date_deliver <= :param", Deliveries.class)
                .setParameter("param", date);
        List<Deliveries> tmp = query.getResultList();
        session.close();
        return tmp;
    }
}
