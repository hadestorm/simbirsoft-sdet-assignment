package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {

    protected WebDriver driver;

    // Element locators
    @FindBy(css = ".inventory_item button")
    private List<WebElement> addToCartButtons;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartButton;

    // Class constructors
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Class methods
    public void addProductToCart(int index) {
        addToCartButtons.get(index).click();
    }

    public void clickCartButton() {
        cartButton.click();
    }

}
