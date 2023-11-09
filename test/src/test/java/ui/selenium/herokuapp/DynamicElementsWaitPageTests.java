package ui.selenium.herokuapp;

import com.team.selenium_pages.pages.herokuapp.DynamicWait.DynamicLoadingPage;
import com.team.selenium_pages.pages.herokuapp.HomePage;
import ui.selenium.BaseTest;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class DynamicElementsWaitPageTests extends BaseTest {


    @Test
    public void dWait() throws  InstantiationException, IllegalAccessException {
        HomePage homePage = new HomePage();
        homePage
                .selectLinkToPage("Dynamic Loading")
                .goToPage(DynamicLoadingPage.class)
                .goToElementRenderedAfterTheFact()
                .press();
    }

}
