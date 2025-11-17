package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By emailInputLocator = By.cssSelector("[id=\"Email\"]");
    private final By passwordInputLocator = By.cssSelector("[id=\"Password\"]");
    private final By loginBtnLocator = By.cssSelector("[class=\"button-1 login-button\"]");

    //Actions
    public void fillEmail(String email) {
        write(emailInputLocator, email);
        //Welcome
    }

    public void fillPassword(String password) {
        write(passwordInputLocator, password);
    }

    public void submitLoginForm() {
        myClick(loginBtnLocator);
    }
}
