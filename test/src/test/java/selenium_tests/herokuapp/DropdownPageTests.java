package selenium_tests.herokuapp;

import com.team.selenium_pages.pages.herokuapp.DropdownPage;
import com.team.selenium_pages.pages.herokuapp.HomePage;
import selenium_tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class DropdownPageTests extends BaseTest {

    @Test
    //use test params
    public void dropdown() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        HomePage homePage = new HomePage();
        List<String> selection = homePage
                .selectLinkToPage("Dropdown")
                .goToPage(DropdownPage.class)
                .selectFormDropdown("1")
                .getDropdownSelections();
        Assert.assertEquals(selection.size(), 1, "more or less then one selection");
        Assert.assertEquals(selection.get(0), "Option 1"," option 1 was not selected");

    }

}
