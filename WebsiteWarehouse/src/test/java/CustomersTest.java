import Classes.Customers;
import Services.CustomersServices;
import org.junit.*;

import static org.junit.Assert.*;

public class CustomersTest {
    private CustomersServices customerService;
    private Customers expectedCustomer;

    @Before
    public void setUp() {
        customerService = new CustomersServices();
        expectedCustomer = new Customers(1,
                "Маркус",
                1,
                "Marcus@gmail.com",
                "8(703)2346755",
                "г. Нью-Йорк, 3-е Авеню Рог, д. 5");
        customerService.createCustomer(expectedCustomer);
    }

    @Test
    public void testCreateNewCustomer() {
        Customers realCustomer = customerService.readCustomerById(expectedCustomer.getId_customer());
        assertEquals(expectedCustomer, realCustomer);
    }

    @Test
    public void testUpdateCustomer() {
        Customers realCustomer = customerService.readCustomerById(expectedCustomer.getId_customer());
        assertEquals(expectedCustomer, realCustomer);

        expectedCustomer.setEmail("Marcus99@gmail.com");
        customerService.updateCustomer(expectedCustomer);
        realCustomer = customerService.readCustomerById(expectedCustomer.getId_customer());
        assertEquals(expectedCustomer, realCustomer);
    }

    @Test
    public void testDeleteCustomer() {
        Customers realCustomer = customerService.readCustomerById(expectedCustomer.getId_customer());
        assertEquals(expectedCustomer, realCustomer);

        customerService.deleteCustomer(expectedCustomer);
        realCustomer = customerService.readCustomerById(expectedCustomer.getId_customer());
        assertEquals(expectedCustomer, realCustomer);
    }

    @Test
    public void testReadByIdCustomer() {
        Customers realCustomer = customerService.readCustomerById(expectedCustomer.getId_customer());
        assertEquals(expectedCustomer.getId_customer(), realCustomer.getId_customer());
    }

    @After
    public void afterTest() {
        customerService.deleteCustomer(expectedCustomer);

    }
}
