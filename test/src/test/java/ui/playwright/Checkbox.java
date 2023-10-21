package ui.playwright;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.testng.annotations.Test;

import static ui.playwright.MenuLocator.enterMenuOption;

public class Checkbox extends BaseTest {

    @Test
    public void testCheckbox() {
        Page page = getPage();
        enterMenuOption("checkbox-demo",page);
        Locator checkbox = page.locator("id=isAgeSelected");
        checkbox.click();
        PlaywrightAssertions.assertThat(checkbox).isChecked();
    }
}
