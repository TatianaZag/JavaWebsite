package DAO.Impl;

import Classes.Type_client;
import DAO.Type_clientDAO;
import Utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Type_clientDAOImpl implements Type_clientDAO {
    @Override
    public Type_client readById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Type_client name = session.get(Type_client.class, id);
        session.close();
        return name;
    }
}
