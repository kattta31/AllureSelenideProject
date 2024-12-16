package selenide;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Login Functionality Implementation")
@Feature("Login")
public class LoginTest extends TestBase {

    @Description("Test login with correct email and wrong password to verify error message is displayed")
    @Story("User should not be able to log in with incorrect password")
    @Test
    public void loginWithCorrectEmailAndWrongPassword() {
        LoginPage.loginWithCredentials("kattta@tut.by", "123111");
        LoginPage.validateErrorMessageIsDisplayed();
        LoginPage.validateErrorMessageText("Wrong password or the account is disabled, or does not exist");
    }

    @Description("Test login with unregistered email and any password to verify that the appropriate error message is displayed")
    @Story("User should receive an error message when trying to log in with unregistered credentials")
    @Test
    public void InputOfAnUnregisteredUser() {
        LoginPage.loginWithCredentials("katyakarpukhina31@gmail.com", "123111");
        LoginPage.validateErrorMessageIsDisplayed();
        LoginPage.validateErrorMessageText("Wrong password or the account is disabled, or does not exist");
    }

    @Description("Test login for a registered user with valid credentials to verify success message is displayed")
    @Story("Registered user should be able to log in successfully")
    @Test
    public void RegisteredUserInput() {
        LoginPage.loginWithCredentials("kattta@tut.by", "123123!!");//Specially added "!" for test failure
        LoginPage.valideSuccessMessageIsDisplayed();
        LoginPage.valideSuccessMessageText("You are now logged in as Katya Karpukhina.");
    }

}
