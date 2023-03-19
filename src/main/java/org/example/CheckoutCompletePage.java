package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    protected WebDriver driver;

    // Element locators
    private By completeHeaderText = By.xpath("//*[contains(@class, 'complete-header')]");

    // Class constructor
    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    // Class methods
    public String getCompleteHeaderText() {
        return driver.findElement(completeHeaderText).getText();
    }
}
