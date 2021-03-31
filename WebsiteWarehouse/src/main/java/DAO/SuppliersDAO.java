package DAO;
import Classes.Suppliers;

public interface SuppliersDAO {
    void create(Suppliers suppliers);
    void update(Suppliers suppliers);
    void delete(Suppliers suppliers);
    Suppliers readById(int id);
}
