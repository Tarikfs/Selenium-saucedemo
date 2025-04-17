package tests;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTests extends BaseTest {

    @Test
    public void shouldLoginSuccessfullyWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visit();
        loginPage.fillUsername("standard_user");
        loginPage.fillPassword("secret_sauce");
        loginPage.submit();

        ProductPage productPage = new ProductPage(driver);
        productPage.assertProductDisplayed("Sauce Labs Backpack");
    }

    @Test
    public void shouldShowErrorForLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.visit();
        loginPage.fillUsername("locked_out_user");
        loginPage.fillPassword("secret_sauce");
        loginPage.submit();

        assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.getErrorMessage());
    }
}