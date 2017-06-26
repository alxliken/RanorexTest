package test;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pageobject.RanorexPage;

public class RanorexTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private RanorexPage ranorexPage;

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.ranorex.com/web-testing-examples/vip/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    ranorexPage = PageFactory.initElements(driver, RanorexPage.class);
    driver.get(baseUrl);

  }

  @Test
  public void testRanorex() throws Exception {

    /*
    ranorexPage.typeFirstName("Juan");
    ranorexPage.typeLastName("Perez");
    ranorexPage.selectCategory("Other");
    ranorexPage.selectGender("male");
    ranorexPage.clickAdd();
    */

    ranorexPage.insertClient("Juan", "Perez", "Other", "male");

    assertTrue(ranorexPage.compareResult("Juan", "Perez", "Other", "Male"));

    // verifyText | id=count | VIP count: 1
    try {
      assertEquals("VIP count: 1", driver.findElement(By.id("count")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }



  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }



}
