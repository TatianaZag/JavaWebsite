import Classes.Customers;
import Classes.Suppliers;
import Services.CustomersServices;
import Services.SuppliersServices;
import org.junit.*;

import static org.junit.Assert.*;

public class SuppliersTest {
    private SuppliersServices supplierService;
    private Suppliers expectedSupplier;

    @Before
    public void setUp() {
        supplierService = new SuppliersServices();
        expectedSupplier = new Suppliers(1,
                "Джейк",
                1,
                "Jk1000@gmail.com",
                "8(777)2340056",
                "г. Лос-Анджелес, ул. Смитта, д. 17, кв. 5");
        supplierService.createSupplier(expectedSupplier);
    }

    @Test
    public void testCreateNewSupplier() {
        Suppliers realSupplier = supplierService.readSupplierById(expectedSupplier.getId_supplier());
        assertEquals(expectedSupplier, realSupplier);
    }

    @Test
    public void testUpdateSupplier() {
        Suppliers realSupplier = supplierService.readSupplierById(expectedSupplier.getId_supplier());
        assertEquals(expectedSupplier, realSupplier);

        expectedSupplier.setEmail("Jake@gmail.com");
        supplierService.updateSupplier(expectedSupplier);
        realSupplier = supplierService.readSupplierById(expectedSupplier.getId_supplier());
        assertEquals(expectedSupplier, realSupplier);
    }

    @Test
    public void testDeleteSupplier() {
        Suppliers realSupplier = supplierService.readSupplierById(expectedSupplier.getId_supplier());
        assertEquals(expectedSupplier, realSupplier);

        supplierService.deleteSupplier(expectedSupplier);
        realSupplier = supplierService.readSupplierById(expectedSupplier.getId_supplier());
        assertEquals(expectedSupplier, realSupplier);
    }

    @Test
    public void testReadByIdSupplier() {
        Suppliers realSupplier = supplierService.readSupplierById(expectedSupplier.getId_supplier());
        assertEquals(expectedSupplier.getId_supplier(), realSupplier.getId_supplier());
    }

    @After
    public void afterTest() {
        supplierService.deleteSupplier(expectedSupplier);

    }
}
