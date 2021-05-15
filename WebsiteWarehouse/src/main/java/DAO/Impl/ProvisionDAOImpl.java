package DAO.Impl;

import Classes.Products;
import Classes.Provision;
import DAO.ProvisionDAO;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ProvisionDAOImpl implements ProvisionDAO {
    @Override
    public void create(Provision provision) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(provision);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Provision provision) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(provision);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Provision provision) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(provision);
        tx1.commit();
        session.close();
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
        Query<Provision> query = session.createQuery("SELECT d FROM Provision d JOIN d.id_product s WHERE s.id_product = :param", Provision.class)
                .setParameter("param", id);
        List<Provision> tmp = query.getResultList();
        session.close();
        return tmp;
    }

    @Override
    public List<Provision> readByIdCustomer(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Provision> query = session.createQuery("SELECT d FROM Provision d JOIN d.id_customer s WHERE s.id_customer = :param", Provision.class)
                .setParameter("param", id);
        List<Provision> tmp = query.getResultList();
        session.close();
        return tmp;
    }

    @Override
    public List<Provision> readAllProvision() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaQuery<Provision> criteria = session.getCriteriaBuilder().createQuery(Provision.class);
        criteria.from(Provision.class);
        List<Provision> data = session.createQuery(criteria).getResultList();
        session.close();
        return data;
    }
}
