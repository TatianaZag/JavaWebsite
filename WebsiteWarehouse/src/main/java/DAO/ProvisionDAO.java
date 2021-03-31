package DAO;
import Classes.Provision;

import java.util.List;

public interface ProvisionDAO {
    void create(Provision provision);
    void update(Provision provision);
    void delete(Provision provision);
    Provision readById(int id);
    List<Provision> readByIdProduct(int id);
    List<Provision> readByIdCustomer(int id);
}
