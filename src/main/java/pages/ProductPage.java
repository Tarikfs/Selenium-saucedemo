package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductPage {
    private WebDriver driver;

    // Localizadores
    private By productTitle = By.className("inventory_item_name");
    private By productDescription = By.className("inventory_item_desc");
    private By productPrice = By.className("inventory_item_price");
    private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void assertProductDisplayed(String productName) {
        driver.findElement(By.linkText(productName)).isDisplayed();
    }

    public void assertFirstProductName(String expectedName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".inventory_item_name")));

        String actualName = firstProduct.getText();
        System.out.println("Actual product name found: " + actualName);

        assertEquals(expectedName, actualName);
    }

    public void assertFirstProductDescription(String expectedDescription) {
        String description = driver.findElement(productDescription).getText();
        assert(description.equals(expectedDescription));
    }

    public void assertFirstProductPrice(String expectedPrice) {
        String price = driver.findElement(productPrice).getText();
        assert(price.equals(expectedPrice));
    }

    public void addToCartBTN() {
        driver.findElement(addToCartButton).click();
    }

    public boolean isCartEmpty() {
        try {
            // If the cart badge exists, it means the cart is NOT empty
            driver.findElement(By.className("shopping_cart_badge"));
            return false; // badge found = not empty
        } catch (NoSuchElementException e) {
            return true; // badge not found = empty cart
        }
    }
}