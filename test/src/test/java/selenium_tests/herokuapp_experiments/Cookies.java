package selenium_tests.herokuapp_experiments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Cookies {
    @Test
    public void setCookie() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver webDriver = new FirefoxDriver();
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        webDriver.manage().addCookie(cookie);
    }
}
