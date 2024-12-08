package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

@Listeners(ScreenshotListener.class)
public class TestBase {


    @BeforeMethod
    public void methodSetup() {
        String browser = System.getProperty("browser", "chrome");

        Configuration.browser = browser;
        Configuration.pageLoadTimeout = 5000;

        open("https://litecart.stqa.ru/en/");
    }
    @AfterMethod
    public void methodTeardown() {
        Selenide.closeWebDriver();
    }

}
//Selenide.closeWindow()