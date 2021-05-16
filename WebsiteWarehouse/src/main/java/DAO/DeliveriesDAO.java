package DAO;
import Classes.Deliveries;
import Classes.Products;

import java.sql.Date;
import java.util.List;

public interface DeliveriesDAO {
    void create(Deliveries deliveries);
    void update(Deliveries deliveries);
    void delete(Deliveries deliveries);
    Deliveries readById(int id);
    List<Deliveries> readByIdProduct(int id);
    List<Deliveries> readByIdSupplier(int id);
    List<Deliveries> readAllDeliveries();
    List<Deliveries> findDeliveriesByDateAfter(Date date);
    List<Deliveries> findDeliveriesByDateBefore(Date date);
}
