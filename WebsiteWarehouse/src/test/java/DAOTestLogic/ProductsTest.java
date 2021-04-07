package DAOTestLogic;

import Classes.Suppliers;
import Services.ProductsServices;
import Services.SuppliersServices;
import org.testng.*;

import Classes.Products;
import org.testng.annotations.Test;

import java.util.*;


import static org.testng.Assert.*;

public class ProductsTest {
    private ProductsServices productService;
    private Products expectedProduct;

    @Test(alwaysRun = true)
    public void testCreateNewProduct() {
        SuppliersServices supplierService = new SuppliersServices();
        Suppliers tmpSupplier = supplierService.readSupplierById(2);

        productService = new ProductsServices();
        expectedProduct = new Products("Jack Daniels","алкоголь",25,"шт",java.sql.Date.valueOf("2020-12-30"),"F12",tmpSupplier);
        productService.createProduct(expectedProduct);

        Products realProduct = productService.readProductById(expectedProduct.getId_product());
        assertEquals(expectedProduct, realProduct);

        productService.deleteProduct(expectedProduct);
    }

    @Test(alwaysRun = true)
    public void testUpdateProduct() {
        SuppliersServices supplierService = new SuppliersServices();
        Suppliers tmpSupplier = supplierService.readSupplierById(2);

        productService = new ProductsServices();
        expectedProduct = new Products("Jack Daniels","алкоголь",25,"шт",java.sql.Date.valueOf("2020-12-30"),"F12",tmpSupplier);
        productService.createProduct(expectedProduct);

        Products realProduct = productService.readProductById(expectedProduct.getId_product());
        assertEquals(expectedProduct, realProduct);

        expectedProduct.setCount_prod(30);
        productService.updateProduct(expectedProduct);
        realProduct = productService.readProductById(expectedProduct.getId_product());
        assertEquals(expectedProduct, realProduct);

        productService.deleteProduct(expectedProduct);
    }

    @Test(alwaysRun = true)
    public void testDeleteProduct() {
        SuppliersServices supplierService = new SuppliersServices();
        Suppliers tmpSupplier = supplierService.readSupplierById(2);

        productService = new ProductsServices();
        expectedProduct = new Products("Jack Daniels","алкоголь",25,"шт",java.sql.Date.valueOf("2020-12-30"),"F12",tmpSupplier);
        productService.createProduct(expectedProduct);

        Products realProduct = productService.readProductById(expectedProduct.getId_product());
        assertEquals(expectedProduct, realProduct);

        productService.deleteProduct(expectedProduct);
        realProduct = productService.readProductById(expectedProduct.getId_product());
        Assert.assertNull(realProduct);
    }

    @Test(alwaysRun = true)
    public void testReadProductById() {
        SuppliersServices supplierService = new SuppliersServices();
        Suppliers tmpSupplier = supplierService.readSupplierById(2);

        productService = new ProductsServices();
        expectedProduct = new Products("Jack Daniels","алкоголь",25,"шт",java.sql.Date.valueOf("2020-12-30"),"F12",tmpSupplier);
        productService.createProduct(expectedProduct);

        Products realProduct = productService.readProductById(expectedProduct.getId_product());
        assertEquals(expectedProduct.getId_product(), realProduct.getId_product());

        productService.deleteProduct(expectedProduct);
    }

