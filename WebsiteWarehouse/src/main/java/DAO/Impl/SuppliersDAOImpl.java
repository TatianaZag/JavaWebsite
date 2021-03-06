package DAO.Impl;

import Classes.Suppliers;
import DAO.SuppliersDAO;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class SuppliersDAOImpl implements SuppliersDAO {
    @Override
    public void create(Suppliers suppliers) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(suppliers);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Suppliers suppliers) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(suppliers);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Suppliers suppliers) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(suppliers);
        tx1.commit();
        session.close();
    }

    @Override
    public Suppliers readById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Suppliers suppliers = session.get(Suppliers.class, id);
        session.close();
        return suppliers;
    }

    @Override
    public List<Suppliers> readAllSuppliers() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaQuery<Suppliers> criteria = session.getCriteriaBuilder().createQuery(Suppliers.class);
        criteria.from(Suppliers.class);
        List<Suppliers> data = session.createQuery(criteria).getResultList();
        session.close();
        return data;
    }
}
