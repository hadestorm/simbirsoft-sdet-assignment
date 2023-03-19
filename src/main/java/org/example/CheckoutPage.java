package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    protected WebDriver driver;

    // Element locators
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");

    // Class constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Class methods
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterZipCode(String zipCode) {
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public void clickFinishButton() {
        driver.findElement(finishButton).click();
    }
}