    @Test(alwaysRun = true)
    public void testReadByStorage_location() {
        SuppliersServices supplierService = new SuppliersServices();
        Suppliers tmpSupplier = supplierService.readSupplierById(2);

        productService = new ProductsServices();
        expectedProduct = new Products("Jack Daniels","алкоголь",25,"шт",java.sql.Date.valueOf("2020-12-30"),"F12",tmpSupplier);
        productService.createProduct(expectedProduct);

        SuppliersServices supplierService1 = new SuppliersServices();
        Suppliers tmpSupplier1 = supplierService1.readSupplierById(2);
        SuppliersServices supplierService2 = new SuppliersServices();
        Suppliers tmpSupplier2 = supplierService2.readSupplierById(5);

        ProductsServices productsServices = new ProductsServices();
        Set<Products> expectedProducts = Set.of(
                expectedProduct,
                new Products("Dual Cook Flex","бытовая техника",10,"шт",java.sql.Date.valueOf("2021-01-10"),"A01",tmpSupplier1),
                new Products("Huion Sample","бытовая техника",15,"шт",java.sql.Date.valueOf("2021-02-01"),"A01",tmpSupplier1),
                new Products("Миф","бытовая химия",30,"шт",java.sql.Date.valueOf("2020-11-29"),"B01",tmpSupplier2)
        );
        List<Products> realProducts = productsServices.readProductByStorage_location("A01");
        assertEquals(realProducts.size() - 2, expectedProducts.size());
        expectedProducts.clear();

        productService.deleteProduct(expectedProduct);
    }

    @Test(alwaysRun = true)
    public void testReadByTypeProduct() {
        SuppliersServices supplierService = new SuppliersServices();
        Suppliers tmpSupplier = supplierService.readSupplierById(2);

        productService = new ProductsServices();
        expectedProduct = new Products("Jack Daniels","алкоголь",25,"шт",java.sql.Date.valueOf("2020-12-30"),"F12",tmpSupplier);
        productService.createProduct(expectedProduct);

        SuppliersServices supplierService1 = new SuppliersServices();
        Suppliers tmpSupplier1 = supplierService1.readSupplierById(2);
        SuppliersServices supplierService2 = new SuppliersServices();
        Suppliers tmpSupplier2 = supplierService2.readSupplierById(5);

        ProductsServices productsServices = new ProductsServices();
        Set<Products> expectedProducts = Set.of(
                expectedProduct,
                new Products("Dual Cook Flex","бытовая техника",10,"шт",java.sql.Date.valueOf("2021-01-10"),"A01",tmpSupplier1),
                new Products("Huion Sample","бытовая техника",15,"шт",java.sql.Date.valueOf("2021-02-01"),"A01",tmpSupplier1),
                new Products("Миф","бытовая химия",30,"шт",java.sql.Date.valueOf("2020-11-29"),"B01",tmpSupplier2)
        );
        List<Products> realProducts = productsServices.readProductByType("алкоголь");
        assertEquals(realProducts.size() - 3, expectedProducts.size());
        expectedProducts.clear();

        productService.deleteProduct(expectedProduct);
    }

    @Test(alwaysRun = true)
    public void testReadByDate() {
        SuppliersServices supplierService = new SuppliersServices();
        Suppliers tmpSupplier = supplierService.readSupplierById(2);

        productService = new ProductsServices();
        expectedProduct = new Products("Jack Daniels","алкоголь",25,"шт",java.sql.Date.valueOf("2020-12-30"),"F12",tmpSupplier);
        productService.createProduct(expectedProduct);

        SuppliersServices supplierService1 = new SuppliersServices();
        Suppliers tmpSupplier1 = supplierService1.readSupplierById(2);
        SuppliersServices supplierService2 = new SuppliersServices();
        Suppliers tmpSupplier2 = supplierService2.readSupplierById(5);

        ProductsServices productsServices = new ProductsServices();
        Set<Products> expectedProducts = Set.of(
                expectedProduct,
                new Products("Dual Cook Flex","бытовая техника",10,"шт",java.sql.Date.valueOf("2021-01-10"),"A01",tmpSupplier1),
                new Products("Huion Sample","бытовая техника",15,"шт",java.sql.Date.valueOf("2021-02-01"),"A01",tmpSupplier1),
                new Products("Миф","бытовая химия",30,"шт",java.sql.Date.valueOf("2020-11-29"),"B01",tmpSupplier2)
        );
        List<Products> realProducts = productsServices.readProductByDate(java.sql.Date.valueOf("2020-11-29"));
        assertEquals(realProducts.size(), expectedProducts.size() - 3);
        expectedProducts.clear();

        productService.deleteProduct(expectedProduct);
    }
}
