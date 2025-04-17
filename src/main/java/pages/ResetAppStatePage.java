package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResetAppStatePage {
    private WebDriver driver;

    // Localizadores
    private By menuButton = By.id("react-burger-menu-btn");
    private By resetButton = By.id("reset_sidebar_link");

    public ResetAppStatePage(WebDriver driver) {
        this.driver = driver;
    }

    public void reset() {
        driver.findElement(menuButton).click();
        driver.findElement(resetButton).click();
    }
}
