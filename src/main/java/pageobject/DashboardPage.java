package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by jnunez on 6/24/17.
 */
public class DashboardPage {
    WebDriver driver;

    @FindBy(xpath="//a[contains(@href, 'edit.php')])[2]")
    WebElement lblPostMenu;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPost() {
        lblPostMenu.click();
    }
}
