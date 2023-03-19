package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PurchaseProductTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private CheckoutCompletePage checkoutCompletePage;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        productsPage = new ProductsPage(driver);
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testPurchaseProduct() {
        productsPage.addProductToCart(0);
        productsPage.clickCartButton();
        cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterFirstName("test");
        checkoutPage.enterLastName("test");
        checkoutPage.enterZipCode("test");
        checkoutPage.clickContinueButton();
        checkoutPage.clickFinishButton();
        checkoutCompletePage = new CheckoutCompletePage(driver);
        String successMessage = checkoutCompletePage.getCompleteHeaderText();
        assertEquals("THANK YOU FOR YOUR ORDER", successMessage);
    }
}
