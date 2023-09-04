package ui.selenium.herokuapp_experiments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Scroll {
    @Test
    public void scrollIntoView() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
        webDriver.get("http://the-internet.herokuapp.com/large");
        WebElement webElement = webDriver.findElement(By.id("large-table"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webElement);
    }
}
