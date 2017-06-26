package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by jnunez on 6/24/17.
 */
public class RanorexPage {

    WebDriver driver;

    @FindBy (id="FirstName")
    WebElement txtFirstName;

    @FindBy(id="LastName")
    WebElement txtLastName;

    @FindBy(how=How.ID, using = "Category")
    WebElement lstCategory;

    @FindBy(id="Gender")
    WebElement rbtGenderFemale;

    @FindBy(how=How.XPATH,using="(//input[@id='Gender'])[2]")
    WebElement rbtGenderMale;

    @FindBy(id="Add")
    WebElement btnAdd;

    //verification labels

    @FindBy(xpath = "//table[@id='VIPs']/tbody/tr[2]/td[2]")
    WebElement lblfirstName;

    @FindBy(xpath = "//table[@id='VIPs']/tbody/tr[2]/td[3]")
    WebElement lblLastName;

    @FindBy(xpath = "//table[@id='VIPs']/tbody/tr[2]/td[4]")
    WebElement lblGender;

    @FindBy(xpath = "//table[@id='VIPs']/tbody/tr[2]/td[5]")
    WebElement lblCategory;



    //Constructor
    public RanorexPage(WebDriver driver) {
        this.driver = driver;
    }

    //Action methods
    public void typeFirstName(String firstName) {
        txtFirstName.sendKeys(firstName);
    }

    public void typeLastName(String lastName) {
        txtLastName.sendKeys(lastName);
    }

    public void selectCategory (String category) {
        new Select(lstCategory).selectByVisibleText(category);
    }

    public void selectGender (String gender) {
        String s = gender.toLowerCase();
        if (s.equals("male")) {
            rbtGenderMale.click();
        } else if (s.equals("female")) {
            rbtGenderFemale.click();
        } else {
            System.out.println("Invalid gender");
        }
    }

    public void clickAdd() {
        btnAdd.click();
    }

    public void insertClient(String firstName, String lastName, String category,
                             String gender) {
        typeFirstName(firstName);
        typeLastName(lastName);
        selectCategory(category);
        selectGender(gender);
        clickAdd();
    }

    public boolean compareResult(String firstName, String lastName, String category,
                              String gender) {
        return this.lblfirstName.getText().equals(firstName) &
                this.lblLastName.getText().equals(lastName) &
                this.lblCategory.getText().equals(category) &
                this.lblGender.getText().equals(gender);

    }


}
