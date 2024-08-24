package com.team.selenium_pages.pages.herokuapp.DynamicWait;


import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

public class ElementPageIsHidden extends BasePage {

    @FindBy(how = How.XPATH, using = "//div[@id='start']/button")
    WebElement startButton;

    @FindBy(how = How.ID, using = "finish")
    WebElement finish;

    public void press() {
        startButton.getText();
        startButton.click();
        getElementWait().waitForClickable(finish,Duration.ofSeconds(30));
        finish.getText();
    }


}
