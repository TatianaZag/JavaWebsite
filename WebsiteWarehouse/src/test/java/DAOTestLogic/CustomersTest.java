package DAOTestLogic;

import Classes.Customers;
import Services.CustomersServices;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class CustomersTest {
    private CustomersServices customerService;
    private Customers expectedCustomer;


    @BeforeTest
    public void setUp() {
        customerService = new CustomersServices();
        expectedCustomer = new Customers(6,
                "Маркус",
                1,
                "Marcus@gmail.com",
                "8(703)2346755",
                "г. Нью-Йорк, 3-е Авеню Рог, д. 5");
        customerService.createCustomer(expectedCustomer);
    }

    @Test(alwaysRun = true)
    public void testCreateNewCustomer() {
        Customers realCustomer = customerService.readCustomerById(expectedCustomer.getId_customer());
        assertEquals(expectedCustomer, realCustomer);
    }

    @Test(alwaysRun = true)
    public void testUpdateCustomer() {
        Customers realCustomer = customerService.readCustomerById(expectedCustomer.getId_customer());
        assertEquals(expectedCustomer, realCustomer);

        expectedCustomer.setEmail("Marcus99@gmail.com");
        customerService.updateCustomer(expectedCustomer);
        realCustomer = customerService.readCustomerById(expectedCustomer.getId_customer());
        assertEquals(expectedCustomer, realCustomer);
    }

    @Test(alwaysRun = true)
    public void testDeleteCustomer() {
        Customers realCustomer = customerService.readCustomerById(expectedCustomer.getId_customer());
        assertEquals(expectedCustomer, realCustomer);

        customerService.deleteCustomer(expectedCustomer);
        realCustomer = customerService.readCustomerById(expectedCustomer.getId_customer());
        assertEquals(expectedCustomer, realCustomer);
    }

    @Test(alwaysRun = true)
    public void testReadByIdCustomer() {
        Customers realCustomer = customerService.readCustomerById(expectedCustomer.getId_customer());
        assertEquals(expectedCustomer.getId_customer(), realCustomer.getId_customer());
    }

    @AfterTest
    public void afterTest() {
        customerService.deleteCustomer(expectedCustomer);

    }
}
