package SystemTests;

import Classes.Products;
import Classes.Suppliers;
import Services.SuppliersServices;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

/*
public class SystemTest {
    protected final String appURL = "http://localhost:8080/";
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.firefox.driver", "/usr/bin/firefoxdriver");

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
        Assert.assertTrue(infoText.contains(String.valueOf(product.getId_supplier())));
    }

    @Test()
    void productAddEditDeleteTest() {
        SuppliersServices supplierService = new SuppliersServices();
        Suppliers tmpSupplier = supplierService.readSupplierById(1);

        Products new_product = new Products("Wonder", "виниловые пластинки", 100,
                "шт", Date.valueOf("2021-03-01"), "F122", tmpSupplier);

        driver.findElement(By.id("mainProduct")).click();
        Assert.assertEquals(driver.getTitle(), "Товары");

        /* testing adding a product */
/*
        driver.findElement(By.id("addProduct")).click();
        Assert.assertEquals(driver.getTitle(), "Добавить новый товар");
        driver.findElement(By.name("name_product")).sendKeys(new_product.getName_product());
        driver.findElement(By.name("type_prod")).sendKeys(new_product.getType_prod());
        driver.findElement(By.name("count_prod")).sendKeys(String.valueOf(new_product.getCount_prod()));
        driver.findElement(By.name("unit_measure")).sendKeys(new_product.getUnit_measure());
        driver.findElement(By.name("date_prod")).sendKeys("2021-03-01");
        driver.findElement(By.name("storage_location")).sendKeys(new_product.getStorage_location());
        driver.findElement(By.name("supplier")).sendKeys(String.valueOf(new_product.getId_supplier()));
        driver.findElement(By.id("submitAdd")).click();

        Assert.assertEquals(driver.getTitle(), "Товары");
        checkInfoProduct(new_product, driver.findElement(By.id("infoProduct")).getText());
    }


}
*/