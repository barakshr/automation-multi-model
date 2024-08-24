package selenium_tests.herokuapp;

import com.team.selenium_pages.pages.herokuapp.DynamicWait.DynamicLoadingPage;
import com.team.selenium_pages.pages.herokuapp.HomePage;
import selenium_tests.BaseTest;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class DynamicElementsWaitPageTests extends BaseTest {


    @Test
    public void dWaitExample1() throws InstantiationException, IllegalAccessException {
        HomePage homePage = new HomePage();
        homePage
                .selectLinkToPage("Dynamic Loading")
                .goToPage(DynamicLoadingPage.class)
                .goToElementOnPageIsHidden()
                .press();
    }

    @Test
    public void dWaitExample2() throws InstantiationException, IllegalAccessException {
        HomePage homePage = new HomePage();
        homePage
                .selectLinkToPage("Dynamic Loading")
                .goToPage(DynamicLoadingPage.class)
                .goToElementRenderedAfterTheFact()
                .press();
    }



}
