package Controllers;

import Classes.Deliveries;
import Classes.Products;
import Classes.Suppliers;
import Services.DeliveriesServices;
import Services.ProductsServices;
import Services.SuppliersServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class DeliveriesController {
    DeliveriesServices deliveriesServices = new DeliveriesServices();
    ProductsServices productsServices = new ProductsServices();
    SuppliersServices suppliersServices = new SuppliersServices();

    @GetMapping("/deliveries")
    public String deliveries(Model model) {
        List<Deliveries> deliv = deliveriesServices.readDeliveriesAll();
        model.addAttribute("deliveries", deliv);
        return "Deliveries";
    }

    @GetMapping("/add-new-delivery")
    public String addDeliveryPage() {
        return "AddNewDelivery";
    }

    @PostMapping("/added-del")
    public String newDelivery(@RequestParam(name = "product") int iproduct,
                             @RequestParam(name = "supplier") int isupplier,
                             @RequestParam(name = "count_prod") int count_prod,
                             @RequestParam(name = "date_deliver") Date date_deliver,
                             @RequestParam(name = "storage_time") int storage_time,
                             Model model) {
        Deliveries new_delivery;

        Products product = productsServices.readProductById(iproduct);
        Suppliers supplier = suppliersServices.readSupplierById(isupplier);

        new_delivery = new Deliveries(product, supplier, count_prod, date_deliver,
                storage_time);
        deliveriesServices.createDelivery(new_delivery);

        return "redirect:/deliveries";
    }

    @GetMapping("/edit-delivery")
    public String deliveryEdit(@RequestParam(name = "id_delivery", required = true) int id_delivery, Model model) {
        Deliveries deliv = deliveriesServices.readDeliveryById(id_delivery);
        model.addAttribute("deliveries", deliv);
        return "EditDelivery";
    }

    @PostMapping("/save-edit-delivery")
    public String editDelivery(@RequestParam(name = "id_product") int iproduct,
                               @RequestParam(name = "id_supplier") int isupplier,
                               @RequestParam(name = "count_prod") int count_prod,
                               @RequestParam(name = "date_deliver") Date date_deliver,
                               @RequestParam(name = "storage_time") int storage_time,
                              @RequestParam(name = "id_delivery") int id_delivery,
                              Model model) {
        Deliveries old_delivery = deliveriesServices.readDeliveryById(id_delivery);

        Products product = productsServices.readProductById(iproduct);
        Suppliers supplier = suppliersServices.readSupplierById(isupplier);

        old_delivery.setId_product(product);
        old_delivery.setId_supplier(supplier);
        old_delivery.setCount_prod(count_prod);
        old_delivery.setDate_deliver(date_deliver);
        old_delivery.setStorage_time(storage_time);

        deliveriesServices.updateDelivery(old_delivery);

        return "redirect:/deliveries";
    }

    @GetMapping("/delete-delivery")
    public String deleteDelivery(@RequestParam(name = "id_delivery") int id_delivery,
                                Model model) {
        Deliveries useless_delivery = deliveriesServices.readDeliveryById(id_delivery);
        deliveriesServices.deleteDelivery(useless_delivery);

        return "redirect:/deliveries";
    }
}
