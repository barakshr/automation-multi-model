package com.team.selenium.controls.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownImp extends ControlImpl implements Dropdown {

    private final Select dropdown;

    public DropdownImp(WebElement element) {
        super(element);
        this.dropdown = new Select(element);
    }


    public void selectFormDropdown(String selectionText) {
        dropdown.selectByValue(selectionText);
    }

    @Override
    public List<String> getDropdownOptions() {
        return dropdown.getAllSelectedOptions().stream().map(webElement -> webElement.getText()).collect(Collectors.toList());
    }

}
