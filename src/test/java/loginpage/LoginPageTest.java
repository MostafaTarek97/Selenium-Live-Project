package loginpage;

import base.BaseTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.DataProviderAnnotation;
import utils.ReadXLSData;
import utils.Util;


import java.io.IOException;

import static org.testng.Assert.*;

public class LoginPageTest extends BaseTests {
    private WebDriver driver;


     //Verify login functionality with valid username and password
    @Test
    public void testLoginPage(){
        authPage.setId(Util.VALID_USERNAME);
        authPage.setPassword(Util.VALID_PASSWORD);
        HomePage homePage = authPage.homePage();
        var text= homePage.getManagerIdText();
        assertTrue(text.contains(Util.VALID_USERNAME),"Error Message: There is no Manager ID ");
        assertEquals(homePage.getHomePageTitle(),Util.EXPECT_TITLE, "Title is in correct");
    }
    // //Verify login functionality by reading from Exel Sheet
    @Test(dataProviderClass = ReadXLSData.class,dataProvider = "testData")
    public void testLoginWithExelSheet(String username , String password){
        authPage.setId(username);
        authPage.setPassword(password);
        HomePage homePage = authPage.homePage();
        try {
            String error_Message = authPage.alert_getText();
            authPage.alert_clickToAccept();
            assertEquals(error_Message,Util.ALERT_MESSAGE ,"Alert message is in correct" );
        }catch (Exception e){
            assertEquals(homePage.getHomePageTitle(),Util.EXPECT_TITLE, "Title is in correct");
        }
    }


    //Verify login functionality with Data provider
    @Test(dataProviderClass = DataProviderAnnotation.class,dataProvider = "testLoginWithDataProvider")
    public void testLoginWithDataProvider(String username, String password) throws IOException {
        authPage.setId(username);
        authPage.setPassword(password);
        HomePage homePage = authPage.homePage();
        try {
            String error_Message = authPage.alert_getText();
            authPage.alert_clickToAccept();
            assertEquals(error_Message,Util.ALERT_MESSAGE ,"Alert message is in correct" );
        }catch (Exception e){
            var text= homePage.getManagerIdText();
            homePage.takeIDOutputScreenshot();
            assertTrue(text.contains(username),"Error Message: There is no Manager ID ");
            //assertEquals(homePage.getHomePageTitle(),Util.EXPECT_TITLE, "Title is in correct");
        }

    }


}
