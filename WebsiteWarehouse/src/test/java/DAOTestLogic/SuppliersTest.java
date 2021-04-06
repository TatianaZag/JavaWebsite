package DAOTestLogic;

import Classes.Suppliers;
import Services.SuppliersServices;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SuppliersTest {
    private SuppliersServices supplierService;
    private Suppliers expectedSupplier;

    @BeforeTest
    public void setUp() {
        supplierService = new SuppliersServices();
        expectedSupplier = new Suppliers(8,
                "Джейк",
                1,
                "Jk1000@gmail.com",
                "8(777)2340056",
                "г. Лос-Анджелес, ул. Смитта, д. 17, кв. 5");
        supplierService.createSupplier(expectedSupplier);
    }

    @Test(alwaysRun = true)
    public void testCreateNewSupplier() {
        Suppliers realSupplier = supplierService.readSupplierById(expectedSupplier.getId_supplier());
        assertEquals(expectedSupplier, realSupplier);
    }

    @Test(alwaysRun = true)
    public void testUpdateSupplier() {
        Suppliers realSupplier = supplierService.readSupplierById(expectedSupplier.getId_supplier());
        assertEquals(expectedSupplier, realSupplier);

        expectedSupplier.setEmail("Jake@gmail.com");
        supplierService.updateSupplier(expectedSupplier);
        realSupplier = supplierService.readSupplierById(expectedSupplier.getId_supplier());
        assertEquals(expectedSupplier, realSupplier);
    }

    @Test(alwaysRun = true)
    public void testDeleteSupplier() {
        Suppliers realSupplier = supplierService.readSupplierById(expectedSupplier.getId_supplier());
        assertEquals(expectedSupplier, realSupplier);

        supplierService.deleteSupplier(expectedSupplier);
        realSupplier = supplierService.readSupplierById(expectedSupplier.getId_supplier());
        assertEquals(expectedSupplier, realSupplier);
    }

    @Test(alwaysRun = true)
    public void testReadByIdSupplier() {
        Suppliers realSupplier = supplierService.readSupplierById(expectedSupplier.getId_supplier());
        assertEquals(expectedSupplier.getId_supplier(), realSupplier.getId_supplier());
    }

    @AfterTest
    public void afterTest() {
        supplierService.deleteSupplier(expectedSupplier);

    }
}
