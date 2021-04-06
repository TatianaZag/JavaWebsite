package Services;

import Classes.Customers;
import DAO.CustomersDAO;
import DAO.Impl.CustomersDAOImpl;

public class CustomersServices {
    private CustomersDAO customerDAO = new CustomersDAOImpl();
    public CustomersServices() { }

    public void createCustomer(Customers customer) {
        customerDAO.create(customer);
    }

    public void updateCustomer(Customers customer) {
        customerDAO.update(customer);
    }

    public void deleteCustomer(Customers customer) {
        customerDAO.delete(customer);
    }

    public Customers readCustomerById(int id) {
        return customerDAO.readById(id);
    }
}
