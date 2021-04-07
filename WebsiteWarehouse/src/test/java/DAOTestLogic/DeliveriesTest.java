package DAOTestLogic;

import Classes.Deliveries;
import Classes.Suppliers;
import Classes.Products;
import Services.DeliveriesServices;
import Services.ProductsServices;
import Services.SuppliersServices;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        SuppliersServices supplierService1 = new SuppliersServices();
        Suppliers tmpSupplier1 = supplierService1.readSupplierById(2);
        SuppliersServices supplierService2 = new SuppliersServices();
        Suppliers tmpSupplier2 = supplierService2.readSupplierById(5);
        SuppliersServices supplierService3 = new SuppliersServices();
        Suppliers tmpSupplier3 = supplierService3.readSupplierById(4);

        ProductsServices productService1 = new ProductsServices();
        Products tmpProduct1 = productService1.readProductById(2);
        ProductsServices productService2 = new ProductsServices();
        Products tmpProduct2 = productService2.readProductById(5);
        ProductsServices productService3 = new ProductsServices();
        Products tmpProduct3 = productService3.readProductById(1);

        DeliveriesServices deliveriesServices = new DeliveriesServices();
        Set<Deliveries> expectedDeliveries = Set.of(
                expectedDelivery,
                new Deliveries(tmpProduct1,tmpSupplier2,3,java.sql.Date.valueOf("2021-01-01"),35),
                new Deliveries(tmpProduct3,tmpSupplier1,13,java.sql.Date.valueOf("2021-01-03"),90),
                new Deliveries(tmpProduct2,tmpSupplier3,6,java.sql.Date.valueOf("2021-04-01"),21)
        );
        List<Deliveries> realDelivery = deliveriesServices.readDeliveryByIdSupplier(2);
        assertEquals(realDelivery.size() - 3, expectedDeliveries.size());
        expectedDeliveries.clear();

        deliveryService.deleteDelivery(expectedDelivery);
    }

    @Test(alwaysRun = true)
    public void testReadByIdProduct1() {
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

        SuppliersServices supplierService1 = new SuppliersServices();
        Suppliers tmpSupplier1 = supplierService1.readSupplierById(2);
        SuppliersServices supplierService2 = new SuppliersServices();
        Suppliers tmpSupplier2 = supplierService2.readSupplierById(5);
        SuppliersServices supplierService3 = new SuppliersServices();
        Suppliers tmpSupplier3 = supplierService3.readSupplierById(4);

        ProductsServices productService1 = new ProductsServices();
        Products tmpProduct1 = productService1.readProductById(2);
        ProductsServices productService2 = new ProductsServices();
        Products tmpProduct2 = productService2.readProductById(5);
        ProductsServices productService3 = new ProductsServices();
        Products tmpProduct3 = productService3.readProductById(1);

        DeliveriesServices deliveriesServices = new DeliveriesServices();
        Set<Deliveries> expectedDeliveries = Set.of(
                expectedDelivery,
                new Deliveries(tmpProduct1,tmpSupplier2,3,java.sql.Date.valueOf("2021-01-01"),35),
                new Deliveries(tmpProduct3,tmpSupplier1,13,java.sql.Date.valueOf("2021-01-03"),90),
                new Deliveries(tmpProduct2,tmpSupplier3,6,java.sql.Date.valueOf("2021-04-01"),21)
        );
        List<Deliveries> realDelivery = deliveriesServices.readDeliveryByIdProduct(1);
        assertEquals(realDelivery.size() - 2, expectedDeliveries.size());
        expectedDeliveries.clear();

        deliveryService.deleteDelivery(expectedDelivery);
    }
}
