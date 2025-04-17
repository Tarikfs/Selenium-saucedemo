package tests;

import commands.LoginCommand;
import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ProductPage;
import pages.CartPage;
import pages.CheckoutPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductPageTests extends BaseTest {

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
    public void shouldDisplayProductsCorrectly() {
        productPage.assertProductDisplayed("Sauce Labs Backpack");
        productPage.assertFirstProductDescription("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        productPage.assertFirstProductPrice("$29.99");
    }
}