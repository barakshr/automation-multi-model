package selenium_tests.herokuapp_experiments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseExperiment {

    private  WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.firefoxdriver().setup();
        this.webDriver = new FirefoxDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(6));
        webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(3));
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    @AfterMethod
    public void tearDown(){
        webDriver.close();
    }
}
