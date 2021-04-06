package DAOTestLogic;

import Classes.Deliveries;
import Services.DeliveriesServices;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.*;

public class DeliveriesTest {
    private DeliveriesServices deliveryService;
    private Deliveries expectedDelivery;

    @BeforeTest
    public void setUp() {
        deliveryService = new DeliveriesServices();
        expectedDelivery = new Deliveries(6,
                1,
                3,
                20,
                java.sql.Date.valueOf("2020-12-31"),
                50
        );
        deliveryService.createDelivery(expectedDelivery);
    }

    @Test(alwaysRun = true)
    public void testCreateNewDelivery() {
        Deliveries realDelivery = deliveryService.readDeliveryById(expectedDelivery.getId_deliveries());
        assertEquals(expectedDelivery, realDelivery);
    }

    @Test(alwaysRun = true)
    public void testUpdateDelivery() {
        Deliveries realDelivery = deliveryService.readDeliveryById(expectedDelivery.getId_deliveries());
        assertEquals(expectedDelivery, realDelivery);

        expectedDelivery.setCount_prod(21);
        deliveryService.updateDelivery(expectedDelivery);
        realDelivery = deliveryService.readDeliveryById(expectedDelivery.getId_deliveries());
        assertEquals(expectedDelivery, realDelivery);
    }

    @Test(alwaysRun = true)
    public void testDeleteDelivery() {
        Deliveries realDelivery = deliveryService.readDeliveryById(expectedDelivery.getId_deliveries());
        assertEquals(expectedDelivery, realDelivery);

        deliveryService.deleteDelivery(expectedDelivery);
        realDelivery = deliveryService.readDeliveryById(expectedDelivery.getId_deliveries());
        assertEquals(expectedDelivery, realDelivery);
    }

    @Test(alwaysRun = true)
    public void testReadDeliveryById() {
        Deliveries realDelivery = deliveryService.readDeliveryById(expectedDelivery.getId_deliveries());
        assertEquals(expectedDelivery.getId_deliveries(), realDelivery.getId_deliveries());
    }

    @Test(alwaysRun = true)
    public void testReadByIdSupplier() {
        DeliveriesServices deliveriesServices = new DeliveriesServices();
        Set<Deliveries> expectedDeliveries = Set.of(
                expectedDelivery,
                new Deliveries(2,1,2,3,java.sql.Date.valueOf("2021-01-01"),35),
                new Deliveries(3,2,1,13,java.sql.Date.valueOf("2021-01-03"),90),
                new Deliveries(4,3,3,6,java.sql.Date.valueOf("2021-04-01"),21)
        );
        List<Deliveries> realDelivery = deliveriesServices.readDeliveryByIdSupplier(2);
        assertEquals(realDelivery.size() - 3, expectedDeliveries.size());
        expectedDeliveries.clear();
    }

    @Test(alwaysRun = true)
    public void testReadByIdProduct1() {
        DeliveriesServices deliveriesServices = new DeliveriesServices();
        Set<Deliveries> expectedDeliveries = Set.of(
                expectedDelivery,
                new Deliveries(2,1,2,3,java.sql.Date.valueOf("2021-01-01"),35),
                new Deliveries(3,2,1,13,java.sql.Date.valueOf("2021-01-03"),90),
                new Deliveries(4,3,3,6,java.sql.Date.valueOf("2021-04-01"),21)
        );
        List<Deliveries> realDelivery = deliveriesServices.readDeliveryByIdProduct(1);
        assertEquals(realDelivery.size() - 2, expectedDeliveries.size());
        expectedDeliveries.clear();
    }

    @AfterTest
    public void afterTest() {
        deliveryService.deleteDelivery(expectedDelivery);
    }
}
