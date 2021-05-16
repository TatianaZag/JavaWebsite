package Controllers;

import Classes.*;
import Services.CustomersServices;
import Services.ProvisionServices;
import Services.ProductsServices;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class ProvisionsController {
    ProvisionServices provisionServices = new ProvisionServices();
    ProductsServices productsServices = new ProductsServices();
    CustomersServices customersServices = new CustomersServices();

    @GetMapping("/provision")
    public String provisions(Model model) {
        List<Provision> prov = provisionServices.readProvisionAll();
        model.addAttribute("provisions", prov);
        return "Provisions";
    }

    @GetMapping("/add-new-provision")
    public String addProvisionPage() {
        return "AddNewProvision";
    }

    @PostMapping("/added-prov")
    public String newProvision(@RequestParam(name = "product") int iproduct,
                             @RequestParam(name = "customer") int icustomer,
                             @RequestParam(name = "count_prod") int count_prod,
                             @RequestParam(name = "date_prov") Date date_prov,
                             @RequestParam(name = "status") String status,
                             Model model) {
        Provision new_provision;

        Products product = productsServices.readProductById(iproduct);
        Customers customer = customersServices.readCustomerById(icustomer);

        new_provision = new Provision(product, customer, count_prod, date_prov,
                status);
        provisionServices.createProvision(new_provision);

        return "redirect:/provision";
    }

    @GetMapping("/edit-provision")
    public String provisionEdit(@RequestParam(name = "id_provision", required = true) int id_provision, Model model) {
        Provision prov = provisionServices.readProvisionById(id_provision);
        model.addAttribute("provision", prov);
        return "EditProvision";
    }

    @PostMapping("/save-edit-provision")
    public String editProvision(@RequestParam(name = "id_product") int iproduct,
                               @RequestParam(name = "id_customer") int icustomer,
                               @RequestParam(name = "count_prod") int count_prod,
                               @RequestParam(name = "date_prov") Date date_prov,
                               @RequestParam(name = "status") String status,
                               @RequestParam(name = "id_provision") int id_provision,
                               Model model) {
        Provision old_provision = provisionServices.readProvisionById(id_provision);

        Products product = productsServices.readProductById(iproduct);
        Customers customer = customersServices.readCustomerById(icustomer);

        old_provision.setId_product(product);
        old_provision.setId_customer(customer);
        old_provision.setCount_prod(count_prod);
        old_provision.setDate_prov(date_prov);
        old_provision.setStatus(status);

        provisionServices.updateProvision(old_provision);

        return "redirect:/provision";
    }

    @GetMapping("/delete-provision")
    public String deleteProvision(@RequestParam(name = "id_provision") int id_provision,
                                 Model model) {
        Provision useless_provision = provisionServices.readProvisionById(id_provision);

        provisionServices.deleteProvision(useless_provision);

        return "redirect:/provision";
    }

    @GetMapping("/filter-provision")
    public String filtration(Model model) {
        return "FiltrationProvisions";
    }

    @PostMapping("/filtrated-prov")
    public String filterProvision(@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(name = "date_after", required = false) java.util.Date date_after,
                                @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(name = "date_before", required = false) java.util.Date date_before,
                                Model model) {
        List<Provision> prod_after = provisionServices.readProvisionAll();
        List<Provision> prod_before = provisionServices.readProvisionAll();

        if(date_after != null) {
            Date sql_date_after = new Date(date_after.getTime());
            prod_after = provisionServices.findProvisionByDA(sql_date_after);
        }
        if(date_before != null) {
            Date sql_date_before = new Date(date_before.getTime());
            prod_before = provisionServices.findProvisionByDB(sql_date_before);
        }

        prod_after.retainAll(prod_before);

        model.addAttribute("filter_provisions", prod_after);

        return "UpdateProvisions";
    }
}
