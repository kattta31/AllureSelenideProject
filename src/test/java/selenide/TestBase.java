package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import enums.Browser;
import enums.OperatingSystem;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import static enums.OperatingSystem.linux;
import static enums.OperatingSystem.windows;

@Listeners(ScreenshotListener.class)
public class TestBase {


    @BeforeMethod
    public void methodSetup() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        Browser browser = Browser.valueOf(System.getProperty("browser", "chrome"));
        OperatingSystem os = OperatingSystem.valueOf(System.getProperty("os", "windows"));

        switch (browser) {
            case chrome ->  caps.setBrowserName("chrome");
            case firefox -> caps.setBrowserName("firefox");
            default -> caps.setBrowserName("chrome");
        }

        switch (os) {
            case windows -> caps.setPlatform(Platform.WINDOWS);
            case linux -> caps.setPlatform(Platform.LINUX);
            default -> caps.setPlatform(Platform.WINDOWS);
        }
        Configuration.pageLoadTimeout = 10000;
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.48:4444/wd/hub"),caps);

        WebDriverRunner.setWebDriver(driver);

        open("https://litecart.stqa.ru/en/");
    }
    @AfterMethod
    public void methodTeardown() {
        Selenide.closeWebDriver();
    }

}
//Selenide.closeWindow()