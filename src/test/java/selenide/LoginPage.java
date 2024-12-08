package selenide;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static By emailInput = By.name("email");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.name("login");
    private static By errorMessageLabel = By.cssSelector(".notice.errors");
    private static By purpleDuckLink = By.cssSelector("[alt='Purple Duck']");
    private static By addToCartButton = By.cssSelector("[name='add_cart_product'][type='submit']");
    private static By cartQuantityLabelLocator = By.cssSelector("span[class='quantity']");
    private static By cartLink = By.cssSelector("[src='/includes/templates/default.catalog/images/cart.png']");
    private static By successMessageLabel = By.cssSelector(".notice.success");

    @Step("Type email: {email}")
    public static void typeEmail(String email) {

        $(emailInput).sendKeys(email);
    }

    @Step("Type password")
    public static void typePassword(String password) {
        $(passwordInput).sendKeys(password);
    }

    @Step("Click on the login button")
    public static void clickLoginButton() {
        $(loginButton).click();
    }

    @Step("Login with email: {email} and password")
    public static void loginWithCredentials(String email, String password) {
        typeEmail(email);
        typePassword(password);
        clickLoginButton();
    }

    @Step("Validate that error message is displayed")
    public static void validateErrorMessageIsDisplayed() {
        $(errorMessageLabel).shouldBe(visible);
    }

    @Step("Validate that the error message text is: {expectedText}")
    public static void validateErrorMessageText(String expectedText) {
        $(errorMessageLabel).shouldHave(Condition.text(expectedText));
    }

    @Step("Click on the Purple Duck link")
    public static void clickPurpleDuckLink() {
        $(purpleDuckLink).click();
    }

    @Step("Click on the Add to Cart button")
    public static void clickAddToCartButton() {
        $(addToCartButton).click();
    }

    @Step("Validate that the cart quantity label text is: {expectedText}")
    public static void validateTextFromCartQuantityLabel(String expectedText) {
        $(cartQuantityLabelLocator).shouldHave(Condition.text(expectedText));
    }

    @Step("Click on the Cart link")
    public static void clickCart() {
        $(cartLink).click();
    }

    @Step("Validate that the success message is displayed")
    public static void valideSuccessMessageIsDisplayed() {
        $(successMessageLabel).shouldBe(visible);
    }

    @Step("Validate that the success message text is: {expectedText}")
    public static void valideSuccessMessageText(String expectedText) {
        $(successMessageLabel).shouldHave(Condition.text(expectedText));
    }

}
