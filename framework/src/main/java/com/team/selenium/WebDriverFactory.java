package com.team.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class  WebDriverFactory {

    private final static Logger logger = LogManager.getLogger(WebDriverFactory.class);

    public static void openNewWebDriver(BrowserType browserType) throws Exception {
        String path = System.getProperty("user.dir") + "/src/main/resources/drivers/";
        WebDriver webDriver = null;
        //TODO: hard coded settings, should be in config file
        switch (browserType) {
            case Firefox:
                FirefoxProfile profile = new ProfilesIni().getProfile("default");
                profile.setPreference("network.cookie.cookieBehavior", 1);
                FirefoxOptions options = new FirefoxOptions();
                options.setProfile(profile);
                String userAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 16_3_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.3 Mobile/15E148 Safari/604.1";
                options.addPreference("general.useragent.override", userAgent);
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver(options);
                break;
            case Chrome:
                ChromeOptions chromeOptions = new ChromeOptions();
                Map<String, Object> prefs = new HashMap();
                prefs.put("profile.cookie_controls_mode", 1);
                chromeOptions.setExperimentalOption("prefs", prefs);
                System.setProperty("webdriver.chrome.driver", path + "chromedriver");
                ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
                webDriver = chromeDriver;
                break;

            case IE:
                throw new Exception("IE not web driver not implemented");
        }
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7));
        webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(3));
        DriverPool.getInstance().setDriver(Thread.currentThread().getId(), webDriver);
    }

}
