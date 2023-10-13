package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPage {
    private WebDriver driver;
    private By userID = By.xpath("//td/input[@name='uid']");
    private By password = By.cssSelector("input[name='password']");
    private By loginButton = By.cssSelector("input[name='btnLogin']");
    public AuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setId(String text){
        driver.findElement(userID).sendKeys(text);
    }

    public void setPassword(String text){
        driver.findElement(password).sendKeys(text);
    }

    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }

    public HomePage homePage(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }



}
