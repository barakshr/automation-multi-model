package com.team.selenium_pages.pages.magento;

import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FinishedPurchasePage extends BasePage {


    @FindBy(how = How.CLASS_NAME, using = "checkout-success")
    WebElement checkoutSuccess;


    public String getOrderId() throws Exception {
        getElementWait().waitForVisibilityOf(checkoutSuccess, Duration.ofSeconds(6));
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(checkoutSuccess.getText());
        if (matcher.find()) {
            return matcher.group(0);
        }
        throw new Exception("order id not found");
    }
}
