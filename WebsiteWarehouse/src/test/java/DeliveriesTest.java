import Classes.Deliveries;
import Classes.Suppliers;
import Classes.Products;
import Services.DeliveriesServices;
import Services.ProductsServices;
import Services.SuppliersServices;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.*;

public class DeliveriesTest {
    private DeliveriesServices deliveryService;
    private Deliveries expectedDelivery;

    @Test(alwaysRun = true)
    public void testCreateNewDelivery() {
        SuppliersServices supplierService = new SuppliersServices();
        Suppliers tmpSupplier = supplierService.readSupplierById(3);

        ProductsServices productsServices = new ProductsServices();
        Products tmpProduct = productsServices.readProductById(1);

        deliveryService = new DeliveriesServices();
        expectedDelivery = new Deliveries(
                tmpProduct,
                tmpSupplier,
                20,
                java.sql.Date.valueOf("2020-12-31"),
                50
        );
        deliveryService.createDelivery(expectedDelivery);

        Deliveries realDelivery = deliveryService.readDeliveryById(expectedDelivery.getId_deliveries());
        Assert.assertEquals(expectedDelivery, realDelivery);

        deliveryService.deleteDelivery(expectedDelivery);
    }
    
    @Test(alwaysRun = true)
    public void testUpdateDelivery() {
        SuppliersServices supplierService = new SuppliersServices();
        Suppliers tmpSupplier = supplierService.readSupplierById(3);

        ProductsServices productsServices = new ProductsServices();
        Products tmpProduct = productsServices.readProductById(1);

        deliveryService = new DeliveriesServices();
        expectedDelivery = new Deliveries(
                tmpProduct,
                tmpSupplier,
                20,
                java.sql.Date.valueOf("2020-12-31"),
                50
        );
        deliveryService.createDelivery(expectedDelivery);

        Deliveries realDelivery = deliveryService.readDeliveryById(expectedDelivery.getId_deliveries());
        assertEquals(expectedDelivery, realDelivery);

        expectedDelivery.setCount_prod(21);
        deliveryService.updateDelivery(expectedDelivery);
        realDelivery = deliveryService.readDeliveryById(expectedDelivery.getId_deliveries());
        assertEquals(expectedDelivery, realDelivery);

        deliveryService.deleteDelivery(expectedDelivery);
    }

    @Test(alwaysRun = true)
    public void testDeleteDelivery() {
        SuppliersServices supplierService = new SuppliersServices();
        Suppliers tmpSupplier = supplierService.readSupplierById(3);

        ProductsServices productsServices = new ProductsServices();
        Products tmpProduct = productsServices.readProductById(1);

        deliveryService = new DeliveriesServices();
        expectedDelivery = new Deliveries(
                tmpProduct,
                tmpSupplier,
                20,
                java.sql.Date.valueOf("2020-12-31"),
                50
        );
        deliveryService.createDelivery(expectedDelivery);

        Deliveries realDelivery = deliveryService.readDeliveryById(expectedDelivery.getId_deliveries());
        assertEquals(expectedDelivery, realDelivery);

        deliveryService.deleteDelivery(expectedDelivery);
        realDelivery = deliveryService.readDeliveryById(expectedDelivery.getId_deliveries());
        Assert.assertNull(realDelivery);
    }

    @Test(alwaysRun = true)
    public void testReadDeliveryById() {
        SuppliersServices supplierService = new SuppliersServices();
        Suppliers tmpSupplier = supplierService.readSupplierById(3);

        ProductsServices productsServices = new ProductsServices();
        Products tmpProduct = productsServices.readProductById(1);

        deliveryService = new DeliveriesServices();
        expectedDelivery = new Deliveries(
                tmpProduct,
                tmpSupplier,
                20,
                java.sql.Date.valueOf("2020-12-31"),
                50
        );
        deliveryService.createDelivery(expectedDelivery);

        Deliveries realDelivery = deliveryService.readDeliveryById(expectedDelivery.getId_deliveries());
        assertEquals(expectedDelivery.getId_deliveries(), realDelivery.getId_deliveries());

        deliveryService.deleteDelivery(expectedDelivery);
    }

