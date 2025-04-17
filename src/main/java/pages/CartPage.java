package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    // Localizadores
    private By cartItemName = By.className("cart_item");
    private By checkoutButton = By.id("checkout");
    private By removeFromCartButton = By.id("remove-sauce-labs-backpack");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    public void assertFirstProductName(String expectedName) {
        String name = driver.findElement(cartItemName).getText();
        assert(name.contains(expectedName));
    }

    public void checkout() {
        driver.findElement(checkoutButton).click();
    }

    public void removeFromCartBTN() {
        driver.findElement(removeFromCartButton).click();
    }
}