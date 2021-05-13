package Controllers;

import Classes.Products;
import Classes.Suppliers;
import Services.ProductsServices;
import Services.SuppliersServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class EditProdController {
    ProductsServices productsServices = new ProductsServices();
    SuppliersServices suppliersServices = new SuppliersServices();

    @GetMapping("/edit-product")
    public String productEdit(@RequestParam(name = "id_product", required = true) int id_product, Model model) {
        Products prod = productsServices.readProductById(id_product);
        model.addAttribute("products", prod);
        return "EditProduct";
    }

    @PostMapping("/save-edit-product")
    public String editProduct(@RequestParam(name = "name_product") String name_product,
                              @RequestParam(name = "type_prod") String type_prod,
                              @RequestParam(name = "count_prod") int count_prod,
                              @RequestParam(name = "unit_measure") String unit_measure,
                              @RequestParam(name = "date_prod") Date date_prod,
                              @RequestParam(name = "storage_location") String storage_location,
                              @RequestParam(name = "supplier") int isupplier,
                              @RequestParam(name = "id_product") int id_product,
                              Model model) {
        Products old_product = productsServices.readProductById(id_product);

        Suppliers supplier = suppliersServices.readSupplierById(isupplier);

        old_product.setName_product(name_product);
        old_product.setType_prod(type_prod);
        old_product.setCount_prod(count_prod);
        old_product.setUnit_measure(unit_measure);
        old_product.setDate_prod(date_prod);
        old_product.setStorage_location(storage_location);
        old_product.setId_supplier(supplier);

        productsServices.updateProduct(old_product);

        return "SuccessSave";
    }

    @PostMapping("/delete-product")
    public String deleteProduct(@RequestParam(name = "name_product") String name_product,
                                @RequestParam(name = "type_prod") String type_prod,
                                @RequestParam(name = "count_prod") int count_prod,
                                @RequestParam(name = "unit_measure") String unit_measure,
                                @RequestParam(name = "date_prod") Date date_prod,
                                @RequestParam(name = "storage_location") String storage_location,
                                @RequestParam(name = "supplier") int isupplier,
                                @RequestParam(name = "id_product") int id_product,
                                Model model) {
        Products useless_product = productsServices.readProductById(id_product);

        productsServices.deleteProduct(useless_product);

        return "SuccessSave";
    }
}
