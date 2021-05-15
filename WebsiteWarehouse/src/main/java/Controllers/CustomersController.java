package Controllers;

import Classes.Customers;
import Services.CustomersServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class CustomersController {
    CustomersServices customersServices = new CustomersServices();

    @GetMapping("/customers")
    public String customers(Model model) {
        List<Customers> cust = customersServices.readCustomersAll();
        model.addAttribute("customers", cust);
        return "Customers";
    }

    @GetMapping("/add-new-customer")
    public String addCustomerPage() {
        return "AddNewCustomer";
    }

    @PostMapping("/added-cust")
    public String newCustomer(@RequestParam(name = "name_customer") String name_customer,
                              @RequestParam(name = "id_type") int id_type,
                              @RequestParam(name = "email") String email,
                              @RequestParam(name = "number_phone") String number_phone,
                              @RequestParam(name = "address") String address,
                              Model model) {
        Customers new_customer;

        new_customer = new Customers(name_customer, id_type, email, number_phone,
                address);
        customersServices.createCustomer(new_customer);

        return "redirect:/customers";
    }

    @GetMapping("/edit-customer")
    public String customerEdit(@RequestParam(name = "id_customer", required = true) int id_customer, Model model) {
        Customers cust = customersServices.readCustomerById(id_customer);
        model.addAttribute("customer", cust);
        return "EditCustomer";
    }

    @PostMapping("/save-edit-customer")
    public String editCustomer(@RequestParam(name = "name_customer") String name_customer,
                               @RequestParam(name = "id_type") int id_type,
                               @RequestParam(name = "email") String email,
                               @RequestParam(name = "number_phone") String number_phone,
                               @RequestParam(name = "address") String address,
                               @RequestParam(name = "id_customer") int id_customer,
                               Model model) {
        Customers old_customer = customersServices.readCustomerById(id_customer);

        old_customer.setName_customer(name_customer);
        old_customer.setId_type(id_type);
        old_customer.setEmail(email);
        old_customer.setNumber_phone(number_phone);
        old_customer.setAddress(address);

        customersServices.updateCustomer(old_customer);

        return "redirect:/customers";
    }

    @GetMapping("/delete-customer")
    public String deleteDelivery(@RequestParam(name = "id_customer") int id_customer,
                                 Model model) {
        Customers useless_customer = customersServices.readCustomerById(id_customer);
        customersServices.deleteCustomer(useless_customer);

        return "redirect:/customers";
    }
}
