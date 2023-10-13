package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class HomePage {
    private WebDriver driver;
    private By managerIdText= By.xpath("//tr/td[@style='color: green']");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public String getManagerIdText(){
        return driver.findElement(managerIdText).getText();
    }
    public String getHomePageTitle(){
        return driver.getTitle();
    }

    public void takeIDOutputScreenshot() throws IOException {
        WebElement managerIDOutput = driver.findElement
                (managerIdText);
        File source = managerIDOutput.getScreenshotAs(OutputType.FILE);
        File destination = new File("src\\test\\screenshot\\ID Output.png");
        FileHandler.copy(source, destination);
    }
}
