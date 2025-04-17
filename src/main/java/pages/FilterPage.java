package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class FilterPage {
    private WebDriver driver;

    // Locators
    private By filterDropdown = By.className("product_sort_container");
    private By firstProductName = By.cssSelector(".inventory_item_name");

    public FilterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void applyFilter(String option) {
        // Use Select to safely handle dropdown
        Select select = new Select(driver.findElement(filterDropdown));
        select.selectByVisibleText(option);

        // Wait until first product is visible (after filter applied)
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(firstProductName));
    }
}