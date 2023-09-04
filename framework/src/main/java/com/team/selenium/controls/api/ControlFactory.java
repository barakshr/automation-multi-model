package com.team.selenium.controls.api;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;


public class ControlFactory extends PageFactory {

    public static void initElements(WebDriver driver, Object page) {
        PageFactory.initElements(new ControlFieldDecorator(new DefaultElementLocatorFactory(driver)), page);
    }
}
