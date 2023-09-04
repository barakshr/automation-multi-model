package com.team.selenium_pages.pages.herokuapp;

import com.team.selenium.controls.elements.Slider;
import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HorizontalSliderPage extends BasePage {

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/div/input")
    Slider sliderButton;

    @FindBy(how = How.ID, using = "range")
    WebElement sliderRange;


    public HorizontalSliderPage moveHorizontalSliderWithArrows(int toRange) {
        sliderButton.click();
        float currentRange = Float.parseFloat(sliderRange.getText());
        float steps = (toRange - currentRange) * 2;
        Keys arrowMovement ;
        if (steps < 0) {
            arrowMovement = Keys.ARROW_LEFT;
            steps *= -1;
        } else {
            arrowMovement = Keys.ARROW_RIGHT;
        }
        sliderButton.moveSliderWithArrow(arrowMovement,steps);
        return this;
    }

    public String getSliderRange() {
        return sliderRange.getText();
    }
}
