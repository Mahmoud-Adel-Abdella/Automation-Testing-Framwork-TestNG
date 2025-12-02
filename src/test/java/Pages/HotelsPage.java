package Pages;

import Utilities.ClickUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import javax.swing.event.CaretListener;

public class HotelsPage extends BasePage{
    public HotelsPage(WebDriver driver) {
        super(driver);
    }

    private final By starRatesLocator = By.xpath("(//div[@class='p-checkbox-box'])[2]");
    private final By hotelsNameLocator = By.cssSelector("[class=\"search-list__content-hotels ng-star-inserted\"] almatar-hotel-card [class=\"hotel-item__head\"] h3");
    private final By hotelsPricesLocator = By.cssSelector("[class=\"search-list__content-hotels ng-star-inserted\"] almatar-hotel-card [class=\"hotel-item__prices--current ng-star-inserted\"]");


    public void setStarRate(){
        ClickUtils.guaranteedClick(By.cssSelector("[class=\"rivi-info__action\"]"));
        ClickUtils.guaranteedClick(starRatesLocator);
    }

    public void printHotelsDetails(){
        String[] hotelsNames = getElementsText(hotelsNameLocator);
        String[] hotelsPrices = getElementsText(hotelsPricesLocator);

        System.out.println("============= Hotels Details =============");
        for (int i = 0 ; i < hotelsPrices.length ; i++ ){
            System.out.println(i+1 + " Hotel Name: " + hotelsNames[i] + " Price: " +hotelsPrices[i]);
        }
    }
}
