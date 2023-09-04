package selenium_tests.atlassian;


import com.team.selenium_pages.pages.atlassian.HomePage;
import com.team.selenium_pages.pages.atlassian.StartPage;
import selenium_tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;


public class StartPageTests extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void setup(){
        homePage= new HomePage();
    }

    @Test
    public void filterResults() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String actualFilterResults = homePage.goToLoginPage()
                .login("nefonoj558@carpetra.com", "QAZwsx123").
                goToPage(StartPage.class)
                .filterByTitle("abc")
                .getFilterResults();

        String expectedFilterResults = "We couldn't find any recent work matching your search Try again with a different term.";
        String actualEditedText = actualFilterResults.toLowerCase().replaceAll("\\s*", "");
        String expectedEditedText = expectedFilterResults.toLowerCase().replaceAll("\\s*", "");
        Assert.assertEquals(actualEditedText, expectedEditedText);
    }

}
