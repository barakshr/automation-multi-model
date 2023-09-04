package selenium_tests.herokuapp_experiments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class JsAlert {
    @Test
    public void rightClick_context_menu_and_accept_js_alert() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));

        webDriver.get("  https://the-internet.herokuapp.com/context_menu");
        WebElement webElement = webDriver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(webDriver);
        //move to element
        actions.moveToElement(webElement);
        //right click
        actions.contextClick().perform();
        //accept alert
        webDriver.switchTo().alert().accept();
    }
}
