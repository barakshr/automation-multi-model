package selenium_tests.atlassian;

import com.team.selenium_pages.pages.atlassian.HomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium_tests.BaseTest;

import java.lang.reflect.InvocationTargetException;

public class HomePageTests extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void setup(){
        homePage= new HomePage();
    }
    @Test
    public void goToWorkManagement() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        homePage
                .goToWorkManagement();
                //.checkPageUrlAppear("www.atlassian.com/?tab=work-management");
    }
}
