package com.team.selenium_pages.pages.herokuapp;


import com.team.selenium.controls.elements.Dropdown;
import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;


public class DropdownPage extends BasePage {

    @FindBy(how = How.ID, using = "dropdown")
    private Dropdown dropdown;


    public DropdownPage selectFormDropdown(String option) {
        dropdown.selectFormDropdown(option);
        return this;
    }

    public List<String> getDropdownSelections() {
        return dropdown.getDropdownOptions();
    }
}
