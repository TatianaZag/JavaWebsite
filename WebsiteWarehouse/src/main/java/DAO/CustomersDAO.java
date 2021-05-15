package DAO;
import Classes.Customers;

import java.util.List;

public interface CustomersDAO {
    void create(Customers customers);
    void update(Customers customers);
    void delete(Customers customers);
    Customers readById(int id);
    List<Customers> readAllCustomers();
}
