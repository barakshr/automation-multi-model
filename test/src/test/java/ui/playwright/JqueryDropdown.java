package ui.playwright;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.annotations.Test;

import static ui.playwright.MenuLocator.enterMenuOption;

public class JqueryDropdown extends BaseTest {

    @Test
    public void testDropDown() {
        Page page = getPage();
        enterMenuOption("jquery-dropdown-search-demo", page);
        Locator dropDown = page.locator("//span[@class='select2 select2-container select2-container--default']").first();
        dropDown.click();


        //**** filter list with playwright ***/
        Locator country = page.locator("//ul[@id='select2-country-results']/li", new Page.LocatorOptions().setHasText("India"));
        country.click();


    }

    @Test
    public void tesMultiDropDown() {
        Page page = getPage();
        enterMenuOption("jquery-dropdown-search-demo", page);
        Locator multiDropDown = page.locator("//input[@class='select2-search__field']");
        multiDropDown.click();
        page.locator("//li[@class='select2-results__option']", new Page.LocatorOptions().setHasText("Alaska")).click();
        multiDropDown.click();
        page.locator("//li[@class='select2-results__option']", new Page.LocatorOptions().setHasText("Maine")).click();
    }

    @Test
    public void testName() {
        Page page = getPage();
        enterMenuOption("jquery-dropdown-search-demo", page);
        page.locator("select[name='files']").selectOption("Java");
    }
}
