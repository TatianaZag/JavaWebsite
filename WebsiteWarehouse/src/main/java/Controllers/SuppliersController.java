package Controllers;

import Classes.Suppliers;
import Services.SuppliersServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SuppliersController {
    SuppliersServices suppliersServices = new SuppliersServices();

    @GetMapping("/suppliers")
    public String suppliers(Model model) {
        List<Suppliers> supl = suppliersServices.readSuppliersAll();
        model.addAttribute("supplier", supl);
        return "Suppliers";
    }

    @GetMapping("/add-new-supplier")
    public String addSupplierPage() {
        return "AddNewSupplier";
    }

    @PostMapping("/added-supplier")
    public String newSupplier(@RequestParam(name = "name_supplier") String name_supplier,
                              @RequestParam(name = "id_type") int id_type,
                              @RequestParam(name = "email") String email,
                              @RequestParam(name = "number_phone") String number_phone,
                              @RequestParam(name = "address") String address,
                              Model model) {
        Suppliers new_supplier;

        new_supplier = new Suppliers(name_supplier, id_type, email, number_phone,
                address);
        suppliersServices.createSupplier(new_supplier);

        return "redirect:/suppliers";
    }

    @GetMapping("/edit-supplier")
    public String supplierEdit(@RequestParam(name = "id_supplier", required = true) int id_supplier, Model model) {
        Suppliers supl = suppliersServices.readSupplierById(id_supplier);
        model.addAttribute("supplier", supl);
        return "EditSupplier";
    }

    @PostMapping("/save-edit-supplier")
    public String editSupplier(@RequestParam(name = "name_supplier") String name_supplier,
                               @RequestParam(name = "id_type") int id_type,
                               @RequestParam(name = "email") String email,
                               @RequestParam(name = "number_phone") String number_phone,
                               @RequestParam(name = "address") String address,
                               @RequestParam(name = "id_supplier") int id_supplier,
                               Model model) {
        Suppliers old_supplier = suppliersServices.readSupplierById(id_supplier);

        old_supplier.setName_supplier(name_supplier);
        old_supplier.setId_type(id_type);
        old_supplier.setEmail(email);
        old_supplier.setNumber_phone(number_phone);
        old_supplier.setAddress(address);

        suppliersServices.updateSupplier(old_supplier);

        return "redirect:/suppliers";
    }

    @GetMapping("/delete-supplier")
    public String deleteSupplier(@RequestParam(name = "id_supplier") int id_supplier,
                                 Model model) {
        Suppliers useless_supplier = suppliersServices.readSupplierById(id_supplier);
        suppliersServices.deleteSupplier(useless_supplier);

        return "redirect:/suppliers";
    }
}
