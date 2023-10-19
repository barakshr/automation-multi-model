package ui.playwright;


import com.microsoft.playwright.Page;
import com.team.selenium.properties.Settings;
import org.testng.annotations.Test;

public class Checkbox extends BaseTest {


    @Test
    public void testCheckbox() {
        Page page = getPage();
        String locatorString=getLocatorString("checkbox-demo");
        page.locator(locatorString).click();
        page.locator("id=isAgeSelected").click();
    }


    private String getLocatorString(String menu){
        return String.format("//a[@href='%s/%s']", Settings.AUT,menu);
    }
}
