package ui.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;


import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Instant;

import static ui.playwright.MenuLocator.enterMenuOption;

public class ScreenShot extends BaseTest {

    @Test
    public void testScreenShot() {
        Page page = getPage();
        enterMenuOption("checkbox-demo", page);
        Page.ScreenshotOptions screenshotOptions = new Page.ScreenshotOptions();
        Timestamp ts = Timestamp.from(Instant.now());
        page.screenshot(screenshotOptions.setPath(Paths.get(String.format("./screenshot/%s.png", ts))));
    }

    @Test
    public void testLocatorScreenShot() {
        Page page = getPage();
        enterMenuOption("checkbox-demo", page);
        Locator locator = page.locator("id=header");
        locator.scrollIntoViewIfNeeded();
        Timestamp ts = Timestamp.from(Instant.now());
        locator.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get(String.format("./screenshot/%s.png", ts))));
    }


    @Test
    public void testName() {
    }
}
