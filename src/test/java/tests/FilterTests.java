package tests;

import commands.LoginCommand;
import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.FilterPage;
import pages.ProductPage;

public class FilterTests extends BaseTest {

    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeEach
    public void setUp() {
        super.setUp(); // Chama o setup da BaseTest (opcional, se já não for chamado automaticamente)

        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        LoginCommand.login(driver, "standard_user", "secret_sauce");
    }

    @Test
    public void shouldApplyLowToHighPriceFilter() {
        FilterPage filterPage = new FilterPage(driver);
        filterPage.applyFilter("Price (low to high)");

        ProductPage productPage = new ProductPage(driver);
        productPage.assertFirstProductName("Sauce Labs Onesie");
    }

    @Test
    public void shouldApplyHighToLowPriceFilter() {
        FilterPage filterPage = new FilterPage(driver);
        filterPage.applyFilter("Price (high to low)");

        ProductPage productPage = new ProductPage(driver);
        productPage.assertFirstProductName("Sauce Labs Fleece Jacket");
    }
}