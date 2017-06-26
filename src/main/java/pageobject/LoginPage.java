package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by jnunez on 6/24/17.
 */
public class LoginPage {
    WebDriver driver;

    @FindBy(id="user_login")
    WebElement txtUsername;

    @FindBy(id="user_pass")
    WebElement txtPassword;

    @FindBy(id="wp-submit")
    WebElement btnSubmit;

    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Action methods
    public void typeUsername(String username) {
        txtUsername.sendKeys(username);
    }

    public void typePassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {
        btnSubmit.click();
    }

    public void insertLoginData(String username, String password){
        typeUsername(username);
        typePassword(password);
        clickLogin();
    }
}