package Services;

import Classes.Suppliers;
import DAO.Impl.SuppliersDAOImpl;
import DAO.SuppliersDAO;

import java.util.List;

public class SuppliersServices {
    private SuppliersDAO supplierDAO = new SuppliersDAOImpl();
    public void createSupplier(Suppliers supplier) {
        supplierDAO.create(supplier);
    }

    public void updateSupplier(Suppliers supplier) {
        supplierDAO.update(supplier);
    }

    public void deleteSupplier(Suppliers supplier) {
        supplierDAO.delete(supplier);
    }

    public Suppliers readSupplierById(int id) {
        return supplierDAO.readById(id);
    }

    public List<Suppliers> readSuppliersAll() {
        return supplierDAO.readAllSuppliers();
    }
}
