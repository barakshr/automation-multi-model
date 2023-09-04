package selenium_tests.atlassian;

import com.team.selenium_pages.pages.atlassian.HomePage;
import com.team.selenium_pages.pages.atlassian.StartPage;
import selenium_tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;


public class LoginPageTests extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void setup() {
        homePage = new HomePage();
    }

    @Test
    public void failLoginWrongPassword() {
        String actualText = homePage
                .goToLoginPage()
                .login("nefonoj558@carpetra.com", "123")
                .getLoginFailure();
        String expectedText = "Incorrect email address and / or password. Do you need help logging in?";
        String actualEditedText = actualText.toLowerCase().replaceAll("\\s*", "");
        String expectedEditedText = expectedText.toLowerCase().replaceAll("\\s*", "");
        Assert.assertEquals(actualEditedText, expectedEditedText);
    }


    @Test
    public void loginSuccess() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        homePage.goToLoginPage()
                .login("nefonoj558@carpetra.com", "QAZwsx123")
                .goToPage(StartPage.class);
              //  .checkPageUrlAppear("start.atlassian.com");
    }
}
