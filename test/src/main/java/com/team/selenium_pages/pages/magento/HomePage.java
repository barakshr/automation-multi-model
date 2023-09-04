package com.team.selenium_pages.pages.magento;

import com.team.selenium_pages.pages.BasePage;
import com.team.selenium_pages.pages.magento.enums.PurchasingCategory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    private static final String category = "//span[text()='%s']";

    @FindBy(how = How.CLASS_NAME, using = "navigation")
    WebElement topMenuBar;

    public HomePage hoverOnCategory(PurchasingCategory categoryEnum) {
        String selectedCategory = String.format(category, categoryEnum.name());
        WebElement elementCategory = topMenuBar.findElement(By.xpath(selectedCategory));
        getActions().moveToElement(elementCategory).perform();
        return this;
    }


    public CategoryPage enterToCategory(PurchasingCategory purchasingCategory) {
        String selectedCategory = String.format(category, purchasingCategory);
        WebElement elementCategory = topMenuBar.findElement(By.xpath(selectedCategory));
        elementCategory.click();
        return new CategoryPage();
    }
}