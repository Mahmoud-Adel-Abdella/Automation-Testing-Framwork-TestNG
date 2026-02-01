package Tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        WebDriver originalDriver = new ChromeDriver();

        WebDriverListeners myListeners = new WebDriverListeners();
        driver = new EventFiringDecorator(myListeners).decorate(originalDriver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.automationexercise.com/login");
    }

    @BeforeMethod
    public void testUp() {
        faker = new Faker();
        softAssert = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }
}
