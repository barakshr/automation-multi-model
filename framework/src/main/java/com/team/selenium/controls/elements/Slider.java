package com.team.selenium.controls.elements;

import com.team.selenium.controls.api.ImplementedBy;
import org.openqa.selenium.Keys;

@ImplementedBy(SliderImp.class)
public interface Slider extends Control {

    void moveSliderWithArrow(Keys arrowKey, float numberOfPress);
}
