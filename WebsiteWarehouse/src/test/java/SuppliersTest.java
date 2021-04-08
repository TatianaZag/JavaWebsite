import Classes.Suppliers;
import Services.SuppliersServices;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SuppliersTest {
    private SuppliersServices supplierService;
    private Suppliers expectedSupplier;

    @Test(alwaysRun = true)
    public void testCreateNewSupplier() {
        supplierService = new SuppliersServices();
        expectedSupplier = new Suppliers(
                "Джейк",
                1,
                "Jk1000@gmail.com",
                "8(777)2340056",
                "г. Лос-Анджелес, ул. Смитта, д. 17, кв. 5");
        supplierService.createSupplier(expectedSupplier);

        Suppliers realSupplier = supplierService.readSupplierById(expectedSupplier.getId_supplier());
        assertEquals(expectedSupplier, realSupplier);

        supplierService.deleteSupplier(expectedSupplier);
    }

    @Test(alwaysRun = true)
    public void testUpdateSupplier() {
        supplierService = new SuppliersServices();
        expectedSupplier = new Suppliers(
                "Джейк",
                1,
                "Jk1000@gmail.com",
                "8(777)2340056",
                "г. Лос-Анджелес, ул. Смитта, д. 17, кв. 5");
        supplierService.createSupplier(expectedSupplier);

        Suppliers realSupplier = supplierService.readSupplierById(expectedSupplier.getId_supplier());
        assertEquals(expectedSupplier, realSupplier);

        expectedSupplier.setEmail("Jake@gmail.com");
        supplierService.updateSupplier(expectedSupplier);
        realSupplier = supplierService.readSupplierById(expectedSupplier.getId_supplier());
        assertEquals(expectedSupplier, realSupplier);

        supplierService.deleteSupplier(expectedSupplier);
    }

    @Test(alwaysRun = true)
    public void testDeleteSupplier() {
        supplierService = new SuppliersServices();
        expectedSupplier = new Suppliers(
                "Джейк",
                1,
                "Jk1000@gmail.com",
                "8(777)2340056",
                "г. Лос-Анджелес, ул. Смитта, д. 17, кв. 5");
        supplierService.createSupplier(expectedSupplier);

        Suppliers realSupplier = supplierService.readSupplierById(expectedSupplier.getId_supplier());
        assertEquals(expectedSupplier, realSupplier);

        supplierService.deleteSupplier(expectedSupplier);
        realSupplier = supplierService.readSupplierById(expectedSupplier.getId_supplier());
        assertNull(realSupplier);
    }

    @Test(alwaysRun = true)
    public void testReadByIdSupplier() {
        supplierService = new SuppliersServices();
        expectedSupplier = new Suppliers(
                "Джейк",
                1,
                "Jk1000@gmail.com",
                "8(777)2340056",
                "г. Лос-Анджелес, ул. Смитта, д. 17, кв. 5");
        supplierService.createSupplier(expectedSupplier);

        Suppliers realSupplier = supplierService.readSupplierById(expectedSupplier.getId_supplier());
        assertEquals(expectedSupplier.getId_supplier(), realSupplier.getId_supplier());

        supplierService.deleteSupplier(expectedSupplier);
    }
}
