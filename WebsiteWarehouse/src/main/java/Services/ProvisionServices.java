package Services;

import Classes.Deliveries;
import Classes.Products;
import Classes.Provision;
import DAO.Impl.ProvisionDAOImpl;
import DAO.ProvisionDAO;

import java.sql.Date;
import java.util.List;

public class ProvisionServices {
    private ProvisionDAO provisionDAO = new ProvisionDAOImpl();
    public void createProvision(Provision provision) {
        provisionDAO.create(provision);
    }

    public void updateProvision(Provision provision) {
        provisionDAO.update(provision);
    }

    public void deleteProvision(Provision provision) {
        provisionDAO.delete(provision);
    }

    public Provision readProvisionById(int id) {
        return provisionDAO.readById(id);
    }

    public List<Provision> readProvisionByIdProduct(int id) {
        return provisionDAO.readByIdProduct(id);
    }

    public List<Provision> readProvisionByIdCustomer(int id) {
        return provisionDAO.readByIdCustomer(id);
    }

    public List<Provision> readProvisionAll() {
        return provisionDAO.readAllProvision();
    }

    public List<Provision> findProvisionByDB(Date date) {
        return provisionDAO.findProvisionsByDateBefore(date);
    }

    public List<Provision> findProvisionByDA(Date date) {
        return provisionDAO.findProvisionsByDateAfter(date);
    }
}
