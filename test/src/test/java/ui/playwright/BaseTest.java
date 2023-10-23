package ui.playwright;

import com.microsoft.playwright.*;
import com.team.selenium.properties.PropertiesHandler;
import com.team.selenium.properties.Settings;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;


public class BaseTest {

    private  Browser browser;
    private  Page page;

    private Playwright playwright;

    @BeforeTest
    public void setUp() throws IOException {
        PropertiesHandler.readProperties();
        this. playwright = Playwright.create();
        this.browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(Settings.HeadlessBrowser));
        this.page = browser.newPage();
        this.page.navigate(Settings.AUT);
    }

    @AfterTest
    public void tearDown(){
        page.close();
        browser.close();
        playwright.close();

    }

    public Browser getBrowser() {
        return browser;
    }

    public Page getPage() {
        return page;
    }
}
