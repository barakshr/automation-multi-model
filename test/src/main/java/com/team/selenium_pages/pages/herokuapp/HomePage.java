package com.team.selenium_pages.pages.herokuapp;

import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(how = How.TAG_NAME, using = "a")
    List<WebElement> linksToPages;

    public HomePage selectLinkToPage(String page) {
        WebElement link = linksToPages.stream().filter(webElement -> webElement.getText().equals(page)).findFirst().get();
        link.click();
        return this;
    }



}
