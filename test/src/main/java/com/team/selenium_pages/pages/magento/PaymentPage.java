package com.team.selenium_pages.pages.magento;

import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//button[@class='action primary checkout']")
    WebElement placeOrderButton;

    public FinishedPurchasePage clickOnPlaceOrder() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
        js.executeScript("arguments[0].click();", placeOrderButton);
        return new FinishedPurchasePage();
    }
}
