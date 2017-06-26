package test;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pageobject.LoginPage;
import pageobject.DashboardPage;
import pageobject.NewPostPage;
import pageobject.PostPrincipalPage;
import sun.jvm.hotspot.debugger.Page;

import java.util.concurrent.TimeUnit;

/**
 * Created by jnunez on 6/24/17.
 */
public class WordPressTest {

    private WebDriver driver;
    private String baseUrl;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private PostPrincipalPage postPrincipalPage;
    private NewPostPage newPostPage;

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://demosite.center/wordpress/wp-login.php";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        postPrincipalPage = PageFactory.initElements(driver, PostPrincipalPage.class);
        newPostPage = PageFactory.initElements(driver, NewPostPage.class);
        driver.get(baseUrl);

    }

    @Test
    public void loginTest() throws Exception {
        loginPage.insertLoginData("admin","demo123");
    }

    @Test
    public void createDraft() throws Exception {
        loginPage.insertLoginData("admin","demo123");
        dashboardPage.clickPost();
        postPrincipalPage.clickAddNew();
        newPostPage.clickAddPost();

    }



    }
