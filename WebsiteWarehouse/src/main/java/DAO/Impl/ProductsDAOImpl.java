package DAO.Impl;

import Classes.Products;
import Classes.Suppliers;
import DAO.ProductsDAO;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import java.sql.Date;
import java.util.List;

public class ProductsDAOImpl implements ProductsDAO {
    @Override
    public void create(Products product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(product);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Products product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(product);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Products product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(product);
        tx1.commit();
        session.close();
    }

    @Override
    public Products readById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Products product = session.get(Products.class, id);
        session.close();
        return product;
    }

    @Override
    public List<Products> readByStorageLocation(String num_storage) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Products> query = session.createQuery("FROM Products d WHERE d.storage_location = :param", Products.class)
                .setParameter("param", num_storage);
        List<Products> tmp = query.getResultList();
        session.close();
        return tmp;
    }

    @Override
    public List<Products> readByTypeProduct(String type) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Products> query = session.createQuery("FROM Products WHERE type_prod = :param", Products.class)
                .setParameter("param", type);
        List<Products> tmp = query.getResultList();
        session.close();
        return tmp;
    }

    @Override
    public List<Products> readByDate(Date date) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Products> query = session.createQuery("FROM Products WHERE date_prod = :param", Products.class)
                .setParameter("param", date);
        List<Products> tmp = query.getResultList();
        session.close();
        return tmp;
    }

    @Override
    public List<Products> readAllProduct() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaQuery<Products> criteria = session.getCriteriaBuilder().createQuery(Products.class);
        criteria.from(Products.class);
        List<Products> data = session.createQuery(criteria).getResultList();
        session.close();
        return data;
    }

    @Override
    public List<Products> findProductByIdSupplier(Suppliers supplier) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Products> query = session.createQuery("SELECT d FROM Products d WHERE d.id_supplier = :param", Products.class)
                .setParameter("param", supplier);
        List<Products> tmp = query.getResultList();
        session.close();
        return tmp;
    }

    @Override
    public List<Products> findProductByType(String type) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Products> query = session.createQuery("FROM Products d WHERE d.type_prod = :param", Products.class)
                .setParameter("param", type);
        List<Products> tmp = query.getResultList();
        session.close();
        return tmp;
    }

    @Override
    public List<Products> findProductByDateAfter(Date date) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Products> query = session.createQuery("FROM Products d WHERE d.date_prod >= :param", Products.class)
                .setParameter("param", date);
        List<Products> tmp = query.getResultList();
        session.close();
        return tmp;
    }

    @Override
    public List<Products> findProductByDateBefore(Date date) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<Products> query = session.createQuery("FROM Products d WHERE d.date_prod <= :param", Products.class)
                .setParameter("param", date);
        List<Products> tmp = query.getResultList();
        session.close();
        return tmp;
    }
}
