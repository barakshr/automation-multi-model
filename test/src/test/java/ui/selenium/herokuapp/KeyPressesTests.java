package ui.selenium.herokuapp;

import com.team.selenium_pages.pages.herokuapp.HomePage;
import com.team.selenium_pages.pages.herokuapp.KeyPressesPage;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import ui.selenium.BaseTest;

import java.lang.reflect.InvocationTargetException;

public class KeyPressesTests extends BaseTest {

    @Test
    public void enterDollarSignToTextBox() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        HomePage homePage = new HomePage();
        String actualTest = homePage
                .selectLinkToPage("Key Presses")
                .goToPage(KeyPressesPage.class)
                .enterText(Keys.chord(Keys.SHIFT, "4"))
                .getTextInTextBox();
    }
}
