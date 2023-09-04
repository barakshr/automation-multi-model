package com.team.selenium_pages.pages.magento;


import com.team.selenium.controls.elements.Dropdown;
import com.team.selenium_pages.pages.BasePage;
import com.team.selenium_pages.pages.magento.enums.CustomerDetailsPageTextField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.Duration;

public class CustomerDetailsPage extends BasePage {

    private static final String textField = "//input[@name='%s']";


    @FindBy(how = How.XPATH, using = "//select[@name='country_id']")
    Dropdown stateDropDown;

    @FindBy(how = How.XPATH, using = "//input[@id='customer-email']")
    WebElement emailAddressTextBox;


    @FindBy(how = How.XPATH, using = "//button[@class='button action continue primary']")
    WebElement nextButton;


    @FindBy(how = How.XPATH, using = "//input[@value='flatrate_flatrate']")
    WebElement flatRateShipmentCheckBox;


    public CustomerDetailsPage waitForPageToLoad(Duration duration) {
        getElementWait().waitForVisibilityOf(stateDropDown, duration);
        return this;
    }

    public CustomerDetailsPage enterToTextBox(CustomerDetailsPageTextField CustomerDetailsPageTextField, String value) {
        String textFieldString = String.format(textField, CustomerDetailsPageTextField.getValue());
        WebElement webElement = getWebDriver().findElement(By.xpath(textFieldString));
        webElement.sendKeys(value);
        return this;
    }


    public CustomerDetailsPage enterEmailAddress(String emailAddress) {
        emailAddressTextBox.sendKeys(emailAddress);
        return this;
    }

    public CustomerDetailsPage selectCountry(String country) throws InterruptedException {
        getElementWait().waitForClickable(stateDropDown, Duration.ofSeconds(4));
        //TODO - sleep should be removed
        Thread.sleep(1000);
        stateDropDown.selectFormDropdown(country);
        return this;
    }

    public CustomerDetailsPage setRateShipment() {
        flatRateShipmentCheckBox.click();
        return this;
    }

    public CustomerDetailsPage clickOnNext() {
        getElementWait().waitForClickable(nextButton, Duration.ofSeconds(3));
        nextButton.click();
        return this;
    }

}
