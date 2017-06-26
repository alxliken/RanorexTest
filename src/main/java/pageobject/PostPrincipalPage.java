package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by jnunez on 6/24/17.
 */
public class PostPrincipalPage {
    WebDriver driver;

    @FindBy(xpath="xpath=(//a[contains(text(),'Add New')])[7]")
    WebElement lblAddNew;

    //Constructor
    public PostPrincipalPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddNew(){
        lblAddNew.click();
    }
}
