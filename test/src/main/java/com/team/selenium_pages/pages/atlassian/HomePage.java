package com.team.selenium_pages.pages.atlassian;


import com.team.selenium_pages.pages.BasePage;
//import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//a[@data-label='Work Management']")
    private WebElement workManagementButton;

    @FindBy(how = How.CLASS_NAME, using = "css-q68uj")
    private WebElement myAccountButton;

    @FindBy(how = How.XPATH, using = "//div[@id='uid1']/div/div/div/div")
    private WebElement loginButton;

   // @Step("click on work management button")
    public WorkManagementPage goToWorkManagement() {
        getLogger().info("clickOnWorkManagement button");
        getElementWait().waitForVisibilityOf(workManagementButton, Duration.ofSeconds(10));
        workManagementButton.click();
        return new WorkManagementPage();
    }

  //  @Step("go to login page")
    public LoginPage goToLoginPage() {
        myAccountButton.click();
        getLogger().info("click login button");
        loginButton.click();
        return new LoginPage();
    }

}
