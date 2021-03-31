package DAO;
import Classes.Customers;

import java.util.List;
import java.util.Map;

public interface CustomersDAO {
    void create(Customers customers);
    void update(Customers customers);
    void delete(Customers customers);
    Customers readById(int id);
}
