package ui.playwright;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.Test;

import static ui.playwright.MenuLocator.enterMenuOption;

public class DropDown extends BaseTest {

    @Test
    public void testDropDown() {
        Page page = getPage();
        enterMenuOption("select-dropdown-demo", page);
        Locator dropDownLocator = page.locator("id=select-demo");
        dropDownLocator.selectOption("Sunday");
        PlaywrightAssertions.assertThat(dropDownLocator).containsText("Sunday");

        dropDownLocator.selectOption(new SelectOption().setIndex(2));
        PlaywrightAssertions.assertThat(dropDownLocator).containsText("Monday");
    }

    @Test
    public void testMultiSelect() {
        Page page = getPage();
        enterMenuOption("select-dropdown-demo", page);
        Locator multiSelect = page.locator("//select[@name='States']");
        // List<String> allOptions = multiSelect.locator("option").allInnerTexts();
        multiSelect.selectOption(new String[]{"New York", "Texas"});
    }
}
