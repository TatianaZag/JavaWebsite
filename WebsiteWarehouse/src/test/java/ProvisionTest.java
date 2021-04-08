import Classes.Customers;
import Classes.Products;
import Classes.Provision;
import Services.CustomersServices;
import Services.ProductsServices;
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
        CustomersServices customerService = new CustomersServices();
        Customers tmpCustomer = customerService.readCustomerById(3);

        ProductsServices productsServices = new ProductsServices();
        Products tmpProduct = productsServices.readProductById(1);

        provisionService = new ProvisionServices();
        expectedProvision = new Provision(
                tmpProduct,
                tmpCustomer,
                20,
                java.sql.Date.valueOf("2020-12-31"),
                "завершен"
        );
        provisionService.createProvision(expectedProvision);

        Provision realProvision = provisionService.readProvisionById(expectedProvision.getId_provision());
        Assert.assertEquals(expectedProvision, realProvision);

        provisionService.deleteProvision(expectedProvision);
    }

    @Test(alwaysRun = true)
    public void testUpdateProvision() {
        CustomersServices customerService = new CustomersServices();
        Customers tmpCustomer = customerService.readCustomerById(3);

        ProductsServices productsServices = new ProductsServices();
        Products tmpProduct = productsServices.readProductById(1);

        provisionService = new ProvisionServices();
        expectedProvision = new Provision(
                tmpProduct,
                tmpCustomer,
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
        CustomersServices customerService = new CustomersServices();
        Customers tmpCustomer = customerService.readCustomerById(3);

        ProductsServices productsServices = new ProductsServices();
        Products tmpProduct = productsServices.readProductById(1);

        provisionService = new ProvisionServices();
        expectedProvision = new Provision(
                tmpProduct,
                tmpCustomer,
                20,
                java.sql.Date.valueOf("2020-12-31"),
                "завершен"
        );
        provisionService.createProvision(expectedProvision);

        Provision realProvision = provisionService.readProvisionById(expectedProvision.getId_provision());
        Assert.assertEquals(expectedProvision, realProvision);

        provisionService.deleteProvision(expectedProvision);
        realProvision = provisionService.readProvisionById(expectedProvision.getId_provision());
        assertNull(realProvision);
    }

    @Test(alwaysRun = true)
    public void testReadProvisionById() {
        CustomersServices customerService = new CustomersServices();
        Customers tmpCustomer = customerService.readCustomerById(3);

        ProductsServices productsServices = new ProductsServices();
        Products tmpProduct = productsServices.readProductById(1);

        provisionService = new ProvisionServices();
        expectedProvision = new Provision(
                tmpProduct,
                tmpCustomer,
                20,
                java.sql.Date.valueOf("2020-12-31"),
                "завершен"
        );
        provisionService.createProvision(expectedProvision);

        Provision realProvision = provisionService.readProvisionById(expectedProvision.getId_provision());
        assertEquals(expectedProvision.getId_provision(), realProvision.getId_provision());

        provisionService.deleteProvision(expectedProvision);
    }

    @Test(alwaysRun = true)
    public void testReadByIdCustomer() {
        CustomersServices customerService = new CustomersServices();
        Customers tmpCustomer = customerService.readCustomerById(3);

        ProductsServices productsServices = new ProductsServices();
        Products tmpProduct = productsServices.readProductById(1);

        provisionService = new ProvisionServices();
        expectedProvision = new Provision(
                tmpProduct,
                tmpCustomer,
                20,
                java.sql.Date.valueOf("2020-12-31"),
                "завершен"
        );
        provisionService.createProvision(expectedProvision);

        CustomersServices customerService1 = new CustomersServices();
        Customers tmpCustomer1 = customerService1.readCustomerById(2);
        CustomersServices customerService2 = new CustomersServices();
        Customers tmpCustomer2 = customerService2.readCustomerById(4);
        CustomersServices customerService3 = new CustomersServices();
        Customers tmpCustomer3 = customerService3.readCustomerById(3);

        ProductsServices productService1 = new ProductsServices();
        Products tmpProduct1 = productService1.readProductById(2);
        ProductsServices productService2 = new ProductsServices();
        Products tmpProduct2 = productService2.readProductById(5);

        ProvisionServices provisionServices = new ProvisionServices();
        Set<Provision> expectedProvisions = Set.of(
                expectedProvision,
                new Provision(tmpProduct2,tmpCustomer1,3,java.sql.Date.valueOf("2021-01-01"),"завершен"),
                new Provision(tmpProduct1,tmpCustomer3,13,java.sql.Date.valueOf("2021-01-03"),"завершен"),
                new Provision(tmpProduct2,tmpCustomer2,6,java.sql.Date.valueOf("2021-04-01"),"в процессе")
        );
        List<Provision> realProvision = provisionServices.readProvisionByIdCustomer(3);
        assertEquals(realProvision.size(), expectedProvisions.size() - 2);

        provisionService.deleteProvision(expectedProvision);
    }

    @Test(alwaysRun = true)
    public void testReadByIdProduct() {
        CustomersServices customerService = new CustomersServices();
        Customers tmpCustomer = customerService.readCustomerById(3);

        ProductsServices productsServices = new ProductsServices();
        Products tmpProduct = productsServices.readProductById(1);

        provisionService = new ProvisionServices();
        expectedProvision = new Provision(
                tmpProduct,
                tmpCustomer,
                20,
                java.sql.Date.valueOf("2020-12-31"),
                "завершен"
        );
        provisionService.createProvision(expectedProvision);

        CustomersServices customerService1 = new CustomersServices();
        Customers tmpCustomer1 = customerService1.readCustomerById(2);
        CustomersServices customerService2 = new CustomersServices();
        Customers tmpCustomer2 = customerService2.readCustomerById(4);
        CustomersServices customerService3 = new CustomersServices();
        Customers tmpCustomer3 = customerService3.readCustomerById(3);

        ProductsServices productService1 = new ProductsServices();
        Products tmpProduct1 = productService1.readProductById(2);
        ProductsServices productService2 = new ProductsServices();
        Products tmpProduct2 = productService2.readProductById(5);

        ProvisionServices provisionServices = new ProvisionServices();
        Set<Provision> expectedProvisions = Set.of(
                expectedProvision,
                new Provision(tmpProduct2,tmpCustomer1,3,java.sql.Date.valueOf("2021-01-01"),"завершен"),
                new Provision(tmpProduct1,tmpCustomer3,13,java.sql.Date.valueOf("2021-01-03"),"завершен"),
                new Provision(tmpProduct2,tmpCustomer2,6,java.sql.Date.valueOf("2021-04-01"),"в процессе")
        );
        List<Provision> realProvision = provisionServices.readProvisionByIdProduct(1);
        assertEquals(realProvision.size(), expectedProvisions.size() - 2);

        provisionService.deleteProvision(expectedProvision);
    }
}