    @Test(alwaysRun = true)
    public void testReadByIdSupplier() {
        SuppliersServices supplierService = new SuppliersServices();
        Suppliers tmpSupplier = supplierService.readSupplierById(2);

        ProductsServices productsServices = new ProductsServices();
        Products tmpProduct1 = productsServices.readProductById(2);
        Products tmpProduct2 = productsServices.readProductById(5);
        Products tmpProduct3 = productsServices.readProductById(1);

        DeliveriesServices deliveriesServices = new DeliveriesServices();
        ArrayList<Deliveries> expectedDeliveries = new ArrayList<Deliveries>();
        expectedDeliveries.add(new Deliveries(tmpProduct1,tmpSupplier,80,java.sql.Date.valueOf("2021-01-10"),60));
        expectedDeliveries.add(new Deliveries(tmpProduct1,tmpSupplier,3,java.sql.Date.valueOf("2021-01-01"),35));
        expectedDeliveries.add(new Deliveries(tmpProduct3,tmpSupplier,13,java.sql.Date.valueOf("2021-01-03"),90));
        expectedDeliveries.add(new Deliveries(tmpProduct2,tmpSupplier,6,java.sql.Date.valueOf("2021-04-01"),21));
        deliveriesServices.createDelivery(expectedDeliveries.get(0));
        deliveriesServices.createDelivery(expectedDeliveries.get(1));
        deliveriesServices.createDelivery(expectedDeliveries.get(2));
        deliveriesServices.createDelivery(expectedDeliveries.get(3));

        List<Deliveries> realDelivery = deliveriesServices.readDeliveryByIdSupplier(2);
        assertEquals(realDelivery, expectedDeliveries);
        assertTrue(expectedDeliveries.contains(realDelivery.get(0)));
        assertTrue(expectedDeliveries.contains(realDelivery.get(1)));
        assertTrue(expectedDeliveries.contains(realDelivery.get(2)));
        assertTrue(expectedDeliveries.contains(realDelivery.get(3)));

        deliveriesServices.deleteDelivery(expectedDeliveries.get(0));
        deliveriesServices.deleteDelivery(expectedDeliveries.get(1));
        deliveriesServices.deleteDelivery(expectedDeliveries.get(2));
        deliveriesServices.deleteDelivery(expectedDeliveries.get(3));
    }

    @Test(alwaysRun = true)
    public void testReadByIdProduct1() {
        SuppliersServices supplierService = new SuppliersServices();

        ProductsServices productsServices = new ProductsServices();
        Products tmpProduct = productsServices.readProductById(2);

        Suppliers tmpSupplier1 = supplierService.readSupplierById(2);
        Suppliers tmpSupplier2 = supplierService.readSupplierById(5);
        Suppliers tmpSupplier3 = supplierService.readSupplierById(4);

        DeliveriesServices deliveriesServices = new DeliveriesServices();
        ArrayList<Deliveries> expectedDeliveries = new ArrayList<Deliveries>();
        expectedDeliveries.add(new Deliveries(tmpProduct,tmpSupplier1,80,java.sql.Date.valueOf("2021-01-10"),60));
        expectedDeliveries.add(new Deliveries(tmpProduct,tmpSupplier1,3,java.sql.Date.valueOf("2021-01-01"),35));
        expectedDeliveries.add(new Deliveries(tmpProduct,tmpSupplier2,13,java.sql.Date.valueOf("2021-01-03"),90));
        expectedDeliveries.add(new Deliveries(tmpProduct,tmpSupplier3,6,java.sql.Date.valueOf("2021-04-01"),21));
        deliveriesServices.createDelivery(expectedDeliveries.get(0));
        deliveriesServices.createDelivery(expectedDeliveries.get(1));
        deliveriesServices.createDelivery(expectedDeliveries.get(2));
        deliveriesServices.createDelivery(expectedDeliveries.get(3));

        List<Deliveries> realDelivery = deliveriesServices.readDeliveryByIdProduct(2);
        assertEquals(realDelivery, expectedDeliveries);
        assertTrue(expectedDeliveries.contains(realDelivery.get(0)));
        assertTrue(expectedDeliveries.contains(realDelivery.get(1)));
        assertTrue(expectedDeliveries.contains(realDelivery.get(2)));
        assertTrue(expectedDeliveries.contains(realDelivery.get(3)));

        deliveriesServices.deleteDelivery(expectedDeliveries.get(0));
        deliveriesServices.deleteDelivery(expectedDeliveries.get(1));
        deliveriesServices.deleteDelivery(expectedDeliveries.get(2));
        deliveriesServices.deleteDelivery(expectedDeliveries.get(3));
    }
}
