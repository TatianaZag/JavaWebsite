package Controllers;

import Classes.Products;
import Classes.Suppliers;
import Services.ProductsServices;
import Services.SuppliersServices;
import org.springframework.format.annotation.DateTimeFormat;
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
                             @RequestParam(name = "count_prod", defaultValue = "-1") int count_prod,
                             @RequestParam(name = "unit_measure") String unit_measure,
                             @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(name = "date_prod", required = false) java.util.Date date_prod,
                             @RequestParam(name = "storage_location") String storage_location,
                             @RequestParam(name = "supplier", defaultValue = "-1") int isupplier,
                             Model model) {
        Products new_product;
        Suppliers supplier;
        if(isupplier > 0) {
            supplier = suppliersServices.readSupplierById(isupplier);
            if (supplier == null) {
                model.addAttribute("error", "Not exist supplier");
                return "pageError";
            }
        }
        else {
            model.addAttribute("error", "Product create error");
            return "pageError";
        }
        Date sql_date = null;

        if (date_prod != null) {
            sql_date = new Date(date_prod.getTime());
        }
        else {
            model.addAttribute("error", "Product create error");
            return "pageError";
        }
        new_product = new Products(name_product, type_prod, count_prod, unit_measure,
                sql_date, storage_location, supplier);
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
                              @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(name = "date_prod", required = false) java.util.Date date_prod,
                              @RequestParam(name = "storage_location") String storage_location,
                              @RequestParam(name = "supplier") int isupplier,
                              @RequestParam(name = "id_product") int id_product,
                              Model model) {
        Products old_product = productsServices.readProductById(id_product);
        Suppliers supplier;
        if(isupplier > 0) {
            supplier = suppliersServices.readSupplierById(isupplier);
            if (supplier == null) {
                model.addAttribute("error", "Not exist supplier");
                return "pageError";
            }
        }
        else {
            model.addAttribute("error", "Product update error");
            return "pageError";
        }
        Date sql_date = null;

        if (date_prod != null) {
            sql_date = new Date(date_prod.getTime());
        }
        else {
            model.addAttribute("error", "Product update error");
            return "pageError";
        }

        old_product.setName_product(name_product);
        old_product.setType_prod(type_prod);
        old_product.setCount_prod(count_prod);
        old_product.setUnit_measure(unit_measure);
        old_product.setDate_prod(sql_date);
        old_product.setStorage_location(storage_location);
        old_product.setId_supplier(supplier);

        productsServices.updateProduct(old_product);

        Products tmp_prod = productsServices.readProductById(old_product.getId_product());
        if(tmp_prod == null) {
            model.addAttribute("error", "Product update error");
            return "pageError";
        }

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
    public String filterProduct(@RequestParam(name = "type_prod", required = false) String type_prod,
                                @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(name = "date_after", required = false) java.util.Date date_after,
                                @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam(name = "date_before", required = false) java.util.Date date_before,
                                @RequestParam(name = "supplier") int isupplier,
                                Model model) {
        Suppliers supplier = suppliersServices.readSupplierById(isupplier);

        List<Products> prod_type = productsServices.readProductAll();
        List<Products> prod_after = productsServices.readProductAll();
        List<Products> prod_before = productsServices.readProductAll();
        List<Products> prod_id = productsServices.readProductAll();

        if(type_prod != "") {
            prod_type = productsServices.findProductByT(type_prod);
        }
        if(date_after != null) {
            Date sql_date_after = new Date(date_after.getTime());
            prod_after = productsServices.findProductByDA(sql_date_after);
        }
        if(date_before != null) {
            Date sql_date_before = new Date(date_before.getTime());
            prod_before = productsServices.findProductByDB(sql_date_before);
        }
        if(isupplier != -1) {
            prod_id = productsServices.findProductByIS(supplier);
        }

        prod_type.retainAll(prod_after);
        prod_type.retainAll(prod_before);
        prod_type.retainAll(prod_id);

        model.addAttribute("filter_products", prod_type);

        return "UpdateProducts";
    }
}
