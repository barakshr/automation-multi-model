package ui.selenium.herokuapp;

import com.team.selenium_pages.pages.herokuapp.HomePage;
import ui.selenium.BaseTest;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void goToDropDown(){
        HomePage homePage= new HomePage();
        homePage.selectLinkToPage("Dropdown");
            //    .checkPageUrlAppear("https://the-internet.herokuapp.com/dropdown");
    }
}
