package ui.playwright;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class Hover {

    @Test
    public void launch() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/");
        Locator locator = page.locator("//a[@href='/hovers']");
        locator.click();
        Locator userOneLocator = page.locator("//div[@id='content']/div/div[1]/img");
        userOneLocator.hover();
        Locator userOne = page.locator("//div[@id='content']/div/div[1]/div/h5");
        String text = userOne.textContent();
        page.close();
        browser.close();
    }
}
