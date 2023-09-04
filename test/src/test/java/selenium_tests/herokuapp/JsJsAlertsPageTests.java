package selenium_tests.herokuapp;

import com.team.selenium_pages.pages.herokuapp.HomePage;
import com.team.selenium_pages.pages.herokuapp.JsAlertsPage;
import selenium_tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class JsJsAlertsPageTests extends BaseTest {

    @Test
    public void checkJsAlertText() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        HomePage homePage = new HomePage();
        String actualAlertMessage = homePage.selectLinkToPage("JavaScript Alerts")
                .goToPage(JsAlertsPage.class)
                .clickOnJsAlertButton()
                .getAlertText();
        Assert.assertEquals(actualAlertMessage, "I am a JS Alert");
    }

    @Test
    public void acceptJsAlert() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        HomePage homePage = new HomePage();
        String actualAlertMessage = homePage.selectLinkToPage("JavaScript Alerts")
                .goToPage(JsAlertsPage.class)
                .clickOnJsAlertButton()
                .acceptAlert()
                .verifyAlertClicked();
        Assert.assertEquals(actualAlertMessage, "You successfully clicked an alert");
    }




}
