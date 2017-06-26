package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by jnunez on 6/24/17.
 */
public class NewPostPage {
    WebDriver driver;

    @FindBy(xpath="//div[@id='wpbody-content']/div[4]/h2")
    WebElement lblNewPost;

    public NewPostPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddPost() {
        lblNewPost.click();
    }
}
