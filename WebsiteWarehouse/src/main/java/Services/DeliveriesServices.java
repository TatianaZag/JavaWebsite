package Services;

import Classes.Deliveries;
import Classes.Products;
import DAO.DeliveriesDAO;
import DAO.Impl.DeliveriesDAOImpl;

import java.util.List;

public class DeliveriesServices {
    private DeliveriesDAO deliveriesDAO = new DeliveriesDAOImpl();
    public void createDelivery(Deliveries delivery) {
        deliveriesDAO.create(delivery);
    }

    public void updateDelivery(Deliveries delivery) {
        deliveriesDAO.update(delivery);
    }

    public void deleteDelivery(Deliveries delivery) {
        deliveriesDAO.delete(delivery);
    }

    public Deliveries readDeliveryById(int id) {
        return deliveriesDAO.readById(id);
    }

    public List<Deliveries> readDeliveryByIdProduct(int id) {
        return deliveriesDAO.readByIdProduct(id);
    }

    public List<Deliveries> readDeliveryByIdSupplier(int id) {
        return deliveriesDAO.readByIdSupplier(id);
    }

    public List<Deliveries> readDeliveriesAll() {
        return deliveriesDAO.readAllDeliveries();
    }
}
