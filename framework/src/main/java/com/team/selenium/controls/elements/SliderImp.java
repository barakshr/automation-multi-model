package com.team.selenium.controls.elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SliderImp extends ControlImpl implements Slider {


    public SliderImp(WebElement element) {
        super(element);
    }

    @Override
    public void moveSliderWithArrow(Keys arrowKey, float numberOfPress) {
        for (int i = 0; i < numberOfPress; i++) {
            getWrappedElement().sendKeys(arrowKey);
        }
    }
}
