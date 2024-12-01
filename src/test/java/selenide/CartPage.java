package selenide;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    private static By emptyCartMessage = By.cssSelector("#checkout-cart-wrapper>p>em");

    @Step("Validate that the empty cart message is displayed with expected text: {expectedText}")
    public static void validateEmptyCartMessageText(String expectedText) {
        $(emptyCartMessage).shouldHave(Condition.text(expectedText));
    }
}

