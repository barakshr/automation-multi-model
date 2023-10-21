package ui.playwright;

import com.microsoft.playwright.Page;
import com.team.selenium.properties.Settings;

public class MenuLocator {

    static void enterMenuOption(String menu, Page page) {

        String locatorString = String.format("//a[@href='%s/%s']", Settings.AUT, menu);
        page.locator(locatorString).click();
    }
}
