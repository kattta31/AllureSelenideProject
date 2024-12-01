package selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Shopping Cart Management")
@Feature("Cart Functionality")
public class CartTest extends TestBase {

    @Description("Test to verify that the correct message is displayed when the user checks an empty cart")
    @Story("User should see an empty cart message when the cart is empty")
    @Test
    public void checkEmptyCartTest() {
        LoginPage.clickCart();
        CartPage.validateEmptyCartMessageText("There are no items in your cart.");
    }

    @Description("Test to verify that clicking 'Add to Cart' updates the cart quantity correctly")
    @Story("User should be able to add a product to the cart successfully")
    @Test
    public void checkAddToCartTest() {
        LoginPage.clickPurpleDuckLink();
        LoginPage.clickAddToCartButton();
        LoginPage.validateTextFromCartQuantityLabel( "1");
    }
}
