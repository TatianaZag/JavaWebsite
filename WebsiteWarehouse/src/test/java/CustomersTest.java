import Classes.Customers;
import Services.CustomersServices;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class CustomersTest {
    private CustomersServices customerService;
    private Customers expectedCustomer;

    @Test(alwaysRun = true)
    public void testCreateNewCustomer() {
        customerService = new CustomersServices();
        expectedCustomer = new Customers(
                "Маркус",
                1,
                "Marcus@gmail.com",
                "8(703)2346755",
                "г. Нью-Йорк, 3-е Авеню Рог, д. 5");
        customerService.createCustomer(expectedCustomer);

        Customers realCustomer = customerService.readCustomerById(expectedCustomer.getId_customer());
        assertEquals(expectedCustomer, realCustomer);

        customerService.deleteCustomer(expectedCustomer);
    }

    @Test(alwaysRun = true)
    public void testUpdateCustomer() {
        customerService = new CustomersServices();
        expectedCustomer = new Customers(
                "Маркус",
                1,
                "Marcus@gmail.com",
                "8(703)2346755",
                "г. Нью-Йорк, 3-е Авеню Рог, д. 5");
        customerService.createCustomer(expectedCustomer);

        Customers realCustomer = customerService.readCustomerById(expectedCustomer.getId_customer());
        assertEquals(expectedCustomer, realCustomer);

        expectedCustomer.setEmail("Marcus99@gmail.com");
        customerService.updateCustomer(expectedCustomer);
        realCustomer = customerService.readCustomerById(expectedCustomer.getId_customer());
        assertEquals(expectedCustomer, realCustomer);
        customerService.deleteCustomer(expectedCustomer);
    }

    @Test(alwaysRun = true)
    public void testDeleteCustomer() {
        customerService = new CustomersServices();
        expectedCustomer = new Customers(
                "Маркус",
                1,
                "Marcus@gmail.com",
                "8(703)2346755",
                "г. Нью-Йорк, 3-е Авеню Рог, д. 5");
        customerService.createCustomer(expectedCustomer);

        Customers realCustomer = customerService.readCustomerById(expectedCustomer.getId_customer());
        assertEquals(expectedCustomer, realCustomer);

        customerService.deleteCustomer(expectedCustomer);
        realCustomer = customerService.readCustomerById(expectedCustomer.getId_customer());
        assertNull(realCustomer);
    }

    @Test(alwaysRun = true)
    public void testReadByIdCustomer() {
        customerService = new CustomersServices();
        expectedCustomer = new Customers(
                "Маркус",
                1,
                "Marcus@gmail.com",
                "8(703)2346755",
                "г. Нью-Йорк, 3-е Авеню Рог, д. 5");
        customerService.createCustomer(expectedCustomer);

        Customers realCustomer = customerService.readCustomerById(expectedCustomer.getId_customer());
        assertEquals(expectedCustomer.getId_customer(), realCustomer.getId_customer());

        customerService.deleteCustomer(expectedCustomer);
    }

    /*
    @AfterTest
    public void afterTest() {
        customerService.deleteCustomer(expectedCustomer);

    }

     */
}
