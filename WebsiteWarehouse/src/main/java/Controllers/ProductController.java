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
import java.util.List;

@Controller
public class ProductController {
    ProductsServices productsServices = new ProductsServices();
    SuppliersServices suppliersServices = new SuppliersServices();

    @GetMapping("/products")
    public String product(Model model) {
        List<Products> prod = productsServices.readProductAll();
        model.addAttribute("products", prod);
        return "Products";
    }

    @GetMapping("/add-new-product")
    public String addProductPage() {
        return "AddNewProduct";
    }

    @PostMapping("/added")
    public String newProduct(@RequestParam(name = "name_product") String name_product,
                             @RequestParam(name = "type_prod") String type_prod,
                             @RequestParam(name = "count_prod") int count_prod,
                             @RequestParam(name = "unit_measure") String unit_measure,
                             @RequestParam(name = "date_prod") Date date_prod,
                             @RequestParam(name = "storage_location") String storage_location,
                             @RequestParam(name = "supplier") int isupplier,
                             Model model) {
        Products new_product;

        Suppliers supplier = suppliersServices.readSupplierById(isupplier);

        new_product = new Products(name_product, type_prod, count_prod, unit_measure,
                date_prod, storage_location, supplier);
        productsServices.createProduct(new_product);

        return "SuccessSave";
    }
}
