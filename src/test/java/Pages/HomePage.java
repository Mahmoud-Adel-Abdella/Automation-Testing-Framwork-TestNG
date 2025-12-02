package Pages;

import Utilities.ClickUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By ADPanelCloseBtnLocator = By.xpath("//div[@id='close-button-1454703513200']//*[name()='svg']");
    private final By cookiesAcceptBtnLocator = By.cssSelector("a[aria-label='allow cookies']");

    private final By languageSwitcherLocator = By.xpath("//section[@class='menu']//div[@class='menu__language menu__item']//a");
    private final By hotelsLabelLocator = By.xpath("//a[@id='ngb-nav-0']");
    private final By flightsLabelLocator = By.xpath("//a[@id='ngb-nav-1']");

    private final By flightsTabLocator = By.cssSelector("[class=\"navbar--main-pages\"] [href=\"/en/flights/\"]");
    private final By flightsSearchFormLocator = By.cssSelector("[class=\"almatar-search-forms\"]");

    private final By staysTabLocator = By.cssSelector("[class=\"navbar--main-pages\"] [href=\"/en/hotels/\"]");
    private final By destinationLocator = By.cssSelector("[class=\"auto-compelete-container home\"] input");
    private final By startDateLocator = By.xpath("(//span[@class='p-ripple p-element ng-tns-c3821894747-1 ng-star-inserted'][normalize-space()='25'])");
    private final By endDateLocator = By.xpath("(//span[@class='p-ripple p-element ng-tns-c3821894747-1 ng-star-inserted'][normalize-space()='29'])");
    private final By calenderLocator = By.cssSelector("[class=\"almatar-calendar__value\"]:nth-child(1)");
    private final By dropdownBtnLocator = By.cssSelector("[class=\"dropdown__item panel-mobile-overlay\"]");
    private final By childIncBtnLocator = By.xpath("(//almatar-icon[@name='plus'])[2]");
    private final By child1AgeLocator = By.xpath("(//span[@class='ng-arrow-wrapper'])[2]");
    private final By child1AgeSelectorLocator = By.xpath("(//span[@class='children-age__text ng-star-inserted'][contains(text(),'2')])[1]");
    private final By child2AgeLocator = By.xpath("(//span[@class='ng-arrow-wrapper'])[3]");
    private final By child2AgeSelectorLocator = By.xpath("(//span[@class='children-age__text ng-star-inserted'][contains(text(),'2')])[2]");
    private final By applyBtnLocator = By.cssSelector("div[class='edit-search-sheet__action'] button[type='button']");
    private final By staysSearchBtnLocator = By.cssSelector("button[type='submit']");


    public void acceptCookies() {
        checkCookies(cookiesAcceptBtnLocator);
    }

    public void closeAD() {
        checkCookies(ADPanelCloseBtnLocator);
    }

    public void switchLanguageToArabic(){
        ClickUtils.guaranteedClick(languageSwitcherLocator);
    }

    public String[] verifySwitchLanguage() {
        return new String[]{
                read(hotelsLabelLocator),
                read(flightsLabelLocator)
        };
    }

    public boolean verifyFlightSearchForm (){
        ClickUtils.guaranteedClick(flightsTabLocator);
        return driver.findElement(flightsSearchFormLocator).isDisplayed();
    }

    public void fillStaysForm(String destination , int child1Age , int child2Age) throws InterruptedException {
        write(destinationLocator , destination);
        Thread.sleep(2000);
        actions.sendKeys(Keys.ENTER).perform();

        ClickUtils.guaranteedClick(calenderLocator);
        ClickUtils.guaranteedClick(startDateLocator);
        ClickUtils.guaranteedClick(endDateLocator);
        actions.sendKeys(Keys.ESCAPE).perform();

        ClickUtils.guaranteedClick(dropdownBtnLocator);
        ClickUtils.guaranteedClick(childIncBtnLocator);
        ClickUtils.guaranteedClick(childIncBtnLocator);

        ClickUtils.guaranteedClick(child1AgeLocator);
        ClickUtils.guaranteedClick(child1AgeSelectorLocator);

        ClickUtils.guaranteedClick(child2AgeLocator);
        ClickUtils.guaranteedClick(child2AgeSelectorLocator);

        ClickUtils.guaranteedClick(applyBtnLocator);
        ClickUtils.guaranteedClick(staysSearchBtnLocator);
    }
}
