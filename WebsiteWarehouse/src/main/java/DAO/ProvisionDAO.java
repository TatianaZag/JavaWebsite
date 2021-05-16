package DAO;
import Classes.Provision;

import java.sql.Date;
import java.util.List;

public interface ProvisionDAO {
    void create(Provision provision);
    void update(Provision provision);
    void delete(Provision provision);
    Provision readById(int id);
    List<Provision> readByIdProduct(int id);
    List<Provision> readByIdCustomer(int id);
    List<Provision> readAllProvision();
    List<Provision> findProvisionsByDateAfter(Date date);
    List<Provision> findProvisionsByDateBefore(Date date);
}
