package DAOTestLogic;

import Classes.Provision;
import Services.ProvisionServices;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class ProvisionTest {
    private ProvisionServices provisionService;
    private Provision expectedProvision;

    @Test(alwaysRun = true)
    public void testCreateNewProvision() {
        provisionService = new ProvisionServices();
        expectedProvision = new Provision(6,
                1,
                3,
                20,
                java.sql.Date.valueOf("2020-12-31"),
                "завершен"
        );
        provisionService.createProvision(expectedProvision);

        Provision realProvision = provisionService.readProvisionById(expectedProvision.getId_provision());
        assertEquals(expectedProvision, realProvision);

        provisionService.deleteProvision(expectedProvision);
    }

    @Test(alwaysRun = true)
    public void testUpdateProvision() {
        provisionService = new ProvisionServices();
        expectedProvision = new Provision(6,
                1,
                3,
                20,
                java.sql.Date.valueOf("2020-12-31"),
                "завершен"
        );
        provisionService.createProvision(expectedProvision);

        Provision realProvision = provisionService.readProvisionById(expectedProvision.getId_provision());
        assertEquals(expectedProvision, realProvision);

        expectedProvision.setCount_prod(21);
        provisionService.updateProvision(expectedProvision);
        realProvision = provisionService.readProvisionById(expectedProvision.getId_provision());
        assertEquals(expectedProvision, realProvision);

        provisionService.deleteProvision(expectedProvision);
    }

    @Test(alwaysRun = true)
    public void testDeleteProvision() {
        provisionService = new ProvisionServices();
        expectedProvision = new Provision(6,
                1,
                3,
                20,
                java.sql.Date.valueOf("2020-12-31"),
                "завершен"
        );
        provisionService.createProvision(expectedProvision);

        Provision realProvision = provisionService.readProvisionById(expectedProvision.getId_provision());
        assertEquals(expectedProvision, realProvision);

        provisionService.deleteProvision(expectedProvision);
        realProvision = provisionService.readProvisionById(expectedProvision.getId_provision());
        assertNull(realProvision);
    }

    @Test(alwaysRun = true)
    public void testReadProvisionById() {
        provisionService = new ProvisionServices();
        expectedProvision = new Provision(6,
                1,
                3,
                20,
                java.sql.Date.valueOf("2020-12-31"),
                "завершен"
        );
        provisionService.createProvision(expectedProvision);

        Provision realProvision = provisionService.readProvisionById(expectedProvision.getId_provision());
        assertEquals(expectedProvision.getId_product(), realProvision.getId_provision());

        provisionService.deleteProvision(expectedProvision);
    }

    @Test(alwaysRun = true)
    public void testReadByIdCustomer() {
        provisionService = new ProvisionServices();
        expectedProvision = new Provision(6,
                1,
                3,
                20,
                java.sql.Date.valueOf("2020-12-31"),
                "завершен"
        );
        provisionService.createProvision(expectedProvision);

        ProvisionServices provisionServices = new ProvisionServices();
        Set<Provision> expectedProvisions = Set.of(
                expectedProvision,
                new Provision(2,1,2,3,java.sql.Date.valueOf("2021-01-01"),"завершен"),
                new Provision(3,2,1,13,java.sql.Date.valueOf("2021-01-03"),"завершен"),
                new Provision(4,3,3,6,java.sql.Date.valueOf("2021-04-01"),"в процессе")
        );
        List<Provision> realProvision = provisionServices.readProvisionByIdCustomer(3);
        assertEquals(realProvision.size() - 2, expectedProvisions.size());
        expectedProvisions.clear();

        provisionService.deleteProvision(expectedProvision);
    }

    @Test(alwaysRun = true)
    public void testReadByIdProduct() {
        provisionService = new ProvisionServices();
        expectedProvision = new Provision(6,
                1,
                3,
                20,
                java.sql.Date.valueOf("2020-12-31"),
                "завершен"
        );
        provisionService.createProvision(expectedProvision);

        ProvisionServices provisionServices = new ProvisionServices();
        Set<Provision> expectedProvisions = Set.of(
                expectedProvision,
                new Provision(2,1,2,3,java.sql.Date.valueOf("2021-01-01"),"завершен"),
                new Provision(3,2,1,13,java.sql.Date.valueOf("2021-01-03"),"завершен"),
                new Provision(4,3,3,6,java.sql.Date.valueOf("2021-04-01"),"в процессе")
        );
        List<Provision> realProvision = provisionServices.readProvisionByIdProduct(1);
        assertEquals(realProvision.size() - 2, expectedProvisions.size());
        expectedProvisions.clear();

        provisionService.deleteProvision(expectedProvision);
    }
}
