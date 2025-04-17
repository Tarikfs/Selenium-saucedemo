package tests;

import commands.LoginCommand;
import core.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.ResetAppStatePage;
import pages.ProductPage;

public class ResetAppStateTests extends BaseTest {

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
    public void shouldResetAppState() {
        ProductPage productPage = new ProductPage(driver);
        productPage.addToCartBTN();

        ResetAppStatePage resetPage = new ResetAppStatePage(driver);
        resetPage.reset();

        // Ensure that app state is reset and cart is empty
        assert productPage.isCartEmpty();
    }
}