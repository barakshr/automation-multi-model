package com.team.selenium_pages.pages.magento.enums;

public enum Country {


    Israel("IL");

    private final String value;

    Country(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
