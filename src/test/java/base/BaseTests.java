package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.AuthPage;
import utils.Util;

import java.util.concurrent.TimeUnit;


public class BaseTests {
    private WebDriver driver;

    protected AuthPage authPage;
    @BeforeClass
    public void setUp()throws Exception{
        WebDriverManager.firefoxdriver().setup();
        driver  =new FirefoxDriver();
        driver.manage().window().minimize();
        driver.manage().timeouts().implicitlyWait(Util.WAIT_TIME, TimeUnit.SECONDS);
        goHome();
    }
    @BeforeMethod
    public void goHome(){
        driver.get(Util.BASE_URL);
        authPage = new AuthPage(driver);
    }


}
