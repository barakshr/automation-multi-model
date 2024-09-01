package com.team.selenium_pages.pages.herokuapp.hover;

import com.team.selenium_pages.pages.herokuapp.ViewProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FigureCaptionElement {

    private static final By figureCaptionName= By.tagName("h5");
    private static final By figureCaptionLink= By.linkText("View profile");

    private final WebElement webElement;

    FigureCaptionElement(WebElement webElement){
        this.webElement=webElement;
    }

    public String getProfileName(){
        return webElement.findElement(figureCaptionName).getText();
    }

    public ViewProfilePage clickOnProfile(){
        webElement.findElement(figureCaptionLink).click();
        return new ViewProfilePage();
    }
}
