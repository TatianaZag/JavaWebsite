package DAO.Impl;

import Classes.Products;
import DAO.ProductsDAO;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Date;
import java.util.List;

public class ProductsDAOImpl implements ProductsDAO {
    @Override
    public void create(Products product) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(product);
            tx1.commit();
            session.close();
        } catch (Exception tmp) {
            System.out.println("Products Create Exception thrown: " + tmp.getMessage());
        }
    }

    @Override
    public void update(Products product) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(product);
            tx1.commit();
            session.close();
        } catch (Exception tmp) {
            System.out.println("Products Update Exception thrown: " + tmp.getMessage());
        }
    }

    @Override
    public void delete(Products product) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(product);
            tx1.commit();
            session.close();
        } catch (Exception tmp) {
            System.out.println("Products Delete Exception thrown: " + tmp.getMessage());
        }
    }

    @Override
    public Products readById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Products product = session.get(Products.class, id);
        session.close();
        return product;
    }

    @Override
    public List<Products> readByStorageLocation(int num_storage) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Products> query = session.createQuery("FROM Products WHERE storage_location = :param", Products.class)
                .setParameter("param", num_storage);
        return query.getResultList();
    }

    @Override
    public List<Products> readByTypeProduct(String type) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Products> query = session.createQuery("FROM Products WHERE type_prod = :param", Products.class)
                .setParameter("param", type);
        return query.getResultList();
    }

    @Override
    public List<Products> readByDate(Date date) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Products> query = session.createQuery("FROM Products WHERE date_prod = :param", Products.class)
                .setParameter("param", date);
        return query.getResultList();
    }
}
