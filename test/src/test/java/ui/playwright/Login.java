package ui.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.annotations.Test;

public class Login {

    @Test
    public void loginFields() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://the-internet.herokuapp.com/login");
        Locator userNameLocator=page.locator("id=username");
        userNameLocator.fill("tomsmith");
        page.locator("id=password").fill("SuperSecretPassword!");
        String userNameField = page.locator("//input[@id='username']").inputValue();
        PlaywrightAssertions.assertThat(userNameLocator).hasAttribute("name","username");
        page.locator("//button[@type='submit']").click();
        playwright.close();
    }


}
