package com.team.selenium_pages.pages.herokuapp;


import com.team.selenium.controls.elements.Dropdown;
import com.team.selenium_pages.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;


import java.util.List;
import java.util.stream.Collectors;


public class DropdownPage extends BasePage {

    @FindBy(how = How.ID, using = "dropdown")
    private WebElement dropdown;


    public DropdownPage selectFormDropdown(String option) {
        Select dropDownSelect = new Select(dropdown);
        dropDownSelect.selectByValue(option);
        return this;
    }

    public List<String> getDropdownSelections() {
        Select dropDownSelect = new Select(dropdown);
      return  dropDownSelect.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
