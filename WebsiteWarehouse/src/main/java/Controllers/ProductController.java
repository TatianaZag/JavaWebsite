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

        Products tmp_prod = productsServices.readProductById(new_product.getId_product());
        if(tmp_prod == null) {
            model.addAttribute("error", "Product create error");
            return "pageError";
        }

        return "redirect:/products";
    }

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

        return "redirect:/products";
    }

    @GetMapping("/delete-product")
    public String deleteProduct(@RequestParam(name = "id_product", required = true) int id_product,
                                Model model) {
        Products useless_product = productsServices.readProductById(id_product);
        productsServices.deleteProduct(useless_product);

        return "redirect:/products";
    }

    @GetMapping("/filter-product")
    public String filtration(Model model) {
        return "FiltrationProduct";
    }

    @PostMapping("/filtrated")
    public String filterProduct(@RequestParam(name = "type_prod") String type_prod,
                             @RequestParam(name = "date_after") Date date_after,
                             @RequestParam(name = "date_before") Date date_before,
                             @RequestParam(name = "supplier") int isupplier,
                             Model model) {
        List<Products> prod_type = productsServices.readProductAll();
        List<Products> prod_after = productsServices.readProductAll();
        List<Products> prod_before = productsServices.readProductAll();
        List<Products> prod_id = productsServices.readProductAll();

        if(type_prod != null) {
            prod_type = productsServices.findProductByT(type_prod);
        }
        if(date_after != null) {
            prod_after = productsServices.findProductByDA(date_after);
        }
        if(date_before != null) {
            prod_before = productsServices.findProductByDB(date_before);
        }
        if(isupplier != -1) {
            prod_id = productsServices.findProductByIS(isupplier);
        }

        prod_type.retainAll(prod_after);
        prod_type.retainAll(prod_before);
        prod_type.retainAll(prod_id);

        model.addAttribute("filter_products", prod_type);

        return "UpdateProducts";
    }
}
