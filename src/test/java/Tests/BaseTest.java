package Tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import Utilities.WebDriverListeners;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;
    protected SoftAssert softAssert;
    protected Faker faker;

    @BeforeMethod(alwaysRun = true)
    public void setUpTest() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        WebDriverManager.chromedriver().setup();
        WebDriver originalDriver = new ChromeDriver(options);
        WebDriverListeners myListeners = new WebDriverListeners();
        driver = new EventFiringDecorator(myListeners).decorate(originalDriver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.daftra.com/");

        faker = new Faker();
        softAssert = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        softAssert.assertAll();

        if (driver != null) {
            driver.quit();
        }
    }

}
