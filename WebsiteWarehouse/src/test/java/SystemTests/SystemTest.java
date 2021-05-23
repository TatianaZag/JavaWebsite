package SystemTests;

import Classes.Deliveries;
import Classes.Products;
import Classes.Suppliers;
import Services.ProductsServices;
import Services.SuppliersServices;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

public class SystemTest {
    protected final String appURL = "http://localhost:8080/";
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");

        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1000, 1000));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void checkInfoProduct(Products product, String infoText) {
        Assert.assertTrue(infoText.contains(product.getName_product()));
        Assert.assertTrue(infoText.contains(product.getType_prod()));
        Assert.assertTrue(infoText.contains(String.valueOf(product.getCount_prod()) + ' ' + product.getUnit_measure()));
        Assert.assertTrue(infoText.contains("2021-03-01"));
        Assert.assertTrue(infoText.contains(product.getStorage_location()));
        Assert.assertTrue(infoText.contains(String.valueOf(product.getId_supplier().getId_supplier())));
    }

    public void checkInfoSuppliers(Suppliers supplier, String infoText) {
        Assert.assertTrue(infoText.contains(supplier.getName_supplier()));
        Assert.assertTrue(infoText.contains(String.valueOf(supplier.getId_type())));
        Assert.assertTrue(infoText.contains(supplier.getEmail()));
        Assert.assertTrue(infoText.contains(supplier.getNumber_phone()));
        Assert.assertTrue(infoText.contains(supplier.getAddress()));
    }

    public void checkInfoDeliveries(Deliveries delivery, String infoText) {
        Assert.assertTrue(infoText.contains(String.valueOf(delivery.getId_supplier().getId_supplier())));
        Assert.assertTrue(infoText.contains(String.valueOf(delivery.getId_product().getId_product())));
        Assert.assertTrue(infoText.contains(String.valueOf(delivery.getCount_prod())));
        Assert.assertTrue(infoText.contains("2021-05-10"));
        Assert.assertTrue(infoText.contains(String.valueOf(delivery.getStorage_time())));
    }

    @Test()
    void productAddEditDeleteTest() {
        SuppliersServices supplierService = new SuppliersServices();
        Suppliers tmpSupplier = supplierService.readSupplierById(2);

        Products new_product = new Products("Wonder", "виниловые пластинки", 100,
                "шт", Date.valueOf("2021-03-01"), "F122", tmpSupplier);

        driver.get(appURL);
        Assert.assertEquals(driver.getTitle(), "Главная страница");

        driver.findElement(By.id("mainProduct")).click();
        Assert.assertEquals(driver.getTitle(), "Товары");

        /* testing adding a product*/
        driver.findElement(By.id("addProduct")).click();
        Assert.assertEquals(driver.getTitle(), "Добавить новый товар");
        driver.findElement(By.name("name_product")).sendKeys(new_product.getName_product());
        driver.findElement(By.name("type_prod")).sendKeys(new_product.getType_prod());
        driver.findElement(By.name("count_prod")).sendKeys(String.valueOf(new_product.getCount_prod()));
        driver.findElement(By.name("unit_measure")).sendKeys(new_product.getUnit_measure());
        driver.findElement(By.name("date_prod")).sendKeys("2021-03-01");
        driver.findElement(By.name("storage_location")).sendKeys(new_product.getStorage_location());
        driver.findElement(By.name("supplier")).sendKeys(String.valueOf(new_product.getId_supplier().getId_supplier()));
        driver.findElement(By.id("submitAdd")).click();
        Assert.assertEquals(driver.getTitle(), "Товары");
        checkInfoProduct(new_product, driver.findElement(By.id("infoProduct")).getText());

        /* testing editing a product*/
        String new_storage_location = "B 02";
        driver.get("http://localhost:8080/edit-product?id_product=" + driver.findElement(By.name("id_product")).getAttribute("value"));
        new_product.setStorage_location(new_storage_location);
        driver.findElement(By.name("storage_location")).clear();
        driver.findElement(By.name("storage_location")).sendKeys(new_product.getStorage_location());
        driver.findElement(By.tagName("button")).click();
        Assert.assertEquals(driver.getTitle(), "Товары");
        checkInfoProduct(new_product, driver.findElement(By.id("infoProduct")).getText());

        /* testing deleting a product */
        driver.get("http://localhost:8080/edit-product?id_product=" + driver.findElement(By.name("id_product")).getAttribute("value"));
        driver.findElement(By.id("deleteBtn")).click();
        Assert.assertEquals(driver.getTitle(), "Товары");
    }

    @Test
    void supplierAddEditDeleteTest() {
        Suppliers new_supplier = new Suppliers("Алукард Фон Неймон", 2, "alucardFN@castlvania.com",
                "5(146)666-66 6", "Кастльвания, пр. Дракулы, 10");

        driver.get(appURL);
        Assert.assertEquals(driver.getTitle(), "Главная страница");

        driver.findElement(By.id("mainSuppliers")).click();
        Assert.assertEquals(driver.getTitle(), "Поставщики");

        /* testing adding a supplier */
        driver.findElement(By.id("addSupplier")).click();
        Assert.assertEquals(driver.getTitle(), "Добавить нового поставщика");
        driver.findElement(By.name("name_supplier")).sendKeys(new_supplier.getName_supplier());
        driver.findElement(By.name("id_type")).sendKeys(String.valueOf(new_supplier.getId_type()));
        driver.findElement(By.name("email")).sendKeys(new_supplier.getEmail());
        driver.findElement(By.name("number_phone")).sendKeys(new_supplier.getNumber_phone());
        driver.findElement(By.name("address")).sendKeys(new_supplier.getAddress());
        driver.findElement(By.id("submitAddSupp")).click();
        Assert.assertEquals(driver.getTitle(), "Поставщики");
        checkInfoSuppliers(new_supplier, driver.findElement(By.id("infoSupplier")).getText());

        /* testing editing a supplier */
        String new_email = "alucardVamp@castlvania.com";
        driver.get("http://localhost:8080/edit-supplier?id_supplier=" + driver.findElement(By.name("id_supplier")).getAttribute("value"));
        new_supplier.setEmail(new_email);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(new_supplier.getEmail());
        driver.findElement(By.tagName("button")).click();
        Assert.assertEquals(driver.getTitle(), "Поставщики");
        checkInfoSuppliers(new_supplier, driver.findElement(By.id("infoSupplier")).getText());

        /* testing deleting a supplier*/
        driver.get("http://localhost:8080/edit-supplier?id_supplier=" + driver.findElement(By.name("id_supplier")).getAttribute("value"));
        driver.findElement(By.id("deleteBtn")).click();
        Assert.assertEquals(driver.getTitle(), "Поставщики");
    }

    @Test
    void deliveryAddEditDeleteTest() {
        SuppliersServices supplierService = new SuppliersServices();
        Suppliers tmpSupplier = supplierService.readSupplierById(35);
        ProductsServices productsServices = new ProductsServices();
        Products tmpProduct = productsServices.readProductById(120);

        Deliveries new_delivery = new Deliveries(tmpProduct, tmpSupplier, 25,
                Date.valueOf("2021-05-10"), 5);

        driver.get(appURL);
        Assert.assertEquals(driver.getTitle(), "Главная страница");

        driver.findElement(By.id("mainDeliveries")).click();
        Assert.assertEquals(driver.getTitle(), "Поставки");

        /* testing adding a delivery */
        driver.findElement(By.id("deliveryAdd")).click();
        Assert.assertEquals(driver.getTitle(), "Добавить новую поставку");
        driver.findElement(By.name("supplier")).sendKeys(String.valueOf(new_delivery.getId_supplier().getId_supplier()));
        driver.findElement(By.name("product")).sendKeys(String.valueOf(new_delivery.getId_product().getId_product()));
        driver.findElement(By.name("count_prod")).sendKeys(String.valueOf(new_delivery.getCount_prod()));
        driver.findElement(By.name("date_deliver")).sendKeys("2021-05-10");
        driver.findElement(By.name("storage_time")).sendKeys(String.valueOf(new_delivery.getStorage_time()));
        driver.findElement(By.id("submitAddDel")).click();
        Assert.assertEquals(driver.getTitle(), "Поставки");
        checkInfoDeliveries(new_delivery, driver.findElement(By.id("infoDelivery")).getText());

        /* testing editing a delivery */
        int new_count = 20;
        driver.get("http://localhost:8080/edit-delivery?id_delivery=" + driver.findElement(By.name("id_delivery")).getAttribute("value"));
        new_delivery.setCount_prod(new_count);
        driver.findElement(By.name("count_prod")).clear();
        driver.findElement(By.name("count_prod")).sendKeys(String.valueOf(new_delivery.getCount_prod()));
        driver.findElement(By.tagName("button")).click();
        Assert.assertEquals(driver.getTitle(), "Поставки");
        checkInfoDeliveries(new_delivery, driver.findElement(By.id("infoDelivery")).getText());

        /* testing deleting a delivery*/
        driver.get("http://localhost:8080/edit-delivery?id_delivery=" + driver.findElement(By.name("id_delivery")).getAttribute("value"));
        driver.findElement(By.id("deleteBtn")).click();
        Assert.assertEquals(driver.getTitle(), "Поставки");
    }

    @AfterClass
    public void end() {
        driver.quit();
    }

}