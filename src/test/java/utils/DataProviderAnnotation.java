package utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class DataProviderAnnotation {

    @DataProvider(name ="testLoginWithDataProvider")
    public Object[][] dpMethod(){
        return new Object[][]{
                {"mngr531736","tAnAgaj"},
                {"mngr531736","mostafa32"},
                {"mostafa12","tAnAgaj"},
                {"mostafa12","mostafa32"},
                {"mngr531736","tAnAgaj"}};
        };
    }

