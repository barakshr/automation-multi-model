package selenium_tests.herokuapp_experiments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class UploadFile {
    @Test
    public void upload_file() {
        By uploadButton = By.id("file-submit");
        By inputField = By.id("file-upload");

        WebDriverManager.firefoxdriver().setup();
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));


        webDriver.get("https://the-internet.herokuapp.com/upload");
        webDriver.findElement(inputField).sendKeys("/Users/barakshamir/Downloads/playwrightAndroid.png");
        webDriver.findElement(uploadButton).click();
    }
}
