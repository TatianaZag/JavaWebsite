package DAOTestLogic;

import Services.ProductsServices;
import org.testng.*;

import Classes.Products;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;


import static org.testng.Assert.*;

public class ProductsTest {
    private ProductsServices productService;
    private Products expectedProduct;

    @BeforeTest
    public void setUp() {
        productService = new ProductsServices();
        expectedProduct = new Products(1,
                "Jack Daniels",
                "алкоголь",
                25,
                "шт",
                java.sql.Date.valueOf("2020-12-30"),
                "F12",
                2);
        productService.createProduct(expectedProduct);
    }

    @Test
    public void testCreateNewProduct() {
        Products realProduct = productService.readProductById(expectedProduct.getId_product());
        assertEquals(expectedProduct, realProduct);
    }

    @Test
    public void testUpdateProduct() {
        Products realProduct = productService.readProductById(expectedProduct.getId_product());
        assertEquals(expectedProduct, realProduct);

        expectedProduct.setCount_prod(30);
        productService.updateProduct(expectedProduct);
        realProduct = productService.readProductById(expectedProduct.getId_product());
        assertEquals(expectedProduct, realProduct);
    }

    @Test
    public void testDeleteProduct() {
        Products realProduct = productService.readProductById(expectedProduct.getId_product());
        assertEquals(expectedProduct, realProduct);

        productService.deleteProduct(expectedProduct);
        realProduct = productService.readProductById(expectedProduct.getId_product());
        assertEquals(expectedProduct, realProduct);
    }

    @Test
    public void testReadProductById() {
        Products realProduct = productService.readProductById(expectedProduct.getId_product());
        assertEquals(expectedProduct.getId_product(), realProduct.getId_product());
    }

    @Test
    public void testReadByStorage_location() {
        ProductsServices productsServices = new ProductsServices();
        Set<Products> expectedProducts = Set.of(
                expectedProduct,
                new Products(2,"Dual Cook Flex","бытовая техника",10,"шт",java.sql.Date.valueOf("2021-01-10"),"A01",1),
                new Products(3,"Huion Sample","бытовая техника",15,"шт",java.sql.Date.valueOf("2021-02-01"),"A01",1),
                new Products(4,"Миф","бытовая химия",30,"шт",java.sql.Date.valueOf("2020-11-29"),"B01",3)
        );
        List<Products> realProducts = productsServices.readProductByStorage_location("A01");
        assertEquals(realProducts.size() - 2, expectedProducts.size());
        expectedProducts.clear();
    }

    @Test
    public void testReadByTypeProduct() {
        ProductsServices productsServices = new ProductsServices();
        Set<Products> expectedProducts = Set.of(
                expectedProduct,
                new Products(2,"Dual Cook Flex","бытовая техника",10,"шт",java.sql.Date.valueOf("2021-01-10"),"A01",1),
                new Products(3,"Huion Sample","бытовая техника",15,"шт",java.sql.Date.valueOf("2021-02-01"),"A01",1),
                new Products(4,"Миф","бытовая химия",30,"шт",java.sql.Date.valueOf("2020-11-29"),"B01",3)
        );
        List<Products> realProducts = productsServices.readProductByType("алкоголь");
        assertEquals(realProducts.size() - 3, expectedProducts.size());
        expectedProducts.clear();
    }

    @Test
    public void testReadByDate() {
        ProductsServices productsServices = new ProductsServices();
        Set<Products> expectedProducts = Set.of(
                expectedProduct,
                new Products(2,"Dual Cook Flex","бытовая техника",10,"шт",java.sql.Date.valueOf("2021-01-10"),"A01",1),
                new Products(3,"Huion Sample","бытовая техника",15,"шт",java.sql.Date.valueOf("2021-02-01"),"A01",1),
                new Products(4,"Миф","бытовая химия",30,"шт",java.sql.Date.valueOf("2020-11-29"),"B01",3)
        );
        List<Products> realProducts = productsServices.readProductByDate(java.sql.Date.valueOf("2020-11-29"));
        assertEquals(realProducts.size() - 3, expectedProducts.size());
        expectedProducts.clear();
    }

    @AfterTest
    public void afterTest() {
        productService.deleteProduct(expectedProduct);
    }
}
