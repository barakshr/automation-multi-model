package com.team.selenium_pages.pages.magento;

import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Item extends BasePage {
    private final WebElement item;

    By by = By.xpath("//button[@class='action tocart primary']");

    Item(WebElement item) {
        this.item = item;
    }

    public void addToCart() {
        WebElement addToCart = item.findElement(by);
        addToCart.click();
    }
}
