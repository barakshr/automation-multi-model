package com.team.selenium_pages.pages.herokuapp.DynamicWait;


import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

public class ElementRenderedAfterTheFactPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@id='start']/button")
    WebElement startButton;

    @FindBy(how = How.ID, using = "finish")
    WebElement finish;

    public void press() {
        startButton.getText();
        startButton.click();
     //   WebElement finish=   getWebDriver().findElement(By.id("finish"));
        getElementWait().waitForVisibilityOf(finish,Duration.ofSeconds(30));
        finish.getText();
    }

}
