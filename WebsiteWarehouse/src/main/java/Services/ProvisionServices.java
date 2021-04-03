package Services;

import Classes.Provision;
import DAO.Impl.ProvisionDAOImpl;
import DAO.ProvisionDAO;

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
}