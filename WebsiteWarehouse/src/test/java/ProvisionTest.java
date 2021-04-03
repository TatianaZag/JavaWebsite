import Classes.Provision;
import Services.ProvisionServices;
import org.junit.*;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ProvisionTest {
    private ProvisionServices provisionService;
    private Provision expectedProvision;

    @Before
    public void setUp() {
        provisionService = new ProvisionServices();
        expectedProvision = new Provision(1,
                1,
                3,
                20,
                java.sql.Date.valueOf("2020-12-31"),
                "завершен"
        );
        provisionService.createProvision(expectedProvision);
    }

    @Test
    public void testCreateNewProvision() {
        Provision realProvision = provisionService.readProvisionById(expectedProvision.getId_provision());
        assertEquals(expectedProvision, realProvision);
    }

    @Test
    public void testUpdateProvision() {
        Provision realProvision = provisionService.readProvisionById(expectedProvision.getId_provision());
        assertEquals(expectedProvision, realProvision);

        expectedProvision.setCount_prod(21);
        provisionService.updateProvision(expectedProvision);
        realProvision = provisionService.readProvisionById(expectedProvision.getId_provision());
        assertEquals(expectedProvision, realProvision);
    }

    @Test
    public void testDeleteProvision() {
        Provision realProvision = provisionService.readProvisionById(expectedProvision.getId_provision());
        assertEquals(expectedProvision, realProvision);

        provisionService.deleteProvision(expectedProvision);
        realProvision = provisionService.readProvisionById(expectedProvision.getId_provision());
        assertEquals(expectedProvision, realProvision);
    }

    @Test
    public void testReadProvisionById() {
        Provision realProvision = provisionService.readProvisionById(expectedProvision.getId_provision());
        assertEquals(expectedProvision.getId_product(), realProvision.getId_provision());
    }

    @Test
    public void testReadByIdCustomer() {
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
    }

    @Test
    public void testReadByIdProduct() {
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
    }



    @After
    public void afterTest() {
        provisionService.deleteProvision(expectedProvision);
    }
}
