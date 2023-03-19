package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    protected WebDriver driver;

    // Element locators
    private By checkoutButton = By.id("checkout");

    // Class constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Class methods
    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }
}
