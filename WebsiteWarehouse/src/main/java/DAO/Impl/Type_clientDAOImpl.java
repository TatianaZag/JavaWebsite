package DAO.Impl;

import Classes.Type_client;
import DAO.Type_clientDAO;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Type_clientDAOImpl implements Type_clientDAO {
    @Override
    public void create(Type_client type) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(type);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Type_client type) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(type);
        tx1.commit();
        session.close();
    }

    @Override
    public Type_client readById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Type_client type = session.get(Type_client.class, id);
        session.close();
        return type;
    }
}
