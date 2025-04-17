package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    // Localizadores
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By errorMessage = By.cssSelector(".error-message-container.error");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void fillZipPostalCode(String zipCode) {
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void continueButton() {
        driver.findElement(continueButton).click();
    }

    public void finish() {
        driver.findElement(finishButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}